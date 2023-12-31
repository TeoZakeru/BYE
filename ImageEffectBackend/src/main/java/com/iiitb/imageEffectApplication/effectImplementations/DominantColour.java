package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import static libraryInterfaces.DominantColourInterface.applyDominantColour;
    /*The DominantColour class implements the PhotoEffect interface
    to apply the dominant color effect on an image.*/
public class DominantColour implements PhotoEffect{
    public DominantColour(){}//Default constructor
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        //This method applies the dominant color effect on the given image and logs the operation.
        // Logging the dominant color effect operation
        loggingService.addLog(fileName,"Dominant Colour");
        return applyDominantColour(image);// Applying dominant color effect to the image
    }
}
