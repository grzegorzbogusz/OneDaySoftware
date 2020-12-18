package Figures;

import java.awt.*;


abstract public class Figure{

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Color color;
    protected Shape shape;

    public Figure(Color color, int x, int y, int width, int height) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    abstract public boolean isPositive();
    abstract public Shape getShape();
    abstract public Color getColor();

}
