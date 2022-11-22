package com.gltraining.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Canvas {

    private IShape shape;

    public IShape getShape(){
        return shape;
    }

    public Canvas(){}

    public Canvas(IShape shape){
        this.shape =shape;
    }

    @Autowired
    public void setShape(IShape shape){
        this.shape = shape;
    }


    public void drawShape() {
        System.out.println(shape.getClass().getSimpleName()+"getting drawn with area=" + shape.area());
    }


}
