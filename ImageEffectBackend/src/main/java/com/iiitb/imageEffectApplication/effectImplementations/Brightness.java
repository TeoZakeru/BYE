package com.iiitb.imageEffectApplication.effectImplementations;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import static libraryInterfaces.BrightnessInterface.applyBrightness;
/*The Brightness class implements the SingleValueParameterizableEffect interface
  to apply brightness effect on an image.*/
public class Brightness implements SingleValueParameterizableEffect{

    private float parameterValue; // Parameter to store the brightness value
    public Brightness(){ }//Default Constructor

    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        //This method applies the brightness effect on the given image and logs the operation.
        Pixel[][] resultImage = applyBrightness(image,parameterValue);// Applying brightness effect to the image
        loggingService.addLog(fileName,"Brightness",String.valueOf(parameterValue));// Logging the brightness effect operation
        return resultImage;// Returning the resulting image
    }
    public void setParameterValue(float parameterValue) throws IllegalParameterException {
        /*This method sets the brightness parameter value, validating that it falls within a valid range.
        checking if the brightness parameter value is within range of 0 to 200*/
        if (parameterValue < 0 || parameterValue > 200) {
            throw new IllegalParameterException("Brightness value must be between 0 and 200");
        }
        //Setting the parameter value
        this.parameterValue = parameterValue;
    }


}