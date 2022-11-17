import java.util.ArrayList;
import java.util.List;

public class Momento {


    private List<Ball> ballStates = new ArrayList<Ball>();

    public Momento(List<Ball> balls){
        for(Ball b: balls){
            Ball x = new Ball(b.getxPos(),b.getyPos(),b.getRadius(),b.getColour());
            x.setxVel(b.getxVel());
            x.setyVel(b.getyVel());
            ballStates.add(x);
        }

    }

    public List<Ball> getBallStates(){
        return ballStates;
    }
}
