package exampple.particlesexerciseone;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;



public class Particle {
    private Point2D location;
    private Point2D velocity;
    private Point2D acceleration;

    public Particle(Point2D l) {
        location = new Point2D(l.getX(), l.getY());
        acceleration = new Point2D(0,0);
        velocity = new Point2D(0,0);
    }

    public void update(){
        velocity = velocity.add(acceleration);
        location = location.add(velocity);
    }

    public void display(GraphicsContext gc) {
        Color color = Color.rgb(1,255,0);
        gc.setFill(color);
        gc.fillOval(location.getX(),location.getY(),5,5);
    }
}
