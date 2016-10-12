/*
 * Copyright (c) 2016. The League of Amazing Programmers, All Rights Reserved
 */

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class GameController {

    private final LongProperty frameTime = new SimpleLongProperty();

    @FXML
    public Pane gamePane;

    private Ship ship;

    @FXML
    public void initialize() {
        ship = new Ship(this);
        gamePane.getChildren().add(ship);
        System.out.format(">%f %f\n", gamePane.getWidth(), gamePane.getHeight());

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                frameTime.set(now);

            }
        }.start();
    }

    long getFrameTime() {
        return frameTime.get();
    }

    LongProperty frameTimeProperty() {
        return frameTime;
    }

    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case DOWN:
                ship.moveDown();
                break;
            case ESCAPE:
                Platform.exit();
                break;
            case LEFT:
                ship.moveLeft();
                break;
            case RIGHT:
                ship.moveRight();
                break;
            case SPACE:
                ship.fire();
                break;
            case UP:
                ship.moveUp();
                break;
            default:
                break;
        }
    }

    void add(Projectile projectile) {
        gamePane.getChildren().add(projectile);
    }

    public Pane getGamePane() {
        return gamePane;
    }
}
