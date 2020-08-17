package com.aplova.productimagesautouploader.services;

import com.aplova.productimagesautouploader.dao.BusinessDaoInterface;
import com.aplova.productimagesautouploader.dao.ProductDaoInterface;
import com.aplova.productimagesautouploader.model.BusinessData;
import com.aplova.productimagesautouploader.model.MainResponseDetails;
import com.aplova.productimagesautouploader.model.ProductData;
import com.aplova.productimagesautouploader.model.ResponseDetails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
@PropertySource("classpath:configuration.properties")
public class MainService {
    private static final Logger logger = LogManager.getLogger(MainService.class);
    private final SearchLogic searchLogic;
    private final ThumbnailGenerator thumbnailGenerator;
    private final ProductDaoInterface productDaoInterface;
    private final BusinessDaoInterface businessDaoInterface;

    @Value("${baseImageUrl}")
    private String imageUrl;
    @Value("${baseThumbnailUrl}")
    private String thumbnailUrl;

    @Autowired
    public MainService(SearchLogic searchLogic,
                       ThumbnailGenerator thumbnailGenerator,
                       ProductDaoInterface productDaoInterface,
                       BusinessDaoInterface businessDaoInterface) {
        this.searchLogic = searchLogic;
        this.thumbnailGenerator = thumbnailGenerator;
        this.productDaoInterface = productDaoInterface;
        this.businessDaoInterface = businessDaoInterface;
    }

    public MainResponseDetails findBestMatchImagePath(String businessId, String path, String thumbnailPath){
        businessDaoInterface.findById(businessId).orElseThrow(() ->
            new NullPointerException("Business not found")
        );

        try {
            List<ResponseDetails> imageThumbnailAddedProducts = new ArrayList<>();
            List<ResponseDetails> onlyImagesAddedProducts = new ArrayList<>();
            List<ResponseDetails> imagesThumbnailNotAddedProducts = new ArrayList<>();
            List<ResponseDetails> imagesThumbnailExistingProducts = new ArrayList<>();
            MainResponseDetails response = new MainResponseDetails(businessId);

            List<ProductData> productData = productDaoInterface.findAllProductNotHavingImage(businessId);
            if (productData.isEmpty()){
                throw new NullPointerException("There is no products found");
            }
            List<String> images = listFilesUsingDirectoryStream(path);
            if (images.isEmpty()){
                throw new NullPointerException("No images found in the directory");
            }
            List<String> thumbnails = listFilesUsingDirectoryStream(thumbnailPath);
            if (thumbnails.isEmpty()){
                thumbnails.add("default.jpg");
            }

            for (ProductData product : productData) {
                List<String> imageListForSave = new ArrayList<>();
                List<String> thumbnailList = new ArrayList<>();
                ResponseDetails responseDetails = new ResponseDetails();
                String bestMatchImageName = searchLogic.bestMatchImage(images, product.getName());

                responseDetails.setProductId(product.getProductid());
                responseDetails.setProductName(product.getName());

//                product.setImages(imageListForSave);
//                product.setThumbImages(thumbnailList);
//                productDaoInterface.save(product);

                logger.debug("================================"+ product.getProductid() +": start ================================");
                logger.debug("Fetched product ===============================================>");
                logger.debug(product);

                if (product.getImages().isEmpty()){
                    if(!bestMatchImageName.equals("")){
                        String thumbnailName = thumbnailGenerator.getThumbnailName(thumbnails, bestMatchImageName, path, thumbnailPath);
                        imageListForSave.add(imageUrl + bestMatchImageName + "?time=" + new Date().getTime());
                        product.setImages(imageListForSave);
                        responseDetails.setImageUrls(product.getImages());

                        if (!thumbnailName.equals("")){
                            thumbnailList.add(thumbnailUrl + thumbnailName + "?time=" + new Date().getTime());
                            product.setThumbImages(thumbnailList);
                            responseDetails.setThumbnailUrls(product.getThumbImages());
                            imageThumbnailAddedProducts.add(responseDetails);
                        }else{
                            onlyImagesAddedProducts.add(responseDetails);
                        }
                        productDaoInterface.save(product);
                    }else {
                        imagesThumbnailNotAddedProducts.add(responseDetails);
                    }
                }else {
                    responseDetails.setImageUrls(product.getImages());
                    responseDetails.setThumbnailUrls(product.getThumbImages());
                    imagesThumbnailExistingProducts.add(responseDetails);
                }

                logger.debug("Saved product ===============================================>");
                logger.debug(product);
                logger.debug("imageUrl: " + "");
                logger.debug("================================"+ product.getProductid() +": end ================================");
            }
            response.setImageThumbnailAddedProducts(imageThumbnailAddedProducts);
            response.setOnlyImagesAddedProducts(onlyImagesAddedProducts);
            response.setImagesThumbnailNotAddedProducts(imagesThumbnailNotAddedProducts);
            response.setImagesThumbnailExistingProducts(imagesThumbnailExistingProducts);
            return response;
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            throw exception;
        }
    }

    public List<String> listFilesUsingDirectoryStream(String dir){
        List<String> fileList = new ArrayList<>();
        try (DirectoryStream<Path> fileStream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path path : fileStream) {
                if (!Files.isDirectory(path)) {
                    fileList.add(path.getFileName().toString());
                }
            }
        }catch (Exception exception){
            if (exception.getClass().equals(java.nio.file.NoSuchFileException.class)){
                throw new NullPointerException("Directory " + dir + " not found");
            }
            logger.error(exception.getMessage());
        }
        return fileList;
    }
}
