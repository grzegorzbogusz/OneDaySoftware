package Figures;

import java.awt.*;

public class Square extends Figure {

    public Square(Color color, int x, int y, int width, int height) {
        super(color, x, y, width, height);
        this.shape = new Rectangle(x,y,width,height);
    }

    @Override
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
