#include <iostream>
#include <vector>
#include <cmath>
#include"GaussianBlur.h"
using namespace std;


// Function to generate a 2D Gaussian kernel
vector<vector<double>> generateGaussianKernel(int radius, double sigma) {
    int kernelSize = 2 * radius + 1;
    vector<vector<double>> kernel(kernelSize, vector<double>(kernelSize, 0.0));

    double sum = 0.0;
    for (int i = 0; i < kernelSize; i++) {
        for (int j = 0; j < kernelSize; j++) {
            kernel[i][j] = exp(-(i*i + j*j) / (2.0 * sigma * sigma)) / (2.0 * M_PI * sigma * sigma);
            sum += kernel[i][j];
        }
    }

    // Normalize the kernel to ensure that the sum of all values is 1
    for (int i = 0; i < kernelSize; ++i) {
        for (int j = 0; j < kernelSize; ++j) {
            kernel[i][j] /= sum;
        }
    }

    return kernel;
}


std::vector<std::vector<Pixel>> convolve(std::vector<std::vector<Pixel>>& input, std::vector<std::vector<double>>& kernel) {
    int kernelSize = kernel.size();
    int imageHeight = input.size();
    int imageWidth = input[0].size();
    std::vector<std::vector<Pixel>> output(imageHeight, std::vector<Pixel>(imageWidth));
    int kernelRadius = kernelSize / 2;

    for (int i = 0; i < imageHeight; ++i) {
        for (int j = 0; j < imageWidth; ++j) {
            double sumR = 0.0, sumG = 0.0, sumB = 0.0; // Use double for more precision

            for (int ki = 0; ki < kernelSize; ++ki) {
                int xi = i - kernelRadius + ki;
                // Clamp xi to ensure it stays within the valid range
                xi = std::max(0, std::min(imageHeight - 1, xi));

                for (int kj = 0; kj < kernelSize; ++kj) {
                    int yj = j - kernelRadius + kj;
                    // Clamp yj to ensure it stays within the valid range
                    yj = std::max(0, std::min(imageWidth - 1, yj));

                    sumR += input[xi][yj].r * kernel[ki][kj];
                    sumG += input[xi][yj].g * kernel[ki][kj];
                    sumB += input[xi][yj].b * kernel[ki][kj];
                }
            }

            output[i][j].r = static_cast<int>(std::min(255.0, std::max(0.0, sumR)));
            output[i][j].g = static_cast<int>(std::min(255.0, std::max(0.0, sumG)));
            output[i][j].b = static_cast<int>(std::min(255.0, std::max(0.0, sumB)));
        }
    }
    return output;
}



std::vector<std::vector<Pixel>> GaussianBlur::applyGaussianBlur(std::vector<std::vector<Pixel>>& image, float radius) {
    int h = image.size();
    int w = image[0].size();
    // float factor = amount / 100.0;
    double sigma = 5;  // Default value for sigma
    int radius_act=static_cast<int>(radius);
    int factor = int(radius/10);
	sigma+= (1+factor);
    vector<vector<double>> kernel = generateGaussianKernel(radius_act, sigma);
    

    std::vector<std::vector<Pixel>> result = convolve(image, kernel);


    return result; // Return the sharpened image
}
