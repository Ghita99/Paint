import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Fenêtre extends JFrame  implements ActionListener {
    private Dessin Dessin = new Dessin();


    Fenêtre(String Titre) {
        super(Titre);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(0,200);
        setSize(500,250);


        Container contentPane = getContentPane() ;
        ////// Barre de Menu "Fichiers"//
        JMenuBar m= new JMenuBar();
        /////le contenu du menu
        JMenu menu1= new JMenu("Fichier");
        JMenuItem Nouveau = new JMenuItem("Nouveau") ;
        Nouveau.addActionListener(this);
        menu1.add(Nouveau);
        JMenuItem Ouvrir = new JMenuItem("Ouvrir") ;
        Ouvrir.addActionListener(this );
        menu1.add(Ouvrir);
        JMenuItem Enregistrer = new JMenuItem("Enregistrer") ;
        Enregistrer.addActionListener(this );
        menu1.add(Enregistrer);

        ////////Creation du separateur
        menu1.addSeparator();

        //////// quitter la fenetre
        JMenuItem Quitter = new JMenuItem("Quitter") ;
        Quitter.addActionListener(this );
        menu1.add(Quitter);
        m.add(menu1);

        ///////// les raccourcis
        Quitter.setAccelerator(KeyStroke.getKeyStroke('Q',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),
                false));
        Nouveau.setAccelerator(KeyStroke.getKeyStroke('N',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),
                false));
        Enregistrer.setAccelerator(KeyStroke.getKeyStroke('S',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),
                false));


        //Creation d'un autre menu "A propos " qui contient l'auteur
        JMenu menu2 = new JMenu("A propos");
        JMenuItem Authors = new JMenuItem("Auteur") ;
        Authors.addActionListener(this);
        menu2.add(Authors);
        m.add(menu2);
        setJMenuBar(m);
        setVisible( true );


        ///////// panneau des couleurs et sa taille
        JPanel pan1= new JPanel();
        pan1.setLayout( new GridLayout(2,8));
        JButton monbouton = new JButton("Gris");
        monbouton.addActionListener(  this );
        monbouton.setBackground(Color.gray);
        pan1.add(monbouton);
        JButton monbouton1 = new JButton("Vert");
        monbouton1.addActionListener(  this );
        monbouton1.setBackground(Color.green);
        pan1.add(monbouton1);
        JButton monbouton2 = new JButton("Gris clair");
        monbouton2.addActionListener( this );
        monbouton2.setBackground(Color.lightGray);
        pan1.add(monbouton2);
        JButton monbouton3 = new JButton("Noir");
        monbouton3.addActionListener(this );
        monbouton3.setBackground(Color.black);
        pan1.add(monbouton3);
        JButton monbouton4 = new JButton("Bleu");
        monbouton4.addActionListener(  this );
        monbouton4.setBackground(Color.blue);
        pan1.add(monbouton4);
        JButton monbouton5 = new JButton("Rouge");
        monbouton5.addActionListener(this );
        monbouton5.setBackground(Color.red);
        pan1.add(monbouton5);
        JButton monbouton6 = new JButton("Ellipse");
        monbouton6.addActionListener( this );
        pan1.add(monbouton6);
        JButton monbouton7 = new JButton("Carré");
        monbouton7.addActionListener( this );
        pan1.add(monbouton7);
        JButton monbouton8 = new JButton("Jaune");
        monbouton8.addActionListener( this );
        monbouton8.setBackground(Color.yellow);
        pan1.add(monbouton8);
        JButton monbouton9 = new JButton("Orange");
        monbouton9.addActionListener( this );
        monbouton9.setBackground(Color.orange);
        pan1.add(monbouton9);
        JButton monbouton10 = new JButton("Rose");
        monbouton10.addActionListener( this );
        monbouton10.setBackground(Color.pink);
        pan1.add(monbouton10);
        JButton monbouton11 = new JButton("Bleu ciel");
        monbouton11.addActionListener(  this );
        monbouton11.setBackground(Color.cyan);
        pan1.add(monbouton11);
        JButton monbouton12= new JButton("Mauve");
        monbouton12.addActionListener( this );
        monbouton12.setBackground(Color.magenta);
        pan1.add(monbouton12);
        JButton monbouton13 = new JButton("Gris foncé");
        monbouton13.addActionListener( this );
        monbouton13.setBackground(Color.darkGray);
        pan1.add(monbouton13);
        JButton monbouton14 = new JButton("Rectangle");
        monbouton14.addActionListener( this );
        pan1.add(monbouton14);
        JButton monbouton15 = new JButton("Cercle");
        monbouton15.addActionListener( this );
        pan1.add(monbouton15);


        contentPane.add(pan1,"South");
        contentPane.add(Dessin);


    }

    public void actionPerformed(ActionEvent e) {
        /// pour la selection de la couleur et le forme demandé par le button
        String cmd = e.getActionCommand();
        System.out.println("Tu as cliqué sur " + cmd);
        switch (cmd) {
            case "Noir":
                Dessin.setColor(Color.black);
                break;
            case "Gris":
                Dessin.setColor(Color.GRAY);
                break;
            case "Bleu ciel":
                Dessin.setColor(Color.cyan);
                break;
            case "Rouge":
                Dessin.setColor(Color.red);
                break;
            case "Vert":
                Dessin.setColor(Color.green);
                break;
            case "Bleu":
                Dessin.setColor(Color.blue);
                break;
            case "Jaune":
                Dessin.setColor(Color.yellow);
                break;
            case "Gris foncé":
                Dessin.setColor(Color.darkGray);
                break;
            case "Gris clair":
                Dessin.setColor(Color.lightGray);
                break;
            case "Rose":
                Dessin.setColor(Color.pink);
                break;
            case "Mauve":
                Dessin.setColor(Color.magenta);
                break;
            case "Orange":
                Dessin.setColor(Color.orange);
                break;
            case "Cercle":
                Dessin.setnomFigure("Cercle");
                break;
            case "Ellipse":
                Dessin.setnomFigure("Ellipse");
                break;
            case "Carré":
                Dessin.setnomFigure("Carré");
                break;
            case "Rectangle":
                Dessin.setnomFigure("Rectangle");
                break;
            case "Nouveau":
                Dessin.reset();
                break;
            case "Quitter":
                System.exit(0);
                break;
            case "Enregistrer" : 	JFileChooser fds=new JFileChooser();
                int c=fds.showSaveDialog(this);
                if (c==JFileChooser.CANCEL_OPTION)
                {System.out.println("Annulé");
                    break;}
                String nameFile=fds.getSelectedFile().getAbsolutePath();
                Dessin.saveDrawing(nameFile);
                break;
            case "Ouvrir" : 	JFileChooser fdo=new JFileChooser();
                int x=fdo.showOpenDialog(this);
                if (x==JFileChooser.CANCEL_OPTION)
                {System.out.println("Annulé");
                    break;}
                String nameFileOpen=fdo.getSelectedFile().getAbsolutePath();
                Dessin.recallDrawing(nameFileOpen);
                break;
            case "Auteur":
                JOptionPane.showMessageDialog(null, "L'auteur est OUHSSAINE Ghita", "A propos", JOptionPane.PLAIN_MESSAGE);
                break;
            default:
                break;
        }
    }
}
