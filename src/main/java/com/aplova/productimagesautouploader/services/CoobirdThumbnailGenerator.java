package com.aplova.productimagesautouploader.services;

import com.aplova.productimagesautouploader.model.BestMatchDetails;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class CoobirdThumbnailGenerator implements ThumbnailGenerator{
    private static final Logger logger = LogManager.getLogger(CoobirdThumbnailGenerator.class);
    private final SearchLogic searchLogic;

    @Autowired
    public CoobirdThumbnailGenerator(SearchLogic searchLogic) {
        this.searchLogic = searchLogic;
    }

    public boolean generateThumbnail(String imageName, String path , String thumbnailPath, String thumbnailName){
        try {
            Thumbnails.of(new File(path, imageName))
                    .size(512, 512)
                    .keepAspectRatio(false)
                    .toFile(new File(thumbnailPath, thumbnailName));
            return true;
        }catch (Exception exception){
            logger.error(exception.getMessage());
            return false;
        }
    };

    public String getThumbnailName(List<String> thumbnails, String bestMatchImageName, String path , String thumbnailPath){
        String thumbnailName = bestMatchImageName.split("\\.")[0] + "_thumbnail.jpg";
        BestMatchDetails bestMatchThumbnail = searchLogic.findBestMatch(thumbnails, thumbnailName);

        if (bestMatchThumbnail.getScore() == 100){
            return  thumbnailName;
        }
        if (generateThumbnail(bestMatchImageName, path, thumbnailPath, thumbnailName)){
            return thumbnailName;
        }
        return "";
    }
}
