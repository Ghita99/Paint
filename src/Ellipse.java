import java.awt.* ;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

public class Ellipse extends Figure {

    double Pi = 3.141;

    protected int AxeY;
    protected int AxeX;

    ///////////////// les constructeurs :
    public Ellipse(int x, int y, Color c) {
        super(x, y, c);
    }

    public Ellipse(int X, int Y) {
        super(new Point());
        this.AxeY = Y;
        this.AxeX = X;
    }



    /////////////// les getters
    public int getAxeY() {
        return AxeY;
    }

    public int getAxeX() {
        return AxeX;
    }

    //les setters
    public void setAxeY(int y) {
        this.AxeY = y;
    }

    public void setAxeX(int x) {
        this.AxeX = x;
    }


    /// les methodes getsurface et getPerimetre/////
    public double getSurface() {

        return (AxeY * AxeX * PI) / 4;
    }

    public double getPerimetre() {
        return (2 * PI * sqrt((AxeY * AxeX + AxeY * AxeX)) / 2);
    }


    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.AxeY = hauteurBB;
        this.AxeX = largeurBB;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        g.fillOval(this.origine.getX(), this.origine.getY(), this.AxeY, this.AxeX);
    }


}