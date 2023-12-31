#include "Rotation.h"
using namespace std;

vector<vector<Pixel>> Rotation::applyRotation(vector<vector<Pixel>>& image, int value) {
    //applyRotation method in Rotation class
    vector<vector<Pixel>> resultImage(image[0].size(), vector<Pixel>(image.size()));
    //result image vector

    //checking the cases one-by-one

    if (value == 0) {
        //case where there is no rotation
        return image;
    }
    else if (value == 1) {
        //case where the rotation is by 90 degrees in clock-wise direction
        for (int i = 0; i < image.size(); i++) {
            for (int j = 0; j < image[i].size(); j++) {
                resultImage[j][image.size() - 1 - i] = image[i][j];
            }
        }
    }
    else if (value == 2) {
        //case where the rotation is by 180 degrees in clock-wise direction
        vector<vector<Pixel>>test;//temporary vector
        for(int i = image.size()-1;i>=0;i--){
            test.push_back(image[i]);
        }
        resultImage = test;
    }
    else if (value == 3) {
        //case where the rotation is by 270 degrees in clock-wise direction
        for (int i = 0; i < image.size(); i++) {
            for (int j = 0; j < image[i].size(); j++) {
                resultImage[image[i].size() - 1 - j][i] = image[i][j];
            }
        }
    }
    else {
        return image;
    }

    return resultImage;//returning the modified image vector
}