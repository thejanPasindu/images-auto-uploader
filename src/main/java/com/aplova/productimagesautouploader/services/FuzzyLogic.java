package com.aplova.productimagesautouploader.services;

import com.aplova.productimagesautouploader.model.BestMatchDetails;
import me.xdrop.fuzzywuzzy.FuzzySearch;
import me.xdrop.fuzzywuzzy.model.ExtractedResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@PropertySource("classpath:configuration.properties")
public class FuzzyLogic implements SearchLogic{
    private static final Logger logger = LogManager.getLogger(FuzzyLogic.class);

    @Value("${bestMatchPercentageForSingleWord}")
    private int bestMatchPercentageForSingleWord;
    @Value("${bestMatchPercentageForMultiWord}")
    private int bestMatchPercentageForMultiWord;
    @Value("${minBestMatchStringLength}")
    private float minBestMatchStringLength;
    @Value("${maxBestMatchStringLength}")
    private float maxBestMatchStringLength;

    @Override
    public BestMatchDetails findBestMatch(List<String> imagesList, String productName){
        ExtractedResult extractedResult = FuzzySearch.extractOne(productName, imagesList);
        logger.debug(extractedResult);
        return new BestMatchDetails(extractedResult.getString(), extractedResult.getScore(), extractedResult.getIndex());
    }

    @Override
    public String bestMatchImage(List<String> imagesList, String productName) {
        BestMatchDetails bestMatchDetails = findBestMatch(imagesList, productName + ".jpg");
        int productNameLength = productName.split(" ").length;
        float bestMatchStringLength = (float)productNameLength/bestMatchDetails.getString().split("_").length;

        logger.trace(bestMatchDetails.getString() + " : " + productName + " -> " + bestMatchDetails.getScore());

        if (productNameLength == 1 && bestMatchDetails.getScore() > bestMatchPercentageForSingleWord){
            return bestMatchDetails.getString();
        }
        if (bestMatchStringLength >= minBestMatchStringLength
                && bestMatchStringLength <= maxBestMatchStringLength
                && bestMatchDetails.getScore() >= bestMatchPercentageForMultiWord){
            return bestMatchDetails.getString();
        }
        return "";
    }

}
