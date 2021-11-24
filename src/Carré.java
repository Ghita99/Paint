import java.awt.* ;

 public class Carré extends Rectangle {
     protected int coté;


     /////les constructeurs
     public Carré(int x, int y, Color color) {

         super(x, y, color);
     }

     public Carré(int coté) {
         super(coté, coté);
     }



     public void setLongueur(int coté) {
         super.setLongueur(coté);
         super.setLargeur(coté);
     }

     public void setLargeur(int coté) {
         super.setLongueur(coté);
         super.setLargeur(coté);
     }
     public void setBoundingBox(int longueurBB, int largeurBB) {
         this.coté = longueurBB;
         this.coté = largeurBB;
     }

     public void draw(Graphics g) {
         g.setColor(this.c);
         g.fillRect(this.origine.getX(), this.origine.getY(), this.coté, this.coté);

     }

     public String toString() {
         return "un carré de coté égal à : " + this.coté;
     }

 }

