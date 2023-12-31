#include "Flip.h"
using namespace std;

vector<vector<Pixel>> Flip::applyFlip(vector<vector<Pixel>>& image,int horizontalFlipValue,int verticalFlipValue){
    //applyFlip method in Flip class
    vector<vector<Pixel>>resultImage;//the result vector
    //checking for the values of horizontalFlipValue and verticalFlipValue variables
    if(horizontalFlipValue>0 && verticalFlipValue==0){
        //case where the image is to be only horizontally flipped
        for(auto i:image){
            vector<Pixel>row(i.size());
            for(int j = i.size()-1;j>=0;j--){
                row[i.size()-1-j]=i[j];
            }
            resultImage.push_back(row);
        }
    }
    else if(verticalFlipValue>0 && horizontalFlipValue==0){
        //case where the image is to be only vertically flipped
        for(int i = image.size()-1;i>=0;i--){
            resultImage.push_back(image[i]);
        }
    }
    else if (verticalFlipValue > 0 && horizontalFlipValue > 0) {
        //case where the image is to be horizontally and vertically flipped
        for (int i = image.size() - 1; i >= 0; i--) {
            vector<Pixel> row(image[i].size());
            for (int j = image[i].size() - 1; j >= 0; j--) {
                row[image[i].size() - 1 - j] = image[i][j];
            }
            resultImage.push_back(row);
        }
    }
    else{
        //case where the image is not to be flipped
        return image;
    }
    return resultImage;//returning the modified image vector
}