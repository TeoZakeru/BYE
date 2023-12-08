#pragma once
#include "../Pixel.h"
#include <vector>
using namespace std;

class Invert {
public:
    static vector<vector<Pixel>> applyInvert(vector<vector<Pixel>>& image);
};
