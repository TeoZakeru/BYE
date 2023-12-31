#pragma once
#include "../Pixel.h"//including the pixel class definition
#include <vector>
using namespace std;

class Rotation {
    /*this class has an applyInvert method that has 2 parameter - image,
    the rotation value and returns the modified image vector.*/
public:
    static vector<vector<Pixel>> applyRotation(vector<vector<Pixel>>& image,int value);
};
