package Balls;

import Balls.Ball;
import Balls.BallPit;
import Balls.ballStrategy;

public class blackBallStrategy implements ballStrategy {

    @Override
    public void move(Ball ball, BallPit pit) {
        if(ball.getxPos() < pit.getWidth()/2){
            ball.setxVel(ball.getxVel() - 0.017);
        }

        if(ball.getyPos() < pit.getHeight()/2){
            ball.setyVel(ball.getyVel() - 0.017);
        }

        if(ball.getxPos() >= pit.getWidth()/2){
            ball.setxVel(ball.getxVel() + 0.017);
        }

        if(ball.getyPos() >= pit.getHeight()/2){
            ball.setyVel(ball.getyVel() + 0.017);
        }
    }
}