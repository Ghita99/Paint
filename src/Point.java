import java.io.Serializable;

public class Point implements Serializable  {
    int X ;
    int Y ;

    //////////les 2 constructeurs:

    public Point (int a, int b){
        this.X= a;
        this.Y= b;
    }
    public Point (){
        this.X=0;
        this.Y=0;
    }

    /////////// les getters and setters:
    public void setX(int a){this.X=a;}
    public void setY(int b){this.Y=b;}

    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }

    ////////// La methode ToString
    @Override
    public String toString() {
        String result = getX() + "," + getY() ;
        return result;
    }
}
