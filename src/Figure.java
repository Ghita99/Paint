import java.io.Serializable;
import java.awt.* ; //// pour importer Color

public abstract class Figure implements Serializable  {

    protected Point origine ; //peut être manipulé dans toutes les classes
    protected Color c;

    /////////////////Les constructeurs:
    public Figure(Point point) {
        this.origine = point;
    }

    public Figure (Point o, Color color) {
        this.origine = o ;
        this.c = color;
    }

    public Figure(int x, int y, Color color) {
        this.origine = new Point(x, y);
        this.c = color;
    }



    /////////////les deux  methodes abstractes
    public abstract void setBoundingBox(int  hauteurBB,  int  largeurBB);
    public abstract void draw(Graphics g);

    //retourner le perimetre de la figure
    public abstract double getPerimetre();

    //retourner la surface de la figure
    public abstract double getSurface();

    public String toString() {
        return "Les cordonnées sont ("+origine.getX()+","+origine.getY()+")";
    }
}