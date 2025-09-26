package com.draig.biterater.controllers;

import com.draig.biterater.domain.dtos.PhotoDto;
import com.draig.biterater.domain.entities.Photo;
import com.draig.biterater.mappers.PhotoMapper;
import com.draig.biterater.services.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/photos")
public class PhotoController {

    private final PhotoMapper photoMapper;
    private final PhotoService photoService;

    @PostMapping
    public PhotoDto uploadPhoto(@RequestParam("file") MultipartFile file) {
        Photo avedPhoto = photoService.uploadPhoto(file);
        return photoMapper.toDto(avedPhoto);
    }
}
