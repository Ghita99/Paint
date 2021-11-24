import javax.swing.*;
import java.awt.* ;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Dessin extends JPanel implements MouseMotionListener, MouseListener {
    // l'interface MouseMotionListener sert à gerer les mouvements  et  MouseListener pour gerer les boutons de la souris
    private Color c;
    private ArrayList<Figure> liste ;
    private String nomFigure;
    private int x, y;

    // on commence avec le constructeur par defaut
    public Dessin() {
        super();
        setBackground(Color.white);
        //on initialise la couleur avec le rouge par exemple
        this.c =Color.red;

        // on initialise la figure avec le dessin de l'ellipse par exemple
        this.nomFigure = "Ellipse";
        this.liste = new ArrayList<Figure>();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Figure f : liste)
        {
            f.draw(g);
        }
    }
    /////// reinitialliser l'ecran et la vider
    public void reset () {
        System.out.println(this.liste);
        this.liste.clear();
        paintComponent(this.getGraphics());
    }
    ///////// pour enregistrer la figure
    public void saveDrawing(String nameFile)
    {
        try{
            FileOutputStream fos = new FileOutputStream(nameFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(liste.size());
            for (Figure f : liste)
            {
                oos.writeObject(f);
            }
            oos.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void recallDrawing(String nameFile)
    {
        try{
            FileInputStream fis = new FileInputStream(nameFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            reset();

            int numberOfFigure=ois.readInt();
            for (int i=0; i<numberOfFigure; i++)
            {Figure f=(Figure) ois.readObject();
                liste.add(f);
            }
            ois.close();
            paintComponent(this.getGraphics());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void setColor (Color color){

        this.c=color;
    }



    public ArrayList<Figure> getliste (){

        return this.liste;
    }

    public void setnomFigure(String nom){
        this.nomFigure = nom;
    }

    public void mouseReleased(MouseEvent e) {
        this.liste.get(liste.size()-1).setBoundingBox((e.getX()-this.x),(e.getY()-this.y));
        repaint();
    }


    public void mouseMoved(MouseEvent e) {
        //System.out.println("moved");
    }

    public void mouseDragged(MouseEvent e) {
        this.liste.get(liste.size()-1).setBoundingBox((e.getX()-this.x),(e.getY()-this.y));
        repaint();
    }


    //System.out.println("clicked");
    public void mouseClicked(MouseEvent e) {
    }

    //System.out.println("Entered");
    public void mouseEntered(MouseEvent e) {
    }

    //System.out.println("Exited");
    public void mouseExited(MouseEvent e) {
    }


    public void mousePressed(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
        System.out.println("le dessin de "+" " +nomFigure+" de cordonnées d'origine "+e.getX()+" , "+e.getY());
        switch (nomFigure) {
            case "Rectangle":
                liste.add(new Rectangle(this.x, this.y, this.c));
                break;
            case "Ellipse":
                liste.add(new Ellipse(this.x, this.y, this.c));
                break;
            case "Cercle":
                liste.add(new Cercle(this.x, this.y, this.c));
                break;
            case "Carré":
                liste.add(new Carré(this.x, this.y, this.c));
                break;
            default:
                break;
        }
    }




}


