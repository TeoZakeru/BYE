#ifndef BRIGHTNESS_H
#define BRIGHTNESS_H
#pragma once
#include "../Pixel.h"//including the pixel class definition
#include <vector>
using namespace std;

class Brightness {
    /*this class has an applyBrightness method that has 2 parameters - image and the amount of change
    in brightness and returns the modified image vector.*/ 
public:
    static vector<vector<Pixel>> applyBrightness(vector<vector<Pixel>>& image, float amount);
};
#endif
