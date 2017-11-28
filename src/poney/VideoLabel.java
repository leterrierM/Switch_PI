package poney;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VideoLabel extends JLabel{

    public VideoLabel(ImageIcon image) {
    	super(image);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        System.out.println(image);
//        g.drawImage(image, 0, 0, this);        
    }

}
