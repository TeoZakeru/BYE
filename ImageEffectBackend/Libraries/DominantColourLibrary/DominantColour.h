#pragma once
#include "../Pixel.h"
#include <vector>
using namespace std;

class DominantColour {
public:
    static vector<vector<Pixel>> applyDominantColour(vector<vector<Pixel>>& image);
};
