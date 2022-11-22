package com.gltraining;

import com.gltraining.beans.Canvas;
import com.gltraining.beans.Circle;
import com.gltraining.beans.IShape;
import com.gltraining.beans.Square;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {

    public static void main(String args[]){
        ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);

        Canvas canvas1=context.getBean(Canvas.class);
        System.out.println("shape set in canvas="+canvas1.getShape().getClass().getSimpleName());
        canvas1.drawShape();
        System.out.println("***second canvas fetched  byname");
        Canvas canvas2=context.getBean("canvas", Canvas.class);
        canvas2.drawShape();


    }

}
