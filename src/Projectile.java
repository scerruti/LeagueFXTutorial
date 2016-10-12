/*
 * Copyright (c) 2016. The League of Amazing Programmers, All Rights Reserved
 */

import java.util.concurrent.TimeUnit;

class Projectile extends GameObject {

    private boolean firstUpdate = true;

    Projectile(GameController gameController) {
        super(gameController);
        speed = 1;
    }

    @Override
    int getHeight() {
        return 15;
    }

    @Override
    String getImageURL() {
        return "bullet.png";
    }

    @Override
    void frameUpdate(long now, long timeSinceUpdate) {
        if (firstUpdate) {
            firstUpdate = false;
            return;
        }
        double duration = TimeUnit.MILLISECONDS.toSeconds(timeSinceUpdate) / 1000.0;
        this.setY(this.getY() - (duration * speed));
    }
}
