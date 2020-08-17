package com.aplova.productimagesautouploader.services;

import com.aplova.productimagesautouploader.model.BestMatchDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThumbnailGenerator {
    boolean generateThumbnail(String imageName, String path, String thumbnailPath,  String thumbnailName);
    String getThumbnailName(List<String> thumbnails, String bestMatchImageName, String path , String thumbnailPath);
}
