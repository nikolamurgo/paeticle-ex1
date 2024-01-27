package exampple.particlesexerciseone;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
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

    private int pps = 3000;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Particle Effect"); // gui title

        StackPane root = new StackPane();
        Canvas canvas = new Canvas(800, 600); // canvas size
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Scene scene = new Scene(root,800,800,Color.BLACK);


        new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

                int pts = pps/60;
                for (int i=0; i< pts; i++){
                    particles.add(new Particle());
                }

                for (int i=particles.size()-1; i >= 0; i--){
                    Particle p = particles.get(i);
                    p.update();
                    p.display(gc);

                    if (p.killParticle()){
                        particles.remove(i);
                    }
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