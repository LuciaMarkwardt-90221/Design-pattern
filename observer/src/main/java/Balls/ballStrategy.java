package Balls;

import Balls.Ball;
import Balls.BallPit;

public interface ballStrategy {
    public void move(Ball ball, BallPit pit);
}
