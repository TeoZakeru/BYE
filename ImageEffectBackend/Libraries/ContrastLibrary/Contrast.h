#pragma once
#include "../Pixel.h"//including the pixel class definition
#include <vector>
using namespace std;

class Contrast {
    /*this class has an applyContrast method that has 2 parameters - image and the amount of change
    in contrast and returns the modified image vector.*/ 
public:
    static vector<vector<Pixel>> applyContrast(vector<vector<Pixel>>& image, float amount);
};