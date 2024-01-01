#ifndef GAUSSIAN_BLUR_H
#define GAUSSIAN_BLUR_H
#pragma once
#include "../Pixel.h"//including the pixel class definition
#include <vector>
using namespace std;

class GaussianBlur{
    /*this class has an applyGaussianBlur method that has 2 parameters - image and 
    the radius of blur and returns the modified image vector.*/
public:
    static vector<vector<Pixel>> applyGaussianBlur(vector<vector<Pixel>>& image, float radius);
};
#endif