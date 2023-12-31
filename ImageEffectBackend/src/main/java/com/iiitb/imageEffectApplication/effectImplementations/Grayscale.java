package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;

import static libraryInterfaces.DominantColourInterface.applyDominantColour;
import static libraryInterfaces.GrayscaleInterface.applyGrayscale;
/*The Grayscale class implements the PhotoEffect interface
    to apply the grayscale effect on an image.*/
public class Grayscale implements PhotoEffect{
    public Grayscale(){}//Default constructor
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        //This method applies the grayscale effect on the given image and logs the operation.
        // Logging the grayscale effect operation
        loggingService.addLog(fileName,"Grayscale");
        return applyGrayscale(image);// Applying grayscale effect to the image
    }
}
