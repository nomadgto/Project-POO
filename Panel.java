import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel{

    Image image = new ImageIcon("Media/Fondo.png").getImage();

    @Override
    public void paint(Graphics g){
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}
