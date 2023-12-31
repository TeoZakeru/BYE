package com.iiitb.imageEffectApplication.effectImplementations;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import static libraryInterfaces.SharpenInterface.applySharpen;
/*The Sharpen class implements the SingleValueParameterizableEffect interface
  to apply sharpen effect on an image.*/
public class Sharpen implements SingleValueParameterizableEffect{
    private float parameterValue;// Parameter to store the sharpen value
    public Sharpen(){ }//Default constructor
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        //This method applies the sharpen effect on the given image and logs the operation.
        Pixel[][] resultImage = applySharpen(image,parameterValue);// Applying sharpen effect to the image
        loggingService.addLog(fileName,"Sharpen",String.valueOf(parameterValue));// Logging the sharpen effect operation
        return resultImage;// Returning the resulting image
    }
    public void setParameterValue(float parameterValue) throws IllegalParameterException {
        /*This method sets the sharpen parameter value, validating that it falls within a valid range.
        checking if the sharpen parameter value is within range of 0 to 100*/
        if (parameterValue < 0 || parameterValue > 100) {
            throw new IllegalParameterException("Sharpness value must be between 0 and 100");
        }
        //Setting the parameter value
        this.parameterValue = parameterValue;
    }
}