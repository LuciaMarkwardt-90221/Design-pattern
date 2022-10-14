package Balls;

import Balls.Ball;
import Balls.BallPit;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javafx.scene.control.Label;

class GameWindow {
    private final GraphicsContext gc;
    private Scene scene;
    private BallPit model;
    private Label redLabel;
    private Label blueLabel;
    private Label blackLabel;

    GameWindow(BallPit model) {
        this.model = model;

        Pane pane = new Pane();
        this.scene = new Scene(pane);
        Canvas canvas = new Canvas(model.getWidth(), model.getHeight());
        gc = canvas.getGraphicsContext2D();

        blackLabel = new Label();
        redLabel = new Label();
        redLabel.setLayoutX(0);
        redLabel.setLayoutY(20);
        blueLabel = new Label();
        blueLabel.setLayoutX(0);
        blueLabel.setLayoutY(40);

        pane.getChildren().add(blackLabel);
        pane.getChildren().add(redLabel);
        pane.getChildren().add(blueLabel);
        pane.getChildren().add(canvas);

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
            if(ball.getColourStr().equalsIgnoreCase("BLACK")){
                blackLabel.setText(ball.getAllObservers().get(0).observe());
            }
            else if(ball.getColourStr().equalsIgnoreCase("BLUE")){
                blueLabel.setText(ball.getAllObservers().get(0).observe());
            }
            else if(ball.getColourStr().equalsIgnoreCase("RED")){
                redLabel.setText(ball.getAllObservers().get(0).observe());
            }
        }
    }
}
