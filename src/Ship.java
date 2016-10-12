/*
 * Copyright (c) 2016. The League of Amazing Programmers, All Rights Reserved
 */


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

class Ship extends ImageView {

    private static final int SPEED = 10;
    private static Pane gamePane;

    Ship(Pane gamePane) {
        Ship.gamePane = gamePane;

        this.setImage(new Image("rocket.png"));
        this.setPreserveRatio(true);
        this.setFitHeight(50);
    }

    void moveUp() {
        this.setY(this.getY() - SPEED);
    }

    void moveDown() {
        this.setY(this.getY() + SPEED);
    }

    void moveLeft() {
        this.setX(this.getX() - SPEED);
    }

    void moveRight() {
        this.setX(this.getX() + SPEED);
    }
}
