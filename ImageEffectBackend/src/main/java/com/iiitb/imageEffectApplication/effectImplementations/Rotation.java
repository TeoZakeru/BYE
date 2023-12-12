package com.iiitb.imageEffectApplication.effectImplementations;
import com.iiitb.imageEffectApplication.baseEffects.DiscreteEffect;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueDiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import static libraryInterfaces.RotationInterface.applyRotation;

public class Rotation implements SingleValueDiscreteEffect {
    private int parameterValue;

    public Rotation(){}
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        Pixel[][] resultImage = applyRotation(image,this.parameterValue);
        String optionValues = "";
        if(this.parameterValue == 0){
            optionValues = "No Rotation";
        }
        if(this.parameterValue == 1){
            optionValues = "Rotation by 90 degrees in clockwise direction";
        }
        if(this.parameterValue == 2){
            optionValues = "Rotation by 180 degrees in clockwise direction";
        }
        if(this.parameterValue == 3){
            optionValues = "Rotation by 270 degrees in clockwise direction";
        }
        loggingService.addLog(fileName,"Rotation",optionValues);
        return resultImage;
    }

    public void setParameterValue(int parameterValue) throws IllegalParameterException{
        if (parameterValue < 0 || parameterValue > 3) {
            throw new IllegalParameterException("Not a valid option");
        }
        this.parameterValue = parameterValue;
    }
}
