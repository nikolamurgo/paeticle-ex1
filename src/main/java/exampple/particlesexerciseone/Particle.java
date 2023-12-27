package exampple.particlesexerciseone;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Particle {
    private Point2D location; // x and y coordinates
    private Point2D velocity;
    private Point2D acceleration;
    private double lifespan=1.0;

    public Particle(Point2D l) {
        location = new Point2D(l.getX(), l.getY());
        acceleration = new Point2D(0,0.01);
        velocity = new Point2D(0,0);
    }

    public void update(){
        velocity = velocity.add(acceleration);
        location = location.add(velocity);
        lifespan -=0.005;
        if (lifespan <= 0){
            lifespan =0;
        }
    }

    public void display(GraphicsContext gc) {
        gc.setFill(Color.color(1.0,0.0,0.0, lifespan));
        gc.fillOval(location.getX(),location.getY(),40,40);
    }
}
