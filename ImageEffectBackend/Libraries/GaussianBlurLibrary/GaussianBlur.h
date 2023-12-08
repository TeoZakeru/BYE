#pragma once
#include "../Pixel.h"
#include <vector>
using namespace std;

class GaussianBlur{
public:
    static vector<vector<Pixel>> applyGaussianBlur(vector<vector<Pixel>>& image, float radius);
};
