#pragma once
#include "../Pixel.h"
#include <vector>
using namespace std;

class Grayscale {
public:
    static vector<vector<Pixel>> applyGrayscale(vector<vector<Pixel>>& image);
};
