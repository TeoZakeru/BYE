#include "Sharpen.h"
#include<vector>
using namespace std;

vector<vector<Pixel>> convolve(vector<vector<Pixel>>& input,  vector<vector<int>>& kernel) {
    //this method returns a convoluted output matrix
    int kernelSize = kernel.size();
    int imageHeight = input.size();
    int imageWidth = input[0].size();
    vector<vector<Pixel>> output(imageHeight, vector<Pixel>(imageWidth));
    int kernelRadius = kernelSize / 2;

    for (int i = 0; i < imageHeight; ++i) {
        for (int j = 0; j < imageWidth; ++j) {
            int sumR = 0, sumG = 0, sumB = 0;

            for (int ki = 0; ki < kernelSize; ++ki) {
                int xi = i - kernelRadius + ki;
                if (xi < 0 || xi >= imageHeight) continue;

                for (int kj = 0; kj < kernelSize; ++kj) {
                    int yj = j - kernelRadius + kj;
                    if (yj < 0 || yj >= imageWidth) continue;

                    sumR += input[xi][yj].r * kernel[ki][kj];
                    sumG += input[xi][yj].g * kernel[ki][kj];
                    sumB += input[xi][yj].b * kernel[ki][kj];
                }
            }
            //making sure the pixel's rgb values stay within 0 to 255
            output[i][j].r = min(255, max(0, sumR));
            output[i][j].g = min(255, max(0, sumG));
            output[i][j].b = min(255, max(0, sumB));
        }
    }
    return output;
}



vector<vector<Pixel>> Sharpen::applySharpen(vector<vector<Pixel>>& image, float amount) {
    //applySharpen method in Sharpen class
    int h = image.size();
    int w = image[0].size();
    float factor = amount / 100.0;

    vector<vector<int>> kernel = {{0, -1, 0}, {-1, 5, -1}, {0, -1, 0}};
    //sharpening kernel

    vector<vector<Pixel>> result = convolve(image, kernel);//calling the convolve method

    
    //nested for loop that changes each individual pixel's rgb values one-by-one 
    for (int i = 0; i < h; ++i) {
        for (int j = 0; j < w; ++j) {
            
            int newR = (1 - factor)*image[i][j].r+ static_cast<int>(factor * result[i][j].r);
            int newG = (1 - factor)*image[i][j].g+static_cast<int>(factor * result[i][j].g);
            int newB = (1 - factor)*image[i][j].b+static_cast<int>(factor * result[i][j].b);
            //ensuring that the pixel's rgb values stay within 0 to 255

            image[i][j].r=min(255,max(0,newR));
            image[i][j].g=min(255,max(0,newG));
            image[i][j].b=min(255,max(0,newB));

           

        }
    }

    return image;//returning the modified image vector
}