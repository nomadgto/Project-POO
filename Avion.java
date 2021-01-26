import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;


public class Avion{

	Juego game;

	static boolean saltando = false;
	boolean sube = false;
	boolean baja = false;

	Area llantaDelantera, llantaTrasera, cuerpo, avion;

	int anchoAvion = 112;
	int altoAvion = 78;

	static int x_inicial = 50;
	static int y_inicial = 270;

	int x_auxiliar = 0;
	int y_auxiliar = 0;

	public Avion(Juego game){
		this.game = game;
	}

	public void mover(){
		if(x_inicial + x_auxiliar > 0 && x_inicial + x_auxiliar < game.getWidth()-anchoAvion){
			x_inicial += x_auxiliar;
		}
		if(saltando){
			if(y_inicial == 270){
				sube = true;
				y_auxiliar= -2;
				baja = false;
			}
			if(y_inicial == 150){
				baja= true;
				y_auxiliar = 2;
				sube= false;
			}
			if(sube){
				y_inicial += y_auxiliar;
			}
			if(baja){
				y_inicial += y_auxiliar;
				if(y_inicial == 270){
					saltando = false;
				}
			}
		}
	}

	public void paint(Graphics2D g){
		ImageIcon avion = new ImageIcon(getClass().getResource("Media/player.png")); // Nueva ruta Media/
		g.drawImage(avion.getImage(), x_inicial, y_inicial, anchoAvion, altoAvion, null);
	}

	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()== KeyEvent.VK_SPACE){
			saltando = true;
		}
	}

	public Area getBounds(){
		Rectangle forma1 = new Rectangle(x_inicial, y_inicial, 95, 62);
		cuerpo = new Area(forma1);

		Ellipse2D forma2 = new Ellipse2D.Double(x_inicial, y_inicial+28, 48, 48);
		llantaTrasera = new Area(forma2);

		Ellipse2D forma3 = new Ellipse2D.Double(x_inicial+73, y_inicial+39, 48, 48);
		llantaDelantera = new Area(forma3);

		avion = cuerpo;
		avion.add(cuerpo);
		avion.add(llantaTrasera);
		avion.add(llantaDelantera);

		return avion;

	}

}