package ClickableObjects;

import java.awt.*;

public class Square extends Figure {

    public Square(Color color, int width, int height) {
        super(color, width, height);
    }

    @Override
    public Shape getShape() {
        return new Rectangle(50, 50, width, height);
    }

    @Override
    public boolean isPositive() {
        return true;
    }

}
