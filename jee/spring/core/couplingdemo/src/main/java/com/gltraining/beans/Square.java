package com.gltraining.beans;

import com.gltraining.beans.IShape;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class Square implements IShape {

    @Value("${square.side}")
    private int side;

    public int getSide(){
        return side;
    }

    public Square(){}
    public Square(int side) {
        this.side = side;
    }

    @Override
    public int area() {
        return side * side;
    }

}
