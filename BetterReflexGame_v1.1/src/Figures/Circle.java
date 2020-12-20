package Figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Figure {

    public Circle(Color color, int width, int height) {
        super(color, width, height);
        this.shape = new Ellipse2D.Double(getRandomNumber(500), getRandomNumber(500), this.width, this.height);
    }

    @Override
    public Shape getShape() { return this.shape; }

    @Override
    public Color getColor() { return this.color; }

    @Override
    public boolean isPositive() {
        if(this.color==Color.BLUE)
            return true;
        else
            return false;
    }

}
