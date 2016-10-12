/*
 * Copyright (c) 2016. The League of Amazing Programmers, All Rights Reserved
 */


class Ship extends GameObject {

    Ship(GameController gameController) {
        super(gameController);
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
        p.setX(this.getX());
        p.setY(this.getY());
        gameController.add(p);

    }

    @Override
    int getHeight() {
        return 50;
    }

    @Override
    String getImageURL() {
        return "rocket.png";
    }
}
