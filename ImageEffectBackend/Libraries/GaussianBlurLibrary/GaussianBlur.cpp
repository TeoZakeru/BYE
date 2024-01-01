#include <iostream>
#include <vector>
#include <cmath>
#include"GaussianBlur.h"
using namespace std;



vector<vector<double>> generateGaussianKernel(int radius, double sigma) {
    //this function generates a 2d gaussian kernel
    int kernelSize = 2 * radius + 1;
    vector<vector<double>> kernel(kernelSize, vector<double>(kernelSize, 0.0));

    double sum = 0.0;
    for (int i = 0; i < kernelSize; i++) {
        for (int j = 0; j < kernelSize; j++) {
            kernel[i][j] = exp(-(i*i + j*j) / (2.0 * sigma * sigma)) / (2.0 * M_PI * sigma * sigma);
            sum += kernel[i][j];
        }
    }

    //normalizing the kernel to ensure that the sum of all values is 1
    for (int i = 0; i < kernelSize; ++i) {
        for (int j = 0; j < kernelSize; ++j) {
            kernel[i][j] /= sum;
        }
    }

    return kernel;//returning the kernel
}


vector<vector<Pixel>> convolve(vector<vector<Pixel>>& input, vector<vector<double>>& kernel) {
    //this method returns a convoluted output matrix
    int kernelSize = kernel.size();
    int imageHeight = input.size();
    int imageWidth = input[0].size();
    vector<vector<Pixel>> output(imageHeight, vector<Pixel>(imageWidth));
    int kernelRadius = kernelSize / 2;

    for (int i = 0; i < imageHeight; ++i) {
        for (int j = 0; j < imageWidth; ++j) {
            double sumR = 0.0, sumG = 0.0, sumB = 0.0;

            for (int ki = 0; ki < kernelSize; ++ki) {
                int xi = i - kernelRadius + ki;
                //clamping xi to ensure it stays within the valid range
                xi = max(0, min(imageHeight - 1, xi));

                for (int kj = 0; kj < kernelSize; ++kj) {
                    int yj = j - kernelRadius + kj;
                    //clamping yj to ensure it stays within the valid range
                    yj = max(0, min(imageWidth - 1, yj));

                    sumR += input[xi][yj].r * kernel[ki][kj];
                    sumG += input[xi][yj].g * kernel[ki][kj];
                    sumB += input[xi][yj].b * kernel[ki][kj];
                }
            }

            output[i][j].r = static_cast<int>(min(255.0, max(0.0, sumR)));
            output[i][j].g = static_cast<int>(min(255.0, max(0.0, sumG)));
            output[i][j].b = static_cast<int>(min(255.0, max(0.0, sumB)));
        }
    }
    return output;
}



vector<vector<Pixel>> GaussianBlur::applyGaussianBlur(vector<vector<Pixel>>& image, float radius) {
    //applyGaussianBlur method in GaussianBlur class
    int h = image.size();
    int w = image[0].size();
    double sigma = 5;  // Default value for sigma
    int radius_act=static_cast<int>(radius);
    int factor = int(radius/10);
	sigma+= (1+factor);
    vector<vector<double>> kernel = generateGaussianKernel(radius_act, sigma);
    

    vector<vector<Pixel>> result = convolve(image, kernel);


    return result; //returning the blurred image
}
