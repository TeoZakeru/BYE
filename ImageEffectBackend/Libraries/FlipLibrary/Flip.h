#pragma once
#include "../Pixel.h"//including the pixel class definition
#include <vector>
using namespace std;

class Flip {
    /*this class has an applyFlip method that has 3 parameters - image, the horizontalFlipValue and the
    verticalFlipValue and returns the modified image vector.*/
public:
    static vector<vector<Pixel>> applyFlip(vector<vector<Pixel>>& image,int horizantalFlipValue,int verticalFlipValue);
};
