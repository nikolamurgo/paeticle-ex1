package exampple.particlesexerciseone;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Particle {
    public Point2D location; // x and y coordinates represented as a vector
    private Point2D velocity; // direction vector
    private Point2D acceleration; // speeding
    private double lifespan=1.0; // for transparency and killing particle

    public Particle() {
        location = new Point2D(400,600);
        acceleration = new Point2D(0,-Math.random()*0.03);

        double rdX = Math.random()*2-1;
        double rdY = Math.random()*2-1;

        velocity = new Point2D(rdX,rdY).normalize();
    }

    public void update(){
        velocity = velocity.add(acceleration);
        location = location.add(velocity);
        lifespan -=0.008;
        if (lifespan <= 0){
            lifespan =0;
        }
    }

    // method t/f for life of particle
    boolean killParticle(){
        if(lifespan <= 0){
            return true;
        }else{
            return false;
        }
    }

    public void display(GraphicsContext gc) {
        gc.setFill(Color.color(1,1,1, lifespan)); // set color of particle and alpha
        gc.fillOval(location.getX(),location.getY(),15,20); // size of particle
//        gc.strokeOval(location.getX(),location.getY(),20,20);
//        gc.setStroke(Color.BLACK);
    }
}
