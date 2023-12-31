package com.iiitb.imageEffectApplication.effectImplementations;
import com.iiitb.imageEffectApplication.baseEffects.DiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import static libraryInterfaces.FlipInterface.applyFlip;

//Flip class implements DiscreteEffect and applies a flip effect
public class Flip implements DiscreteEffect{
    private int horizontalFlipValue;// Parameters for flip values
    private int verticalFlipValue;
    public Flip(){}//Default constructor
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        //This method applies the flip effect on the given image based on the given parameter values.
        Pixel[][] resultImage = applyFlip(image,horizontalFlipValue,verticalFlipValue);
        String optionValues = "";
        if(this.horizontalFlipValue>0 && this.verticalFlipValue == 0){
            optionValues = "Horizontal Flip";
        }
        if(this.verticalFlipValue>0 && this.horizontalFlipValue == 0){
            optionValues = "Vertical Flip";
        }
        if(this.verticalFlipValue>0 && this.horizontalFlipValue>0){
            optionValues = "Horizontal  and Vertical Flip";
        }
        if(this.verticalFlipValue == 0 && this.horizontalFlipValue == 0){
            return resultImage;
        }
        loggingService.addLog(fileName,"Flip",optionValues);// Add a log entry for the applied flip effect.
        return resultImage;// Return the result image.
    }

    public void selectOptionValue(String optionName, int value) throws IllegalParameterException{
        /*This method sets the flip parameter value, validating that it falls within a valid range.
        checking if the flip value parameter value is within range of 0 to 1*/
        if (value < 0 || value > 1) {
            throw new IllegalParameterException("Not a valid option");
        }
        // Set the flip option value based on the provided option name.
        if (optionName.equalsIgnoreCase("Horizontal")){
            this.horizontalFlipValue = value;
        }
        if (optionName.equalsIgnoreCase("Vertical")){
            this.verticalFlipValue = value;
        }
    }
}
