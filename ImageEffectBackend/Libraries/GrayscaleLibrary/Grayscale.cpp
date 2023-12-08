#include "Grayscale.h"
#include<iostream>
// #include<bits/stdc++.h>
// #include<unordered_map>
using namespace std;

vector<vector<Pixel>> Grayscale::applyGrayscale(vector<vector<Pixel>> &image) {
    vector<vector<Pixel>> resultImage;
    for(auto i:image){
        vector<Pixel>resut;
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

    return resultImage;
}
