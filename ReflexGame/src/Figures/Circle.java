package Figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Figure {

    public Circle(Color color, int x, int y, int width, int height) {
        super(color, x, y, width, height);
        this.shape = new Ellipse2D.Double(x,y,width,height);
    }

    public Shape getShape() {
        return this.shape;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public boolean isPositive() {
        return true;
    }

}
