package com.mahjoub.Gestiondestock.services;

import com.flickr4java.flickr.FlickrException;
import org.springframework.stereotype.Service;

import java.io.InputStream;
@Service
public interface PicFlickrService {

    String savePicture (InputStream picture,String title) throws FlickrException;
}
