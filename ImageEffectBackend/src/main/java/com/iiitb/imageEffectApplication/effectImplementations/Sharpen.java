package com.iiitb.imageEffectApplication.effectImplementations;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import static libraryInterfaces.SharpenInterface.applySharpen;
public class Sharpen implements SingleValueParameterizableEffect{
    private float parameterValue;
    public Sharpen(){ }
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        Pixel[][] resultImage = applySharpen(image,parameterValue);
        loggingService.addLog(fileName,"Sharpen",String.valueOf(parameterValue));
        return resultImage;
    }
    public void setParameterValue(float parameterValue) throws IllegalParameterException {
        if (parameterValue < 0 || parameterValue > 100) {
            throw new IllegalParameterException("Sharpness value must be between 0 and 100");
        }

        this.parameterValue = parameterValue;
    }
}