/*
 * Copyright (c) 2016. The League of Amazing Programmers, All Rights Reserved
 */

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

abstract class GameObject extends ImageView {
    GameController gameController;
    int speed = 10;

    GameObject(GameController gameController) {
        this.gameController = gameController;

        this.setImage(new Image(getImageURL()));
        this.setFitHeight(getHeight());
        this.setPreserveRatio(true);

        gameController.frameTimeProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue.equals(0)) return;
            frameUpdate(newValue.longValue(), newValue.longValue() - oldValue.longValue());
        });

        // TODO Remove listener
    }

    void frameUpdate(long now, long timeSinceUpdate) {
        // No action by default
    }

    abstract int getHeight();

    abstract String getImageURL();

}
