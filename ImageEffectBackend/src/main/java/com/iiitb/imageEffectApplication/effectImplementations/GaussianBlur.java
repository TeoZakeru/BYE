package com.iiitb.imageEffectApplication.effectImplementations;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import static libraryInterfaces.GaussianBlurInterface.applyGaussianBlur;
/*The GaussianBlur class implements the SingleValueParameterizableEffect interface
 to apply gaussianblur effect on an image.*/
public class GaussianBlur implements SingleValueParameterizableEffect{
    private float parameterValue;// Parameter to store the gaussianblur value
    public GaussianBlur(){ }
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        //This method applies the gaussianblur effect on the given image and logs the operation.
        Pixel[][] resultImage = applyGaussianBlur(image,parameterValue);// Applying gaussianblur effect to the image
        loggingService.addLog(fileName,"GaussianBlur",String.valueOf(parameterValue));// Logging the gaussianblur effect operation
        return resultImage;// Returning the resulting image
    }
    public void setParameterValue(float parameterValue) throws IllegalParameterException {
        /*This method sets the gaussianblur parameter value, validating that it falls within a valid range.
        checking if the gaussianblur parameter value is within range of 0 to 50*/
        if (parameterValue < 0 || parameterValue > 50) {
            throw new IllegalParameterException("Radius value must be between 0 and 50");
        }
        //Setting the parameter value
        this.parameterValue = parameterValue;
    }


}