import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Area;

public class Juego extends JPanel{

	Avion avion = new Avion(this);
	Obstaculo obstaculo = new Obstaculo(this);
	Fondo fondo = new Fondo(this);

	public static boolean juegoFinalizado = false;
	public static boolean pierdeVida = false;
	public static int vidas = 3;
	public static int puntos = 0;
	public static int nivel = 1;

	public Juego(){

		addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e){

			}

			public void keyPressed(KeyEvent e){
				if(e.getKeyCode()== KeyEvent.VK_SPACE){
					avion.keyPressed(e);
				}
			}

			public void keyReleased(KeyEvent e){

			}

		});
		setFocusable(true);
	}

	public void mover(){
		obstaculo.mover();
		avion.mover();
		fondo.mover();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		dibujar(g2);
		dibujarPuntaje(g2);

	}

	public void dibujar(Graphics2D g){
		fondo.paint(g);
		avion.paint(g);
		obstaculo.paint(g);
		mover();

	}

	public void dibujarPuntaje(Graphics2D g){
		Graphics2D g1= g, g2=g;
		Font score = new Font("Arial", Font.BOLD, 30);
		g.setFont(score);
		g.setColor(Color.red);
		g1.drawString("Nivel: "+ nivel, 570, 30);
		g1.drawString("Puntaje: " +puntos,1100,30);
		g1.drawString("Vidas: "+ vidas,20,30);

		if(juegoFinalizado){
			g2.setColor(Color.yellow);
			g2.drawString("¡¡¡ Haz Perdido !!!", ((float)getBounds().getCenterX()/2)+170,70);
		}
	}

	public void finJuego(){
		juegoFinalizado = true;

	}

	public void pierdeVida(){
		pierdeVida= true;
	}


}