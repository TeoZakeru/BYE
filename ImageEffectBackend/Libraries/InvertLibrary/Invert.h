#pragma once
#include "../Pixel.h"
#include <vector>
using namespace std;

class Invert {
    /*this class has an applyInvert method that has 1 parameter - image
     and returns the modified image vector.*/
public:
    static vector<vector<Pixel>> applyInvert(vector<vector<Pixel>>& image);
};
