import java.awt.* ;

public class Rectangle extends Figure {
    protected int Longueur;
    protected int Largeur;


    public Rectangle(Point origine) {
        super(origine);
    }

    public Rectangle(int px, int py, Color c) {
        super(px, py, c);
    }

    public Rectangle(int L, int l) {
        super(new Point());
        this.Longueur = L;
        this.Largeur = l;
    }


    public int getLargeur() {
        return Largeur;
    }

    public int getLongueur() {
        return this.Longueur;
    }

    public double getSurface() {
        return this.Longueur * this.Largeur;
    }

    public double getPerimetre() {
        return 2*(this.Largeur + this.Longueur);
    }


    public void setLongueur(int L) {
        this.Longueur = L;
    }

    public void setLargeur(int l) {
        this.Largeur = l;
    }

    ////////Interface d'ecoute
    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.Longueur = hauteurBB;
        this.Largeur = largeurBB;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.c);
        g.fillRect(origine.getX(), origine.getY(), Longueur, Largeur);
    }


    ///////////////////////////////Afficher le rectangle
    public String ToString ()
    {
        String s = "+";
        for (int i=0;i<Longueur;i++) s=s+"--";
        s += "+\n";

        for (int j=0; j <Largeur;j++)
        {
            s+="|";
            for (int i=0;i<Longueur;i++) s=s+"  ";
            s+="|\n";
        }

        s+="+";
        for (int i=0;i<Longueur;i++) s=s+"--";
        s += "+\n";
        return s;
    }


}

