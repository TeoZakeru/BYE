package com.iiitb.imageEffectApplication.effectImplementations;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import static libraryInterfaces.BrightnessInterface.applyBrightness;
public class Brightness implements SingleValueParameterizableEffect{
    private float parameterValue;
    public Brightness(){ }
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        Pixel[][] resultImage = applyBrightness(image,parameterValue);
        loggingService.addLog(fileName,"Brightness",String.valueOf(parameterValue));
        return resultImage;
    }
    public void setParameterValue(float parameterValue) throws IllegalParameterException {
        if (parameterValue < 0 || parameterValue > 200) {
            throw new IllegalParameterException("Brightness value must be between 0 and 200");
        }

        this.parameterValue = parameterValue;
    }


}