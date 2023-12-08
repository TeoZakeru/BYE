#include "Brightness.h"
using namespace std;

vector<vector<Pixel>> Brightness::applyBrightness(vector<vector<Pixel>>& image,float amount){

    vector<vector<Pixel>> resultImage;

    for(auto& row:image){
        vector<Pixel> resultRow;
        for(auto& pixel:row){
            Pixel adjustedPixel;
            adjustedPixel.r = static_cast<int>(pixel.r * amount/100);
            adjustedPixel.g = static_cast<int>(pixel.g * amount/100);
            adjustedPixel.b = static_cast<int>(pixel.b * amount/100);
            if(adjustedPixel.r>255){
                adjustedPixel.r = 255;
            }
            if(adjustedPixel.g>255){
                adjustedPixel.g = 255;
            }
            if(adjustedPixel.b>255){
                adjustedPixel.b = 255;
            }
            resultRow.push_back(adjustedPixel);
        }
        resultImage.push_back(resultRow);
    }

    return resultImage;
}
