#include "Contrast.h"
using namespace std;


vector<vector<Pixel>> Contrast::applyContrast(vector<vector<Pixel>>& image, float amount) {
  
    std::vector<std::vector<Pixel>> resultImage;

    for (const auto& row : image) {
        std::vector<Pixel> resultRow;
        for (const auto& pixel : row) {
            Pixel adjustedPixel;
            float factor=amount/100;
            adjustedPixel.r = static_cast<int>(factor *(pixel.r-128)+128);
            adjustedPixel.g = static_cast<int>(factor *(pixel.g-128)+128);
            adjustedPixel.b = static_cast<int>(factor *(pixel.b-128)+128);
            if(adjustedPixel.r>255){
                adjustedPixel.r = 255;
            }
            if(adjustedPixel.g>255){
                adjustedPixel.g = 255;
            }
            if(adjustedPixel.b>255){
                adjustedPixel.b = 255;
            }
            if(adjustedPixel.r<0){
                adjustedPixel.r = 0;
            }
            if(adjustedPixel.g<0){
                adjustedPixel.g = 0;
            }
            if(adjustedPixel.b<0){
                adjustedPixel.b = 0;
            }
            resultRow.push_back(adjustedPixel);
        }
        resultImage.push_back(resultRow);
    }




    return resultImage;
}