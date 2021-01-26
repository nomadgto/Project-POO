import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Main{

	public static int reiniciaJuego = -1;

	public static void main(String[] args){

		new Menu();

		//JOptionPane.showMessageDialog(null,"¿Estas listo?");

		//JFrame ventana = new JFrame("Game");
		//Juego game = new Juego();
		//ventana.add(game);
		//ventana.add(m);
		//ventana.setSize(1300,400);
		//ventana.setVisible(true);
		//ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ventana.setLocationRelativeTo(null);// centrar ventana

		//while(true){
//
		//	if(game.juegoFinalizado){
		//		reiniciaJuego = JOptionPane.showConfirmDialog(null, "Haz Perdido, ¿Quieres volver a jugar?", "Haz perdido", JOptionPane.YES_NO_OPTION);
		//		if(reiniciaJuego == 0){
		//			reiniciaValores();
		//		}else if(reiniciaJuego == 1){
		//			System.exit(0);
		//		}
		//	}else{
		//		game.repaint();
		//		try{
		//			Thread.sleep(10);
		//		}catch (InterruptedException e){
//
		//		}
		//		if(Juego.pierdeVida == true){
		//			JOptionPane.showMessageDialog(null, "Cuidado!!");
		//			Juego.pierdeVida= false;
		//			Juego.vidas--;
		//			Avion.y_inicial = 270;
		//			Avion.saltando = false;
		//			Obstaculo.x_inicial = 1300;
		//		}
		//	}
		//}
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