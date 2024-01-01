#ifndef HUE_SATURATION_H
#define HUE_SATURATION_H
#pragma once
#include<vector>
#include "../Pixel.h"//including the pixel class definition

using namespace std;
class HueSaturation{
    /*this class has an applyHueSaturation method that has 3 parameters - image, the amount of change
    in hue and the amount of change in saturation and returns the modified image vector.*/
    public:
    static vector<vector<Pixel>> applyHueSaturation(vector< vector<Pixel> > &image, float saturationValue, float hueValue);
};
//a struct that represents a new pixel that has hsv instead of rgb components
struct PixelNew{
    float h;//hue component
    float s;//saturation component
    float v;//value component
};
#endif
