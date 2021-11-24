import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Fenêtre extends JFrame  implements ActionListener {
    private Dessin Dessin = new Dessin();


    Fenêtre(String Title) {
        super(Title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(0,200);
        setSize(500,250);


        Container contentPane = getContentPane() ;
        // Bare de Menu "Fichiers"//
        JMenuBar m= new JMenuBar();
        //le contenu du menu
        JMenu menu1= new JMenu("Fichier");
        JMenuItem New = new JMenuItem("Nouveau") ;
        New.addActionListener(this);
        menu1.add(New);
        JMenuItem Load = new JMenuItem("Télécharger") ;
        Load.addActionListener(this );
        menu1.add(Load);
        JMenuItem Save = new JMenuItem("Enregistrer") ;
        Save.addActionListener(this );
        menu1.add(Save);

        ////////Creation du separateur
        menu1.addSeparator();

        //// quitter la fenetre
        JMenuItem Quit = new JMenuItem("Quitter") ;
        Quit.addActionListener(this );
        menu1.add(Quit);
        m.add(menu1);

        ///// les raccourcis
        Quit.setAccelerator(KeyStroke.getKeyStroke('Q',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),
                false));
        New.setAccelerator(KeyStroke.getKeyStroke('N',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),
                false));
        Save.setAccelerator(KeyStroke.getKeyStroke('S',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),
                false));


        //Creation d'un autre menu "A propos " qui contient l'auteur
        JMenu menu2 = new JMenu("A propos");
        JMenuItem Authors = new JMenuItem("Auteur") ;
        Authors.addActionListener(this);
        menu2.add(Authors);
        m.add(menu2);

        //Creation d'un 3eme menu Importer/Eporter qui sert à importer un fichier ou l'exporter
        JMenu menu3 = new JMenu("Importer/Exporter");
        JMenuItem Export = new JMenuItem("exporter") ;
        Export.addActionListener(this);
        menu3.add(Export);
        m.add(menu3);


        setJMenuBar(m);
        setVisible( true );
        contentPane .add( new JTextArea("éditeur de texte"),"Center");

        ////// panneau des couleurs et sa taille
        JPanel pan1= new JPanel();
        pan1.setLayout( new GridLayout(2,8));
        JButton monbouton1 = new JButton("Cyan");
        monbouton1.addActionListener(  this );
        monbouton1.setBackground(Color.cyan);
        pan1.add(monbouton1);
        JButton monbouton3 = new JButton("Green");
        monbouton3.addActionListener(  this );
        monbouton3.setBackground(Color.green);
        pan1.add(monbouton3);
        JButton monbouton = new JButton("Black");
        monbouton.addActionListener(this );
        monbouton.setBackground(Color.black);
        pan1.add(monbouton);
        JButton monbouton4 = new JButton("Blue");
        monbouton4.addActionListener(  this );
        monbouton4.setBackground(Color.blue);
        pan1.add(monbouton4);
        JButton monbouton2 = new JButton("Red");
        monbouton2.addActionListener(this );
        monbouton2.setBackground(Color.red);
        pan1.add(monbouton2);
        JButton monbouton5 = new JButton("Ellipse");
        monbouton5.addActionListener( this );
        pan1.add(monbouton5);
        JButton monbouton10 = new JButton("Carré");
        monbouton10.addActionListener( this );
        pan1.add(monbouton10);
        JButton monbouton6 = new JButton("Yellow");
        monbouton6.addActionListener( this );
        monbouton6.setBackground(Color.yellow);
        pan1.add(monbouton6);
        JButton monbouton9 = new JButton("Orange");
        monbouton9.addActionListener( this );
        monbouton9.setBackground(Color.orange);
        pan1.add(monbouton9);
        JButton monbouton7 = new JButton("Pink");
        monbouton7.addActionListener( this );
        monbouton7.setBackground(Color.pink);
        pan1.add(monbouton7);
        JButton monbouton15 = new JButton("Green");
        monbouton15.addActionListener(  this );
        monbouton15.setBackground(Color.green);
        pan1.add(monbouton3);
        JButton monbouton8 = new JButton("Magenta");
        monbouton8.addActionListener( this );
        monbouton8.setBackground(Color.magenta);
        pan1.add(monbouton8);
        JButton monbouton11 = new JButton("Rectangle");
        monbouton11.addActionListener( this );
        pan1.add(monbouton11);
        JButton monbouton12 = new JButton("Cercle");
        monbouton12.addActionListener( this );
        pan1.add(monbouton12);




        contentPane.add(pan1,"South");
        contentPane.add(Dessin);


    }

    public void actionPerformed(ActionEvent e) {
        /// pour la selection de la couleur et le forme demandé par le button
        String cmd = e.getActionCommand();
        System.out.println("You pressed " + cmd);
        switch (cmd) {
            case "Black":
                Dessin.setColor(Color.black);
                break;
            case "Red":
                Dessin.setColor(Color.red);
                break;
            case "Green":
                Dessin.setColor(Color.green);
                break;
            case "Blue":
                Dessin.setColor(Color.blue);
                break;
            case "Yellow":
                Dessin.setColor(Color.yellow);
                break;
            case "Pink":
                Dessin.setColor(Color.pink);
                break;
            case "Magenta":
                Dessin.setColor(Color.magenta);
                break;
            case "Orange":
                Dessin.setColor(Color.orange);
                break;
            case "Ellipse":
                Dessin.setnomFigure("Ellipse");
                break;
            case "Cercle":
                Dessin.setnomFigure("Cercle");
                break;
            case "Carré":
                Dessin.setnomFigure("Carré");
                break;
            case "Rectangle":
                Dessin.setnomFigure("Rectangle");
                break;
            case "Export to text":
                //drawing.WriteText();
                break;
            case "Quitter":
                System.exit(0);
                break;
            case "Nouveau":
                Dessin.reset();
                break;
            case "Enregistrer" : 	JFileChooser fds=new JFileChooser();
                int c=fds.showSaveDialog(this);
                if (c==JFileChooser.CANCEL_OPTION)
                {System.out.println("Cancelled");
                    break;}
                String nameFile=fds.getSelectedFile().getAbsolutePath();
                Dessin.saveDrawing(nameFile);
                break;
            case "Télécharger" : 	JFileChooser fdo=new JFileChooser();
                int x=fdo.showOpenDialog(this);
                if (x==JFileChooser.CANCEL_OPTION)
                {System.out.println("Cancelled");
                    break;}
                String nameFileOpen=fdo.getSelectedFile().getAbsolutePath();
                Dessin.recallDrawing(nameFileOpen);
                break;

            case "Auteur":
                JOptionPane.showMessageDialog(null, "L'auteur est OUHSSAINE Ghita", "à propos", JOptionPane.PLAIN_MESSAGE);
                break;
            default:
                break;
        }
    }
}
