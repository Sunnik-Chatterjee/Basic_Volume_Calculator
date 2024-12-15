package com.example.volumecalculator;

import android.widget.ImageView;
import android.widget.TextView;

public class Shape {
    int shapeImage;
    String ShapeText;

    public Shape(int shapeImage, String shapeText) {
        this.shapeImage = shapeImage;
        ShapeText = shapeText;
    }

    public int getShapeImage() {
        return shapeImage;
    }

    public void setShapeImage(int shapeImage) {
        this.shapeImage = shapeImage;
    }

    public String getShapeText() {
        return ShapeText;
    }

    public void setShapeText(String shapeText) {
        ShapeText = shapeText;
    }
}
