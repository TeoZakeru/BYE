package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import static libraryInterfaces.InvertInterface.applyInvert;
    /*The Invert class implements the PhotoEffect interface
    to apply the invert effect on an image.*/
public class Invert implements PhotoEffect{
    public Invert(){}//Default constructor
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        //This method applies the invert effect on the given image and logs the operation.
        // Logging the invert effect operation
        loggingService.addLog(fileName,"Invert");
        return applyInvert(image);// Applying invert effect to the image
    }
}
