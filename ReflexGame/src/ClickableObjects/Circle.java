package ClickableObjects;

import java.awt.*;

public class Circle extends Figure {

    public Circle(Color color, int width, int height) {
        super(color, width, height);
        this.shape = new Rectangle(getRandomNumber(500), getRandomNumber(500), this.width, this.height);
    }

    @Override
    public Shape getShape() { return this.shape; }

    @Override
    public Color getColor() { return this.color; }

    @Override
    public boolean isPositive() {
        return true;
    }

}
