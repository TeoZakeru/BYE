#ifndef SHARPEN_H
#define SHARPEN_H
#pragma once
#include "../Pixel.h"//including the pixel class definition
#include <vector>
using namespace std;

class Sharpen {
    /*this class has an applySharpen method that has 2 parameters - image and the amount of increase
    in sharpness and returns the modified image vector.*/
public:
    static vector<vector<Pixel>> applySharpen(vector<vector<Pixel>>& image, float amount);
};
#endif