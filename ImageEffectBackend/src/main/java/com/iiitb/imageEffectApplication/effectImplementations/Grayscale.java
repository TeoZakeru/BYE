package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import static libraryInterfaces.GrayscaleInterface.applyGrayscale;

public class Grayscale implements PhotoEffect{
    public Grayscale(){}
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName,"Grayscale");
        return applyGrayscale(image);
    }
}
