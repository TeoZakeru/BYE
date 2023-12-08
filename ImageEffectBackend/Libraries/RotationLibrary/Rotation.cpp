#include "Rotation.h"
using namespace std;

vector<vector<Pixel>> Rotation::applyRotation(vector<vector<Pixel>>& image, int value) {
    vector<vector<Pixel>> resultImage(image[0].size(), vector<Pixel>(image.size()));

    if (value == 0) {
        return image;
    }
    else if (value == 1) {
        // Rotate the image by 90 degrees clockwise
        for (int i = 0; i < image.size(); i++) {
            for (int j = 0; j < image[i].size(); j++) {
                resultImage[j][image.size() - 1 - i] = image[i][j];
            }
        }
    }
    else if (value == 2) {
        // Rotate the image by 180 degrees clockwise
        vector<vector<Pixel>>test;
        for(int i = image.size()-1;i>=0;i--){
            test.push_back(image[i]);
        }
        resultImage = test;
    }
    else if (value == 3) {
        // Rotate the image by 270 degrees clockwise
        for (int i = 0; i < image.size(); i++) {
            for (int j = 0; j < image[i].size(); j++) {
                resultImage[image[i].size() - 1 - j][i] = image[i][j];
            }
        }
    }
    else {
        // Handle other rotation values if needed
        // For example, you could return the original image
        return image;
    }

    return resultImage;
}
