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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static libraryInterfaces.BrightnessInterface.applyBrightness;
import static libraryInterfaces.ContrastInterface.applyContrast;
import static libraryInterfaces.DominantColourInterface.applyDominantColour;
import static libraryInterfaces.FlipInterface.applyFlip;
import static libraryInterfaces.GaussianBlurInterface.applyGaussianBlur;
import static libraryInterfaces.GrayscaleInterface.applyGrayscale;
import static libraryInterfaces.HueSaturationInterface.applyHueSaturation;
import static libraryInterfaces.InvertInterface.applyInvert;
import static libraryInterfaces.RotationInterface.applyRotation;
import static libraryInterfaces.SepiaInterface.applySepia;

@Service
public class PhotoEffectService {

    @Autowired
    private ProcessingUtils processingUtils;

    @Autowired
    private LoggingService loggingService;

    public ResponseEntity<byte[]> applyHueSaturationEffect(float hueAmount, float saturationAmount, MultipartFile imageFile) throws IOException {
        Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
        try {

            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE

            // TODO
            HueSaturation hueSaturation = new HueSaturation();//creating an object of the huesaturation class
            hueSaturation.setParameter("saturation",saturationAmount);//using setters to set the parameters
            hueSaturation.setParameter("hue",hueAmount);
            Pixel[][] modifiedImage = hueSaturation.apply(inputImage,imageName,loggingService);//applying the effect
            // ACTUAL WORK ENDS HERE


            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalParameterException e) {
            System.out.println(e.getMessage());//catching and printing the illegalparameterexception message
        }
        return processingUtils.postProcessing(inputImage);
    }

    public ResponseEntity<byte[]> applyBrightnessEffect(float amount, MultipartFile imageFile) throws IllegalParameterException, IOException {
        Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
        try {
            String imageName = imageFile.getOriginalFilename();




            // ACTUAL WORK STARTS HERE

            // TODO
            Brightness brightness = new Brightness();//creating an object of the brightness class
            brightness.setParameterValue(amount);//using setter to set the parameter
            Pixel[][] modifiedImage = brightness.apply(inputImage,imageName,loggingService);//applying the effect
            return processingUtils.postProcessing(modifiedImage);
            // ACTUAL WORK ENDS HERE




        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalParameterException e) {
            System.out.println(e.getMessage());//catching and printing the illegalparameterexception message
        }
        return processingUtils.postProcessing(inputImage);
    }

    public ResponseEntity<byte[]> applyContrastEffect(float amount, MultipartFile imageFile) throws IOException {
        Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
        try {
            String imageName = imageFile.getOriginalFilename();



            // ACTUAL WORK STARTS HERE

            // TODO
            Contrast contrast = new Contrast();//creating an object of the contrast class
            contrast.setParameterValue(amount);//using setter to set the parameter
            Pixel[][] modifiedImage = contrast.apply(inputImage,imageName,loggingService);//applying the effect
            // ACTUAL WORK ENDS HERE



            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalParameterException e) {
            System.out.println(e.getMessage());//catching and printing the illegalparameterexception message
        }
        return processingUtils.postProcessing(inputImage);
    }

    public ResponseEntity<byte[]> applyFlipEffect(MultipartFile imageFile, int horizontalFlipValue, int verticalFlipValue) throws IOException {
        Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
        try {
            String imageName = imageFile.getOriginalFilename();



            // ACTUAL WORK STARTS HERE

            // TODO
            Flip flip = new Flip();//creating an object of the flip class
            flip.selectOptionValue("Horizontal",horizontalFlipValue);//using setters to set the parameters
            flip.selectOptionValue("Vertical",verticalFlipValue);
            Pixel[][] modifiedImage = flip.apply(inputImage,imageName,loggingService);//applying the effect
            // ACTUAL WORK ENDS HERE




            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalParameterException e) {
            System.out.println(e.getMessage());//catching and printing the illegalparameterexception message
        }
        return processingUtils.postProcessing(inputImage);
    }

    public ResponseEntity<byte[]> applyGaussianBlurEffect(float radius, MultipartFile imageFile) throws IOException {
        Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
        try {
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE

            // TODO
            GaussianBlur gaussianBlur = new GaussianBlur();//creating an object of the gaussianblur class
            gaussianBlur.setParameterValue(radius);//using setter to set the parameter
            Pixel[][] modifiedImage = gaussianBlur.apply(inputImage,imageName,loggingService);//applying the effect
            // ACTUAL WORK ENDS HERE



            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalParameterException e) {
            System.out.println(e.getMessage());//catching and printing the illegalparameterexception message
        }
        return processingUtils.postProcessing(inputImage);
    }

    public ResponseEntity<byte[]> applyGrayscaleEffect(MultipartFile imageFile){
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE

            // TODO
            Grayscale grayscale = new Grayscale();//creating an object of the grayscale class
            Pixel[][] modifiedImage = grayscale.apply(inputImage,imageName,loggingService);//applying the effect
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
            Invert invert = new Invert();//creating an object of the invert class
            Pixel[][] modifiedImage = invert.apply(inputImage,imageName,loggingService);//applying the effect
            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static Pixel[][] flipMatrix(Pixel[][] matrix) {
        // Transpose the matrix
        int rows = matrix.length;
        int cols = matrix[0].length;

        Pixel[][] transposed = new Pixel[cols][rows];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                transposed[j][i] = matrix[i][j];
            }
        }

        // Reverse the order of each row
        for (int i = 0; i < cols; ++i) {
            for (int j = 0; j < rows / 2; ++j) {
                Pixel temp = transposed[i][j];
                transposed[i][j] = transposed[i][rows - 1 - j];
                transposed[i][rows - 1 - j] = temp;
            }
        }

        return transposed;
    }


    public ResponseEntity<byte[]> applyRotationEffect(int value, MultipartFile imageFile) throws IOException, IllegalParameterException {
        Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
        try {
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE

            // TODO
            Rotation rotation = new Rotation();//creating an object of the rotation class
            rotation.setParameterValue(value);//using setter to set the parameter
            Pixel[][] modifiedImage = rotation.apply(inputImage,imageName,loggingService);//applying the effect
                // ACTUAL WORK ENDS HERE


                return processingUtils.postProcessing(modifiedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalParameterException e) {
            System.out.println(e.getMessage());//catching and printing the illegalparameterexception message
        }
        return processingUtils.postProcessing(inputImage);
    }

    public ResponseEntity<byte[]> applySepiaEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO
            Sepia sepia = new Sepia();//creating an object of the sepia class
            Pixel[][] modifiedImage = sepia.apply(inputImage,imageName,loggingService);//applying the effect
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
            Sharpen sharpen = new Sharpen();//creating an object of the sharpen class
            sharpen.setParameterValue(amount);//using setter to set the parameter
            Pixel[][] modifiedImage = sharpen.apply(inputImage,imageName,loggingService);
            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalParameterException e) {
            System.out.println(e.getMessage());//catching and printing the illegalparameterexception message
        }
        return processingUtils.postProcessing(inputImage);
    }

    public ResponseEntity<byte[]> getDominantColour(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO
            DominantColour dominantColour = new DominantColour();//creating an object of the dominant colour class
            Pixel[][] modifiedImage = dominantColour.apply(inputImage,imageName,loggingService);//applying the effect

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}