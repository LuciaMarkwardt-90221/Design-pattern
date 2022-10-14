import javafx.scene.paint.Paint;

import java.util.*;

public class prototypeFactory {

    private static Map<String,Ball > allTheBalls = new HashMap<>();

    public prototypeFactory(){
        Ball redBall = new Ball(100, 100, 20, Paint.valueOf("RED"));
        Ball blackBall = new Ball(200, 200, 20, Paint.valueOf("BLACK"));
        Ball blueBall = new Ball(300, 300, 20, Paint.valueOf("BLUE"));
        allTheBalls.put("red",redBall);
        allTheBalls.put("black",blackBall);
        allTheBalls.put("blue",blueBall);

    }

    public static Ball getClone(String colour){
        return allTheBalls.get(colour).makeCopy();
    }
}
