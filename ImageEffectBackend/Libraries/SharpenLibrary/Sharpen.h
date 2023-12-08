#pragma once
#include "../Pixel.h"
#include <vector>
using namespace std;

class Sharpen {
public:
    static vector<vector<Pixel>> applySharpen(vector<vector<Pixel>>& image, float amount);
};