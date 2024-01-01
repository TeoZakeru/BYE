#ifndef SEPIA_H
#define SEPIA_H
#pragma once
#include "../Pixel.h"//including the pixel class definition
#include <vector>
using namespace std;

class Sepia {
    /*this class has an applySepia method that has 1 parameter - image 
    and returns the modified image vector.*/
public:
    static vector<vector<Pixel>> applySepia(vector<vector<Pixel>>& image);
};
#endif