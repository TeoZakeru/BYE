#pragma once
#include "../Pixel.h"
#include <vector>
using namespace std;

class Flip {
public:
    static vector<vector<Pixel>> applyFlip(vector<vector<Pixel>>& image,int horizantalFlipValue,int verticalFlipValue);
};
