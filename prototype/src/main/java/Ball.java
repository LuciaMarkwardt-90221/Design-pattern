import javafx.scene.paint.Paint;

import java.util.*;

public class Ball implements ballPrototypeInterface{
    private double xPos;
    private double yPos;
    private double radius;
    private double xVel;
    private double yVel;
    private Paint colour;

    private String a;

    private Ball newBall;

    private ballStrategy blue;
    private ballStrategy red;

    private List<Observer> allObservers;
    private ballStrategy black;
    private int timer;

    Ball(double startX, double startY, double startRadius, Paint colour) {
        this.xPos = startX;
        this.yPos = startY;
        this.radius = startRadius;
        this.colour = colour;
        xVel = new Random().nextInt(5);
        yVel = new Random().nextInt(5);
    }

    void tick() {
        xPos += xVel;
        yPos += yVel;
    }

    void setxVel(double xVel) {
        this.xVel = xVel;
    }

    void setyVel(double yVel) {
        this.yVel = yVel;
    }

    double getRadius() {
        return radius;
    }

    double getxPos() {
        return xPos;
    }

    double getyPos() {
        return yPos;
    }

    Paint getColour() {
        return colour;
    }

    double getxVel() {
        return xVel;
    }

    double getyVel() {
        return yVel;
    }

    void setxPos(double xPos) {
        this.xPos = xPos;
    }

    void setyPos(double yPos) {
        this.yPos = yPos;
    }

    @Override
    public Ball makeCopy(){
        Ball newBall = null;
        try{
            newBall = (Ball) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return newBall;

    }

    void think(BallPit pit) {
        // Here is where the strategy should have some effect.
        // You can add parameters to the think method so the ball knows something about its
        // world to make decisions with, or you can inject things upon construction for it to query
        black = new blackBallStrategy();
        blue = new blueBallStrategy();
        red = new redBallStrategy();
        if(this.colour.toString().equalsIgnoreCase("Blue")){
            blue.move(this,pit);
        }
        if(this.colour.toString().equalsIgnoreCase("Red")){
            red.move(this,pit);
        }
        if(this.colour.toString().equalsIgnoreCase("Black")){
            black.move(this,pit);
        }

    }

    
}
