#ifndef DOMINANT_COLOUR_H
#define DOMINANT_COLOUR_H
#pragma once
#include "../Pixel.h"//including the pixel class definition
#include <vector>
using namespace std;

class DominantColour {
    /*this class has an applyDominantColour method that has 1 parameter - image and 
    returns the modified image vector.*/
public:
    static vector<vector<Pixel>> applyDominantColour(vector<vector<Pixel>>& image);
};
#endif
