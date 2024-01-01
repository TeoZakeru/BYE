Image Effect Application

This folder contains the code for an application called Image Effect 
Application, which is implemented in Java using the Spring Boot framework.
The application provides several image processing effects for users to apply
onto their images. The effects are also logged. These effects are described 
below:

    HueSaturation Effect:
        Method: applyHueSaturationEffect(float hueAmount, float saturationAmount, MultipartFile imageFile)
        Applies a hue and saturation adjustment to the image.
        Range - Hue : 0 - 360 (Default 0)
              - Saturation : 0 - 100(Default 50)

    Brightness Effect:
        Method: applyBrightnessEffect(float amount, MultipartFile imageFile)
        Adjusts the brightness of the image.
        Range : 0 - 200 (Default 100)

    Contrast Effect:
        Method: applyContrastEffect(float amount, MultipartFile imageFile)
        Adjusts the contrast of the image.
        Range : 0 - 200 (Default 100) 

    Flip Effect:
        Method: applyFlipEffect(MultipartFile imageFile, int horizontalFlipValue, int verticalFlipValue)
        Flips the image horizontally and/or vertically.
        Range : Horizontal, Vertical

    Gaussian Blur Effect:
        Method: applyGaussianBlurEffect(float radius, MultipartFile imageFile)
        Applies a Gaussian blur to the image.
        Range : 0 - 50 (Default 10)

    Grayscale Effect:
        Method: applyGrayscaleEffect(MultipartFile imageFile)
        Converts the image to grayscale.

    Invert Effect:
        Method: applyInvertEffect(MultipartFile imageFile)
        Inverts the colors of the image.

    Rotation Effect:
        Method: applyRotationEffect(int value, MultipartFile imageFile)
        Rotates the image by the specified angle (0,90,180 or 270 degrees)
        Range : 0 degrees, 90 degrees, 180 degrees, 270 degrees

    Sepia Effect:
        Method: applySepiaEffect(MultipartFile imageFile)
        Applies a sepia effect to the image.

    Sharpen Effect:
        Method: applySharpenEffect(float amount, MultipartFile imageFile)
        Sharpens the image.
        Range : 0 - 100 (Default 50)

    Dominant Colour Effect:
        Method: getDominantColour(MultipartFile imageFile)
        Identifies the dominant color from the image.

LoggingService

The LoggingService class handles logging related to image processing 
operations. It provides the following functionalities:

    Adding logs for image processing operations with different options.
    Retrieving all logs or logs filtered by effect name.
    Clearing all logs.
    Retrieving logs within a specified timestamp range.

Team Members:

    Swaroop A Ram Rayala - IMT2022587
    K S V Rohit - IMT2022576
    Mupparapu Koushik - IMT2022570
    A Nishith - IMT2022556
    Sreyas J - IMT2022554
    Rajanala Sai Dheeraj - IMT2022093
    
    

Contributions:

    Brightness - Sreyas
    Contrast - Swaroop
    Dominant Colour - Swaroop
    Flip - Dheeraj
    Gaussian Blur - Koushik
    Grayscale - Sreyas
    Hue and Satuation Effect - Rohit
    Invert - Nishith
    Rotation - Dheeraj
    Sepia - Nishith
    Sharpen - Koushik
    Logging Service - Rohit