package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import static libraryInterfaces.SepiaInterface.applySepia;
/*The Sepia class implements the PhotoEffect interface
to apply the sepia effect on an image.*/
public class Sepia implements PhotoEffect{
    public Sepia(){}//Default constructor
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        // This method applies the sepia effect on the given image and logs the operation.
        // Logging the sepia effect operation
        loggingService.addLog(fileName,"Sepia");
        return applySepia(image);// Applying sepia effect to the image
    }
}
