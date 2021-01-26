import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;


public class Obstaculo{

	Juego game;

	Area cabeza, cuerpo, obs;

	int anchoObstaculo = 70;
	int altoObstaculo = 70;

	static int x_inicial = 1300;
	static int y_inicial = 270;

	static int x_auxiliar = -4;


	public Obstaculo(Juego game){
		this.game = game;
	}

	public void mover(){
		if(x_inicial <=-100){
			game.puntos++;
			x_inicial = 1300;
			if(game.puntos%5==0){
				x_auxiliar += -2;
				game.nivel++;
			}
		}else{
			if(colision()){
				if(game.vidas == 1){
					game.finJuego();
				}else{
					game.pierdeVida();
				}
			}else{
				x_inicial+= x_auxiliar;
			}
			
		}
	}

	public void paint(Graphics2D g){
		ImageIcon enemy = new ImageIcon(getClass().getResource("Media/boss.png")); // NR
		g.drawImage(enemy.getImage(), x_inicial, y_inicial, anchoObstaculo, altoObstaculo, null);

	}

	public Area getBounds(){

		Ellipse2D forma1 = new Ellipse2D.Double(x_inicial, y_inicial, 40, 40);
		Rectangle forma2 = new Rectangle(x_inicial+12, y_inicial+16, 50, 53);

		cabeza = new Area(forma1);
		cuerpo = new Area(forma2);

		obs = cabeza;
		obs.add(cabeza);
		obs.add(cuerpo);

		return obs;
	}

	public boolean colision(){

		Area areaA = new Area(game.avion.getBounds());
		areaA.intersect(getBounds());

		return !areaA.isEmpty();

	}

}