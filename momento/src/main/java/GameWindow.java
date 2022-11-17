import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

class GameWindow {

    private final GraphicsContext gc;
    private Scene scene;
    private BallPit model;

    private Momento state;

    GameWindow(BallPit model) {
        this.model = model;

        Pane pane = new Pane();
        this.scene = new Scene(pane, model.getWidth(), model.getHeight());
        Canvas canvas = new Canvas(model.getWidth(), model.getHeight());
        gc = canvas.getGraphicsContext2D();
        Button b1 =  new Button("Restore");
        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
               model.restore(state);
            }
        };

        Button b2 =  new Button("Save");
        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                state = model.save();
            }
        };


        b1.setOnAction(event1);
        b1.setLayoutX(100);
        b1.setLayoutY(0);
        b2.setOnAction(event2);
        b2.setLayoutX(200);
        b2.setLayoutY(0);
        pane.getChildren().add(canvas);
        pane.getChildren().add(b1);
        pane.getChildren().add(b2);
    }

    Scene getScene() {
        return this.scene;
    }

    void run() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(17),
                t -> this.draw()));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void draw() {
        model.tick();

        gc.clearRect(0, 0, model.getWidth(), model.getHeight());

        for (Ball ball: model.getBalls()) {
            gc.setFill(ball.getColour());
            gc.fillOval(ball.getxPos() - ball.getRadius(),
                        ball.getyPos() - ball.getRadius(),
                        ball.getRadius() * 2,
                        ball.getRadius() * 2);
        }
    }
}
