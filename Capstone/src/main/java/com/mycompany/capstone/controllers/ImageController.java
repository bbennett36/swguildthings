/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capstone.controllers;

import com.mycompany.capstone.dto.Image;
import java.io.IOException;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.mycompany.capstone.dao.ImageDao;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping(value = "/uploadimage")
public class ImageController {

    private ImageDao adminPageImageDao;

    @Inject
    public ImageController(ImageDao adminPageImageDao) {
        this.adminPageImageDao = adminPageImageDao;

    }

    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam(value = "userfile") CommonsMultipartFile[] fileUpload, Map model) {

        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload) {

                System.out.println("Saving file: " + aFile.getOriginalFilename());

                Image uploadFile = new Image();
                uploadFile.setImagePath(aFile.getOriginalFilename());
                uploadFile.setImageData(aFile.getBytes());
                adminPageImageDao.create(uploadFile);
                
                model.put("uploadFile", uploadFile);
                
            }
        }

     return "upload_result";   
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void showImage(@PathVariable("id") Integer imageId, HttpServletResponse response, HttpServletRequest request ) throws IOException 
   {
          Image  apImage=adminPageImageDao.get(imageId);
          
          
          response.getOutputStream().write(apImage.getImageData());
          response.getOutputStream().close();
          
    }

}
