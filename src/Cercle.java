import java.awt.* ;

import static java.lang.Math.PI;

public class Cercle extends Ellipse {
    int r;

    public Cercle(int Rayon) {
        super(Rayon, Rayon);
        this.r = Rayon;
    }

    public Cercle(int rayon, Color color) {
        super(rayon, rayon);
        this.r = rayon;
        this.c = color;
    }

    public Cercle(int x, int y, Color c) {
        super(x, y, c);
    }

    public void setAxeX(int a) {
        this.AxeX = a;
        this.AxeY = a;
        this.r= a;
    }

    public void setAxeY(int rayon) {
        super.setAxeX(rayon);
        super.setAxeY(rayon);
    }


    public void setBoundingBox ( int hauteurBB, int largeurBB){
        this.AxeY = hauteurBB;
        this.AxeX = hauteurBB;
        this.r = hauteurBB ;
    }
    public void draw(Graphics g) {
        g.setColor(this.c);
        g.fillOval(this.origine.getX(), this.origine.getY(), this.r, this.r);
    }



    public String toString() {
        return "le rayon du cercle : " + this.r;
    }

}
