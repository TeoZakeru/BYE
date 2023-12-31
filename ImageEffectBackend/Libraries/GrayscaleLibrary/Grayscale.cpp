#include "Grayscale.h"
#include<iostream>
using namespace std;

vector<vector<Pixel>> Grayscale::applyGrayscale(vector<vector<Pixel>> &image) {
    //applyGrayscale method in Grayscale class
    vector<vector<Pixel>> resultImage;//the resultimage vector
    //modifying each individual pixel's values one-by-one using nested for loops
    for(auto i:image){
        vector<Pixel>resut;//temporary vector
        for(auto j:i){
            Pixel p;
            int avg = (j.r+j.g+j.b)/3;
            p.r = avg;
            p.g = avg;
            p.b = avg;
            resut.push_back(p);
        }
        resultImage.push_back(resut);
    }

    return resultImage;//returning the modified image vector
}
