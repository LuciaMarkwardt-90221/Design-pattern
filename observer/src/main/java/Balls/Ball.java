package Balls;

import javafx.scene.paint.Paint;

import java.util.*;

public class Ball implements Subject {
    private double xPos;
    private double yPos;
    private double radius;
    private double xVel;
    private double yVel;
    private Paint colour;
    private String colourStr;

    private String a;

    private ballStrategy blue;
    private ballStrategy red;

    private List<Observer> allObservers;
    private ballStrategy black;

    Ball(double startX, double startY, double startRadius, String colour) {
        this.xPos = startX;
        this.yPos = startY;
        this.radius = startRadius;
        this.colour = Paint.valueOf(colour);
        this.colourStr = colour;
        xVel = new Random().nextInt(5);
        yVel = new Random().nextInt(5);
        this.allObservers = new ArrayList<Observer>();
    }

    void tick() {
        xPos += xVel;
        yPos += yVel;
        notifyObserver();
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

    Paint getColour(){return this.colour;}
    String getColourStr() {return this.colourStr;}


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

    List<Observer> getAllObservers(){
        return allObservers;
    }


    void think(BallPit pit) {
        // Here is where the strategy should have some effect.
        // You can add parameters to the think method so the ball knows something about its
        // world to make decisions with, or you can inject things upon construction for it to query
        black = new blackBallStrategy();
        blue = new blueBallStrategy();
        red = new redBallStrategy();
        if(this.colourStr.equalsIgnoreCase("Blue")){
            blue.move(this,pit);
        }
        if(this.colourStr.equalsIgnoreCase("Red")){
            red.move(this,pit);
        }
        if(this.colourStr.equalsIgnoreCase("Black")){
            black.move(this,pit);
        }

    }
    @Override
    public void attach(Observer o) {
        allObservers.add(o);
    }

    @Override
    public void detach(Observer o) {
        allObservers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for(Observer o: allObservers){
            o.update();
            o.observe();
        }

    }

}
