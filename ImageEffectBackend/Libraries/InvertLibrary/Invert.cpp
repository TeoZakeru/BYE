#include "Invert.h"
using namespace std;

vector<vector<Pixel>> Invert::applyInvert(vector<vector<Pixel>> &image){
    //applyInvert method in Invert class
    vector<vector<Pixel>> resultImage;//the resultimage vector
    //modifying each individual pixel's values one-by-one using nested for loops
    for (auto &row:image){
        vector<Pixel> resultRow;//temporary vector
        for (auto &pixel : row){
            Pixel adjustedPixel;
            adjustedPixel.r = static_cast<int>(255 - pixel.r);
            adjustedPixel.g = static_cast<int>(255 - pixel.g);
            adjustedPixel.b = static_cast<int>(255 - pixel.b);
            resultRow.push_back(adjustedPixel);
        }
        resultImage.push_back(resultRow);
    }

    return resultImage;//returning the modified image vector
}
