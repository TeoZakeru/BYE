#pragma once
#include "../Pixel.h"//including the pixel class definition
#include <vector>
using namespace std;

class Grayscale {
    /*this class has an applyGrayscale method that has 1 parameter - image
    and returns the modified image vector.*/
public:
    static vector<vector<Pixel>> applyGrayscale(vector<vector<Pixel>>& image);
};
