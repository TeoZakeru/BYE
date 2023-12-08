package com.iiitb.imageEffectApplication.effectImplementations;
import com.iiitb.imageEffectApplication.baseEffects.DiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import static libraryInterfaces.FlipInterface.applyFlip;

public class Flip implements DiscreteEffect{
    private int horizontalFlipValue;
    private int verticalFlipValue;
    public Flip(){}
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
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
        loggingService.addLog(fileName,"Flip",optionValues);
        return resultImage;
    }

    public void selectOptionValue(String optionName, int value) throws IllegalParameterException{
        if (value < 0 || value > 1) {
            throw new IllegalParameterException("Not a valid option");
        }

        if (optionName.equalsIgnoreCase("Horizontal")){
            this.horizontalFlipValue = value;
        }
        if (optionName.equalsIgnoreCase("Vertical")){
            this.verticalFlipValue = value;
        }
    }
}
