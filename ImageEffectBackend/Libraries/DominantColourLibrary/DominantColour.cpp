#include "DominantColour.h"
#include<iostream>
#include<unordered_map>
using namespace std;

struct Triplet {
    int first, second, third;

    //constructor
    Triplet(int f, int s, int t) : first(f), second(s), third(t) {}

    //overloading the equality operator
    bool operator==(const Triplet& other) const {
        return first == other.first && second == other.second && third == other.third;
    }
};

//this function finds the triplet with the highest frequency
Triplet findMostFrequentTriplet(vector<Triplet>& triplets) {
    int size=256;
    vector<vector<vector<int>>> threeDVector(size, vector<vector<int>>(size,vector<int>(size, 0)));
    Triplet mostFrequentTriplet = triplets[0]; 
    int maxFrequency = 0; 
    for (const auto& triplet : triplets) {
        //incrementing frequency in the hash table
        int first=triplet.first;
        int second=triplet.second;
        int third=triplet.third;
        int frequency = threeDVector[first][second][third]++;
        
        //updating mostFrequentTriplet if necessary
        if (frequency > maxFrequency) {
            maxFrequency = frequency;
            mostFrequentTriplet = triplet;
        }
    }

    return mostFrequentTriplet;
}

vector<vector<Pixel>> DominantColour::applyDominantColour(vector<vector<Pixel>> &image) {
    //applyDominantColour method in DominantColour class
    vector<vector<Pixel>> resultImage;//the resultvector
    vector<Pixel>pix;

    for(auto i:image){
        for(auto j:i){
            pix.push_back(j);
        }
    }
    vector<Triplet>pixels;
    for(auto i:pix){
        Triplet t(i.r,i.g,i.b);
        pixels.push_back(t);
    }

    Triplet maxx = findMostFrequentTriplet(pixels);//finding the most frequent triplet
    Pixel maxPixel;
    maxPixel.r = maxx.first;
    maxPixel.g = maxx.second;
    maxPixel.b = maxx.third;

    //applying the dominant Pixel to all pixels in the result image
    for (auto &row : image) {
        vector<Pixel> resultRow;//temporary vector
        for (auto &pixel : row) {
            resultRow.push_back(maxPixel);
        }
        resultImage.push_back(resultRow);
    }

    return resultImage;//returning the modified image vector
}
