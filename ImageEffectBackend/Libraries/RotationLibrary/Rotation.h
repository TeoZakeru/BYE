#pragma once
#include "../Pixel.h"
#include <vector>
using namespace std;

class Rotation {
public:
    static vector<vector<Pixel>> applyRotation(vector<vector<Pixel>>& image,int value);
};
