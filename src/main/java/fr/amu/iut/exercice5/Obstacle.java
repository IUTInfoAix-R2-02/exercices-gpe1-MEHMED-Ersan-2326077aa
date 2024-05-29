package fr.amu.iut.exercice5;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;



public class Obstacle extends Rectangle {
    private static String BASE_BACKGRUND = "-fx-background-color: ";
    private static String COLOR_RED = "red";

    public Obstacle() {
        super();
        super.setStyle(BASE_BACKGRUND+COLOR_RED);
    }

    public Obstacle(double x, double y) {
        super(x,y);
        super.setStyle(BASE_BACKGRUND+COLOR_RED);
    }

    public Obstacle(double x, double y, double wx, double hy) {
        super(x,y,wx,hy);
        super.setStyle(BASE_BACKGRUND+COLOR_RED);
    }


    public boolean estEnCollision(Personnage entite) {
        return getBoundsInParent().contains(entite.getBoundsInParent())
                || entite.getBoundsInParent().contains(getBoundsInParent());
    }

    public void handleCollision(Personnage entite) {
        if (!estEnCollision(entite))
            return;

        double thisX = getX();
        double thisY = getY();

        double entiteX = entite.getLayoutX();
        double entiteY = entite.getLayoutY();

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("x: " + thisX + " y: " + thisY + " wx: " + this.getWidth());
        System.out.println("ex: " + entiteX + " ey: " + entiteY);


    }

}
