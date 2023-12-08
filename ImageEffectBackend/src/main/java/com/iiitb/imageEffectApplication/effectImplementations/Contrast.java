package com.iiitb.imageEffectApplication.effectImplementations;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import static libraryInterfaces.ContrastInterface.applyContrast;

public class Contrast implements SingleValueParameterizableEffect{
    private float parameterValue;
    public Contrast(){}
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        Pixel[][] resultImage = applyContrast(image,parameterValue);
        loggingService.addLog(fileName,"Contrast",String.valueOf(parameterValue));
        return resultImage;
    }

    public void setParameterValue(float parameterValue) throws IllegalParameterException {
        if (parameterValue < 0 || parameterValue > 200) {
            throw new IllegalParameterException("Contrast value must be between 0 and 200");
        }

        this.parameterValue = parameterValue;
    }
}
