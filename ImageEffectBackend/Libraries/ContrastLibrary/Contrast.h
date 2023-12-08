#pragma once
#include "../Pixel.h"
#include <vector>
using namespace std;

class Contrast {
public:
    static vector<vector<Pixel>> applyContrast(vector<vector<Pixel>>& image, float amount);
};