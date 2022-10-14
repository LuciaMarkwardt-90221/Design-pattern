package Balls;

import Balls.Ball;
import javafx.scene.control.Label;

public class ballObserver implements Observer {

    private Ball theBall;

    private Double xPos;
    private Double yPos;
    private Label label;


    public ballObserver(Ball ball){
        this.theBall = ball;
    }

    @Override
    public void update(){
        xPos = theBall.getxPos();
        yPos = theBall.getyPos();

    }

    @Override
    public String observe(){
        String s1 = "The xPos is "+ xPos.toString();
        String s2 = "The yPos is "+ yPos.toString();
        String s3 = s1 + " "+ s2;

        return s3;

    }

}
