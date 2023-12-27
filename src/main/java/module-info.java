module particlesExerciseOne {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics; // Add this line

    opens exampple.particlesexerciseone to javafx.fxml;

    exports exampple.particlesexerciseone;
}