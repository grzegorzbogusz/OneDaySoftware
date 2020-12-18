package ClickableObjects;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Figure {

    public Circle(Color color, int width, int height) {
        super(color, width, height);
    }

    public Shape getShape() {
        return new Ellipse2D.Double(50, 50, width, height);
    }

    @Override
    public boolean isPositive() {
        return true;
    }

}
