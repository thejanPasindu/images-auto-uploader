package com.aplova.productimagesautouploader.controllers;

import com.aplova.productimagesautouploader.model.ErrorDetails;
import com.aplova.productimagesautouploader.model.MainResponseDetails;
import com.aplova.productimagesautouploader.model.RequestDetails;
import com.aplova.productimagesautouploader.model.ResponseDetails;
import com.aplova.productimagesautouploader.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {
    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @PostMapping(path = "update", produces = "application/json")
    public ResponseEntity<?> uploadImage(@RequestBody RequestDetails requestDetails) {
        try {
            MainResponseDetails response = mainService.findBestMatchImagePath(requestDetails.getBusinessId(), requestDetails.getPath(), requestDetails.getThumbnailPath());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception exception){
            ErrorDetails errorDetails = new ErrorDetails();
            if (exception.getClass().equals(NullPointerException.class)){
                errorDetails.setBusinessId(requestDetails.getBusinessId());
                errorDetails.setError(exception.getMessage());
            }
            return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
        }
    }
}
