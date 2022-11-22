package com.gltraining.beans;

import org.springframework.stereotype.Component;

//@Component
public class Circle implements IShape {

    private int radius;

    public Circle(){}

    public Circle(int radius){
        this.radius=radius;
    }

    @Override
    public int area(){
        return (int)(3.14*radius*radius);
    }

}
