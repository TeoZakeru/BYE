package com.iiitb.imageEffectApplication.service;

import com.iiitb.imageEffectApplication.*;
import com.iiitb.imageEffectApplication.effectImplementations.*;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.utils.ProcessingUtils;
import libraryInterfaces.GaussianBlurInterface;
import libraryInterfaces.InvertInterface;
import libraryInterfaces.Pixel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import static libraryInterfaces.BrightnessInterface.applyBrightness;
import static libraryInterfaces.ContrastInterface.applyContrast;
import static libraryInterfaces.DominantColourInterface.applyDominantColour;
import static libraryInterfaces.FlipInterface.applyFlip;
import static libraryInterfaces.GaussianBlurInterface.applyGaussianBlur;
import static libraryInterfaces.GrayscaleInterface.applyGrayscale;
import static libraryInterfaces.InvertInterface.applyInvert;
import static libraryInterfaces.RotationInterface.applyRotation;
import static libraryInterfaces.SepiaInterface.applySepia;

@Service
public class PhotoEffectService {

    @Autowired
    private ProcessingUtils processingUtils;

    @Autowired
    private LoggingService loggingService;

    public ResponseEntity<byte[]> applyHueSaturationEffect(float hueAmount, float saturationAmount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE

            // TODO
            Pixel[][] modifiedImage = inputImage; // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE


            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyBrightnessEffect(float amount, MultipartFile imageFile) throws IllegalParameterException, IOException {
        Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
        try {
//            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
//            inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();




            // ACTUAL WORK STARTS HERE

            // TODO
            Brightness brightness = new Brightness();
            brightness.setParameterValue(amount);
            Pixel[][] modifiedImage = brightness.apply(inputImage,imageName,loggingService); // Replace this with actual modified image
            return processingUtils.postProcessing(modifiedImage);
            // ACTUAL WORK ENDS HERE





        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalParameterException e) {
            System.out.println(e.getMessage());
//            throw new RuntimeException(e);
//            throw e;
        }
        return processingUtils.postProcessing(inputImage);
    }

    public ResponseEntity<byte[]> applyContrastEffect(float amount, MultipartFile imageFile) throws IOException {
        Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
        try {
            String imageName = imageFile.getOriginalFilename();



            // ACTUAL WORK STARTS HERE

            // TODO
            Contrast contrast = new Contrast();
            contrast.setParameterValue(amount);
            Pixel[][] modifiedImage = contrast.apply(inputImage,imageName,loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE



            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalParameterException e) {
            System.out.println(e.getMessage());
//            throw new RuntimeException(e);
        }
        return processingUtils.postProcessing(inputImage);
    }

    public ResponseEntity<byte[]> applyFlipEffect(MultipartFile imageFile, int horizontalFlipValue, int verticalFlipValue) throws IOException {
        Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
        try {
            String imageName = imageFile.getOriginalFilename();



            // ACTUAL WORK STARTS HERE

            // TODO
            Flip flip = new Flip();
            flip.selectOptionValue("Horizontal",horizontalFlipValue);
            flip.selectOptionValue("Vertical",verticalFlipValue);
            Pixel[][] modifiedImage = flip.apply(inputImage,imageName,loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE




            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalParameterException e) {
            System.out.println(e.getMessage());
        }
        return processingUtils.postProcessing(inputImage);
    }

    public ResponseEntity<byte[]> applyGaussianBlurEffect(float radius, MultipartFile imageFile) throws IOException {
        Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
        try {
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE

            // TODO
            GaussianBlur gaussianBlur = new GaussianBlur();
            gaussianBlur.setParameterValue(radius);
            Pixel[][] modifiedImage = gaussianBlur.apply(inputImage,imageName,loggingService); // Replace this with actual modified image
//            System.out.println("HII");
            // ACTUAL WORK ENDS HERE



            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalParameterException e) {
            System.out.println(e.getMessage());
        }
        return processingUtils.postProcessing(inputImage);
    }

    public ResponseEntity<byte[]> applyGrayscaleEffect(MultipartFile imageFile){
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE

            // TODO
            Grayscale grayscale = new Grayscale();
            Pixel[][] modifiedImage = grayscale.apply(inputImage,imageName,loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyInvertEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO
            Invert invert = new Invert();
            Pixel[][] modifiedImage = invert.apply(inputImage,imageName,loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyRotationEffect(int value, MultipartFile imageFile) throws IOException {
        Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
        try {
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE

            // TODO
            Rotation rotation = new Rotation();
            rotation.setParameterValue(value);
            Pixel[][] modifiedImage = rotation.apply(inputImage,imageName,loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE


            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalParameterException e) {
            System.out.println(e.getMessage());
        }
        return processingUtils.postProcessing(inputImage);
    }

    public ResponseEntity<byte[]> applySepiaEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO
            Sepia sepia = new Sepia();
            Pixel[][] modifiedImage = sepia.apply(inputImage,imageName,loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applySharpenEffect(float amount, MultipartFile imageFile) throws IOException {
        Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
        try {
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO
            Sharpen sharpen = new Sharpen();
            sharpen.setParameterValue(amount);
            Pixel[][] modifiedImage = sharpen.apply(inputImage,imageName,loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalParameterException e) {
            System.out.println(e.getMessage());
        }
        return processingUtils.postProcessing(inputImage);
    }

    public ResponseEntity<byte[]> getDominantColour(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO
            Pixel[][] modifiedImage = applyDominantColour(inputImage); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}