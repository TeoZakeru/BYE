package com.iiitb.imageEffectApplication.effectImplementations;
import com.iiitb.imageEffectApplication.baseEffects.DiscreteEffect;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueDiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import static libraryInterfaces.RotationInterface.applyRotation;

/*Rotation class implements SingleValueDiscreteEffect and to apply rotation effect. */

public class Rotation implements SingleValueDiscreteEffect {
    private int parameterValue;// Parameter to store the rotation value

    public Rotation(){}//Default constructor
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        //This method applies the rotation effect on the given image based on the given parameter value.
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
        loggingService.addLog(fileName,"Rotation",optionValues);// Add a log entry for the applied rotation effect.
        return resultImage;// Return the result image.
    }

    public void setParameterValue(int parameterValue) throws IllegalParameterException{
        /*This method sets the rotation parameter value, validating that it falls within a valid range.
        checking if the brightness parameter value is within range of 0 to 3*/
        if (parameterValue < 0 || parameterValue > 3) {
            throw new IllegalParameterException("Not a valid option");
        }
        this.parameterValue = parameterValue;//Setting the parameter value
    }
}
