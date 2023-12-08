#include "Invert.h"
using namespace std;

vector<vector<Pixel>> Invert::applyInvert(vector<vector<Pixel>> &image){
    vector<vector<Pixel>> resultImage;
    for (auto &row:image){
        vector<Pixel> resultRow;
        for (auto &pixel : row){
            Pixel adjustedPixel;
            adjustedPixel.r = static_cast<int>(255 - pixel.r);
            adjustedPixel.g = static_cast<int>(255 - pixel.g);
            adjustedPixel.b = static_cast<int>(255 - pixel.b);
            resultRow.push_back(adjustedPixel);
        }
        resultImage.push_back(resultRow);
    }

    return resultImage;
}
