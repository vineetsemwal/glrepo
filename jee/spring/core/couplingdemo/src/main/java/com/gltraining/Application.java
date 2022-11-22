package com.gltraining;

import com.gltraining.beans.Canvas;
import com.gltraining.beans.Square;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {

    public static void main(String args[]){
        ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        Canvas canvas=context.getBean(Canvas.class);
        System.out.println("shape set in canvas="+canvas.getShape().getClass().getSimpleName());
        canvas.drawShape();


    }
}
