#include <cmath>
#include <vector>
#include "HueSaturation.h"
#include<bits/stdc++.h>
using namespace std;

Pixel rgb(PixelNew pixelNew) {
    //this function converts hsv to rgb
    double h = pixelNew.h;
    double s = pixelNew.s;
    double v = pixelNew.v;

    h /= 60.0;
    s /= 100.0;
    v /= 100.0;

    double c = v * s;
    double x = c * (1 - abs(fmod(h, 2) - 1));
    double m = v - c;

    double r, g, b;

    if (h >= 0 && h < 1) {
        r = c;
        g = x;
        b = 0;
    } else if (h >= 1 && h < 2) {
        r = x;
        g = c;
        b = 0;
    } else if (h >= 2 && h < 3) {
        r = 0;
        g = c;
        b = x;
    } else if (h >= 3 && h < 4) {
        r = 0;
        g = x;
        b = c;
    } else if (h >= 4 && h < 5) {
        r = x;
        g = 0;
        b = c;
    } else {
        r = c;
        g = 0;
        b = x;
    }

    Pixel pixel;
    pixel.r = (r + m) * 255.0;
    pixel.g = (g + m) * 255.0;
    pixel.b = (b + m) * 255.0;

    return pixel;
}

PixelNew hsv(Pixel pixel) {
    //this function converts rgb to hsv
    double r = pixel.r / 255.0;
    double g = pixel.g / 255.0;
    double b = pixel.b / 255.0;

    double cmax = fmax(r, fmax(g, b));
    double cmin = fmin(r, fmin(g, b));
    double diff = cmax - cmin;
    double h = 0, s = 0;

    if (cmax == cmin) {
        h = 0;
    } else if (cmax == r) {
        h = fmod(60 * ((g - b) / diff) + 360, 360);
    } else if (cmax == g) {
        h = fmod(60 * ((b - r) / diff) + 120, 360);
    } else if (cmax == b) {
        h = fmod(60 * ((r - g) / diff) + 240, 360);
    }

    if (cmax != 0) {
        s = (diff / cmax) * 100;
    }

    double v = cmax * 100;

    PixelNew pixelNew;
    pixelNew.h = h;
    pixelNew.s = s;
    pixelNew.v = v;

    return pixelNew;
}

vector<vector<Pixel>> HueSaturation::applyHueSaturation(vector<vector<Pixel>>& image, float saturationValue, float hueValue) {
    //applyHueSaturation method in HueSaturation class
    vector<vector<Pixel>> result;//the resultvector
    for (auto i : image) {
        vector<Pixel> arr;//temporary vector
        for (auto j : i) {
            float p1 = sqrt(j.r*j.r*0.299+j.g*j.g*0.587+j.b*j.b*0.114);
            Pixel x;
            x.r = min(255.0f,max(0.0f,(p1+(j.r-p1)*saturationValue/50)));
            x.g = min(255.0f,max(0.0f,p1+(j.g-p1)*saturationValue/50));
            x.b = min(255.0f,max(0.0f,p1+(j.b-p1)*saturationValue/50));
            PixelNew pixel = hsv(x);//converting rgb to hsv
            pixel.h = fmod((pixel.h + hueValue), 360.0); //adjusting hue within the range of 0 to 360
            Pixel p = rgb(pixel);//converting hsv to rgb
            arr.push_back(p);
        }
        result.push_back(arr);
    }
    return result;//returning the modified image vector
}
