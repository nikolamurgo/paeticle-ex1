package exampple.particlesexerciseone;

import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {

    ArrayList<Particle> particles = new ArrayList<Particle>();

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Particle Effect"); // gui title

        StackPane root = new StackPane();
        Canvas canvas = new Canvas(800, 600); // canvas size
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

//        Particle particle = new Particle(new Point2D(400, 100));
        for (int i=0; i<10; i++){
            particles.add(new Particle());
        }
        Scene scene = new Scene(root,800,600,Color.WHITE);

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                for (Particle p : particles){
                    p.update();
                    p.display(gc);
                }

            }
        }.start();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}