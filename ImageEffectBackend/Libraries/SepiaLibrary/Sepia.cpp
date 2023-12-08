#include "Sepia.h"
using namespace std;

vector<vector<Pixel>> Sepia::applySepia(vector<vector<Pixel>>& image) {
    vector<vector<Pixel>> resultImage;

    for (const auto& row : image) {
        vector<Pixel> resultRow;
        for (const auto& pixel : row) {
            Pixel adjustedPixel;
            adjustedPixel.r = static_cast<int>(pixel.r * 0.393+pixel.g*0.769+pixel.b*0.189);
            adjustedPixel.g = static_cast<int>(pixel.r * 0.349+pixel.g*0.686+pixel.b*0.168);
            adjustedPixel.b = static_cast<int>(pixel.r * 0.272+pixel.g*0.534+pixel.b*0.131);
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
