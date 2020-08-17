package com.aplova.productimagesautouploader.services;

import com.aplova.productimagesautouploader.model.BestMatchDetails;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface SearchLogic {
    BestMatchDetails findBestMatch(List<String> imagesList, String productName);
    String bestMatchImage(List<String> imagesList, String productName);
}
