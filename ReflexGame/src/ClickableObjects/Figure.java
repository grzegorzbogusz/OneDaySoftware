package ClickableObjects;

import Game.GameComponent;

import java.awt.*;
import java.util.Random;

abstract public class Figure {

    protected Color color;
    protected int width;
    protected int height;
    protected Shape shape;

    public Figure(Color color, int width, int height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }

    public abstract Shape getShape();
    public abstract Color getColor();
    public abstract boolean isPositive();

    public int getRandomNumber(int limit) {
        Random random = new Random();
        return random.nextInt(limit);
    }

}
