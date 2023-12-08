package com.iiitb.imageEffectApplication.effectImplementations;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import static libraryInterfaces.GaussianBlurInterface.applyGaussianBlur;
public class GaussianBlur implements SingleValueParameterizableEffect{
    private float parameterValue;
    public GaussianBlur(){ }
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        Pixel[][] resultImage = applyGaussianBlur(image,parameterValue);
        loggingService.addLog(fileName,"GaussianBlur",String.valueOf(parameterValue));
        return resultImage;
    }
    public void setParameterValue(float parameterValue) throws IllegalParameterException {
        if (parameterValue < 0 || parameterValue > 200) {
            throw new IllegalParameterException("Radius value must be between 0 and 50");
        }

        this.parameterValue = parameterValue;
    }


}