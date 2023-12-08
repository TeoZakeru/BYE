#pragma once
#include "../Pixel.h"
#include <vector>
using namespace std;

class Sepia {
public:
    static vector<vector<Pixel>> applySepia(vector<vector<Pixel>>& image);
};
