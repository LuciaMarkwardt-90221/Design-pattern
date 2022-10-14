import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;

class GameWindow {
    private final GraphicsContext gc;
    private Scene scene;
    private BallPit model;

    GameWindow(BallPit model) {
        this.model = model;
        Pane pane = new Pane();
        this.scene = new Scene(pane, model.getWidth(), model.getHeight());
        Canvas canvas = new Canvas(model.getWidth(), model.getHeight());
        gc = canvas.getGraphicsContext2D();
        Button b1 =  new Button("generate red balls");
        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                model.makeBall("red");
            }
        };
        //b1.setOnAction(event1);
        Button b2 =  new Button("generate blue balls");
        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                model.makeBall("blue");
            }
        };
        //b2.setOnAction(event2);
        Button b3 =  new Button("generate black balls");
        EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                model.makeBall("black");
            }
        };
        b1.setOnAction(event1);
        b1.setLayoutX(100);
        b1.setLayoutY(0);
        b2.setOnAction(event2);
        b2.setLayoutX(250);
        b2.setLayoutY(0);
        b3.setOnAction(event3);
        b3.setLayoutX(400);
        b3.setLayoutY(0);
        pane.getChildren().add(canvas);
        pane.getChildren().add(b1);
        pane.getChildren().add(b2);
        pane.getChildren().add(b3);

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
