package com.iiitb.imageEffectApplication.effectImplementations;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.baseEffects.ParameterizableEffect;

import static libraryInterfaces.HueSaturationInterface.applyHueSaturation;
/*The HueSaturation class implements the ParameterizableEffect interface
 to apply hue and saturation adjustment on an image.*/
public class HueSaturation implements ParameterizableEffect{

    // Parameters for hue and saturation
    private float hue;
    private float saturation;
    public HueSaturation(){}//Default constructor
    public void setParameter(String paramName, float value) throws IllegalParameterException {
        //This method sets the parameter values for hue and saturation, validating their ranges.
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
        //This method applies the hue and saturation effect on the given image and logs the operation.
        Pixel[][] resultImage = applyHueSaturation(image,saturation,hue);
        String optionValues = "Hue "+hue+" ,Saturation "+saturation;
        // Logging the hue and saturation adjustment operation
        loggingService.addLog(fileName,"Hue and Saturation",optionValues);
        return resultImage;// Returning the resulting image
    }
}
