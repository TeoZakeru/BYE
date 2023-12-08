package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import static libraryInterfaces.DominantColourInterface.applyDominantColour;

public class DominantColour implements PhotoEffect{
    public DominantColour(){}
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName,"Dominant Colour");
        return applyDominantColour(image);
    }
}
