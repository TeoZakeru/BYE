package com.iiitb.imageEffectApplication.effectImplementations;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.baseEffects.ParameterizableEffect;

import static libraryInterfaces.HueSaturationInterface.applyHueSaturation;

public class HueSaturation implements ParameterizableEffect{

    private float hue;
    private float saturation;
    public HueSaturation(){}
    public void setParameter(String paramName, float value) throws IllegalParameterException {
        if(paramName.equalsIgnoreCase("hue")){
            if(value<0 || value>360){
                throw new IllegalParameterException("Hue value must be between 0 to 360");
            }
            this.hue = value;
        }
        if(paramName.equalsIgnoreCase("saturation")){
            if(value<0 || value>100){
                throw new IllegalParameterException("Saturation value must be between 0 to 100");
            }
            this.saturation = value;
        }
    }

    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        Pixel[][] resultImage = applyHueSaturation(image,saturation,hue);
        String optionValues = "Hue "+hue+" ,Saturation "+saturation;
        loggingService.addLog(fileName,"Hue and Saturation",optionValues);
        return resultImage;
    }
}
