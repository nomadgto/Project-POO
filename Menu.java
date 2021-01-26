import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;

public class Menu extends JLabel implements ActionListener{

    public static int reiniciaJuego = -1;

    //public boolean visible = false;

    JFrame ventana = new JFrame("Game");
    Panel menu = new Panel();
    Panel scores = new Panel();

    Image image = new ImageIcon("Media/Fondo.png").getImage();
    
    JLabel l = new JLabel("NEW FLAPPY BIRD");
    JLabel t = new JLabel("SCORES");
    JButton b1 = new JButton("New Game");
    JButton b2 = new JButton("Get Scores");
    JButton b3 = new JButton("Exit");

    JButton back = new JButton("BACK");

    CardLayout cl = new CardLayout();
    Container cont = new Container();

    JPanel controler = new JPanel();

    Juego game = new Juego();

    JLabel score1 = new JLabel();
    JLabel score2 = new JLabel();
    JLabel score3 = new JLabel();
    JLabel score4 = new JLabel();
    JLabel score5 = new JLabel();
    
    public Menu(){

        menu.setLayout(null);
        menu.add(l);
        menu.add(b1);//, //BorderLayout.NORTH);
        menu.add(b2);//, //BorderLayout.CENTER);
        menu.add(b3);//, //BorderLayout.SOUTH);
        l.setFont(new Font("Arial", Font.PLAIN, 30));
        l.setBounds(550, 10,300,100);
        b1.setBounds(640, 100, 100, 40);
        b2.setBounds(640, 200, 100, 40);
        b3.setBounds(640, 300, 100, 40);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        back.addActionListener(this);

        scores.setLayout(null);
        scores.add(back);
        back.setBounds(640, 300, 100, 40);
        scores.add(score1);
        scores.add(score2);
        scores.add(score3);
        scores.add(score4);
        scores.add(score5);

        score1.setBounds(500, 60,1000,100);
        score2.setBounds(500, 90,1000,100);
        score3.setBounds(500, 120,1000,100);
        score4.setBounds(500, 150,1000,100);
        score5.setBounds(500, 180,1000,100);

        score1.setFont(new Font("Arial", Font.PLAIN, 20));
        score2.setFont(new Font("Arial", Font.PLAIN, 20));
        score3.setFont(new Font("Arial", Font.PLAIN, 20));
        score4.setFont(new Font("Arial", Font.PLAIN, 20));
        score5.setFont(new Font("Arial", Font.PLAIN, 20));

        scores.add(t);
        t.setBounds(630, 10,300,100);
        t.setFont(new Font("Arial", Font.PLAIN, 30));

        cont.setLayout(cl);
        cont.add(menu, "1");
        cont.add(scores, "2");
        cont.add(game, "3");

        cl.show(cont, "1");
        Ventana();
        //setVisible(true);
    }

    public void Ventana(){
        ventana.add(cont);
		ventana.setSize(1300,400);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);// centrar ventana
    }

    public void newGame() {
        cl.show(cont, "3");
        //  No se ejecuta el juego ¡¡¡

        JOptionPane.showMessageDialog(null,"¿Estas listo?");
        //ventana.setSize(1300,400);
		//ventana.setVisible(true);
		//ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while(true){

			if(game.juegoFinalizado){
				reiniciaJuego = JOptionPane.showConfirmDialog(null, "Haz Perdido, ¿Quieres volver a jugar?", "Haz perdido", JOptionPane.YES_NO_OPTION);
				if(reiniciaJuego == 0){
					reiniciaValores();
				}else if(reiniciaJuego == 1){
					System.exit(0);
				}
			}else{
				game.repaint();
				try{
					Thread.sleep(10);
				}catch (InterruptedException e){

				}
				if(Juego.pierdeVida == true){
					JOptionPane.showMessageDialog(null, "Cuidado!!");
					Juego.pierdeVida= false;
					Juego.vidas--;
					Avion.y_inicial = 270;
					Avion.saltando = false;
					Obstaculo.x_inicial = 1300;
				}
			}
		}
    }

    public void getScores(){
        cl.show(cont, "2");
        String date = new String();
        Date d = new Date();
        date = d.toString();
        score1.setText("#1      "+date);
        score2.setText("#2      "+date);
        score3.setText("#3      "+date);
        score4.setText("#4      "+date);
        score5.setText("#5      "+date);
    }

    public void exit(){
        System.exit(0);
    }

    public void back(){
        cl.show(cont, "1");
    }

    // Fondo del menu
    @Override
    public void paint(Graphics g){
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            //this.visible = true;
            newGame();
        }
        if(e.getSource()==b2){
            getScores();
        }
        if(e.getSource()==b3){
            exit();
        }
        if(e.getSource()==back){
            back();
        }

    }

    public static void reiniciaValores(){
		Juego.juegoFinalizado = false;
		Obstaculo.x_auxiliar = -4;
		Juego.puntos = 0;
		Juego.nivel = 1;
		Juego.vidas = 3;
		reiniciaJuego = -1;
		Obstaculo.x_inicial = 1300;
	}
}
