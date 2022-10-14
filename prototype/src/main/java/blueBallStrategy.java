public class blueBallStrategy implements ballStrategy {

    @Override
    public void move(Ball ball, BallPit pit){
        if(ball.getxVel() <= 0){
            ball.setxVel(ball.getxVel() + 0.017);
        }

        if(ball.getxVel() > 0){
            ball.setxVel(ball.getxVel() - 0.017);
        }

        if(ball.getyVel() <= 0){
            ball.setyVel(ball.getyVel() + 0.017);
        }

        if(ball.getyVel() > 0){
            ball.setyVel(ball.getyVel() - 0.017);
        }

        }
        
    }
