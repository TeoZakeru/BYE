#ifndef HUE_SATURATION_H
#define HUE_SATURATION_H
#include<vector>
#include "../Pixel.h"

using namespace std;
class HueSaturation{
    public:
    static vector<vector<Pixel>> applyHueSaturation(vector< vector<Pixel> > &image, float saturationValue, float hueValue);
};
struct PixelNew{
    float h;
    float s;
    float v;
};
#endif
