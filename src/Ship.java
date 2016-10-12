/*
 * Copyright (c) 2016. The League of Amazing Programmers, All Rights Reserved
 */


class Ship extends GameObject {

    Ship(GameController gameController) {
        super(gameController);

        this.setX(gameController.getGamePane().getWidth() * 0.5 - this.getBoundsInLocal().getWidth() * 0.5);
        this.setY(gameController.getGamePane().getHeight() - this.getBoundsInLocal().getHeight());

        System.out.format("%f %f\n", this.getX(), this.getY());
    }


    void moveUp() {
        this.setY(this.getY() - speed);
    }

    void moveDown() {
        this.setY(this.getY() + speed);
    }

    void moveLeft() {
        this.setX(this.getX() - speed);
    }

    void moveRight() {
        this.setX(this.getX() + speed);
    }

    void fire() {
        Projectile p = new Projectile(gameController);
        p.setX(this.getX() + this.getBoundsInLocal().getWidth() / 2.0 - p.getBoundsInLocal().getWidth() / 2.0);
        p.setY(this.getY() - p.getBoundsInLocal().getHeight());
        gameController.add(p);

    }

    @Override
    long getPresetHeight() {
        return 50;
    }

    @Override
    String getImageURL() {
        return "rocket.png";
    }
}
