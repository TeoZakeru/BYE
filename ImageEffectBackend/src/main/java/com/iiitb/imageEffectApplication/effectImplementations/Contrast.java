package com.iiitb.imageEffectApplication.effectImplementations;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import static libraryInterfaces.ContrastInterface.applyContrast;
/*The Contrast class implements the SingleValueParameterizableEffect interface
  to apply contrast effect on an image.*/
public class Contrast implements SingleValueParameterizableEffect{
    private float parameterValue;// Parameter to store the contrast value
    public Contrast(){}//Default constructor
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        //This method applies the contrast effect on the given image and logs the operation.
        Pixel[][] resultImage = applyContrast(image,parameterValue);// Applying contrast effect to the image
        loggingService.addLog(fileName,"Contrast",String.valueOf(parameterValue));// Logging the contrast effect operation
        return resultImage;// Returning the resulting image
    }

    public void setParameterValue(float parameterValue) throws IllegalParameterException {
        /*This method sets the contrast parameter value, validating that it falls within a valid range.
        checking if the contrast parameter value is within range of 0 to 200*/
        if (parameterValue < 0 || parameterValue > 200) {
            throw new IllegalParameterException("Contrast value must be between 0 and 200");
        }
        //Setting the parameter value
        this.parameterValue = parameterValue;
    }
}
