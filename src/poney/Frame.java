package poney;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;;

public class Frame extends JFrame implements KeyListener, MouseListener{

	JScrollPane scrollPane;
	JPanel panel;
	
	ImageLoader il;
	ArrayList<VideoLabel> videoLabelList;
	
	int currentLabel = 0;
	int maxLabel = 29;

	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1024, 720));
		
		panel = new JPanel();
//		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//		panel.setLayout(new FlowLayout(0));
//		panel.setLayout(new GroupLayout(panel));
		FlowLayout panelLayout = new FlowLayout() {
            public Dimension preferredLayoutSize(Container target) {
                Dimension sd=super.preferredLayoutSize(target);

                sd.width=Math.min(sd.width, 720);

                return sd;
            }
        };
		panel.setLayout(panelLayout);
		
		il = new ImageLoader();
		videoLabelList = new ArrayList<VideoLabel>(maxLabel);
		
		
		scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(600, 600));
		
		for(int i =0; i < maxLabel; i++){
			videoLabelList.add(new VideoLabel(il.getImageIndex((int)(Math.random()*3))));
			panel.add(videoLabelList.get(i));
		}

		panel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));
		
		videoLabelList.get(currentLabel).setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.RED));
		
		add(scrollPane, BorderLayout.NORTH);
		
		addKeyListener(this);
		setFocusable(true);
		requestFocus();
		setVisible(true);
		pack();
	}

	public void keyPressed(KeyEvent e) {
		System.out.println(e);
		switch (e.getKeyCode()) {
		case KeyEvent.VK_SPACE:
			changeBorders((currentLabel + 1) % maxLabel);
	    	break;
		case KeyEvent.VK_UP:
			changeBorders((currentLabel + il.getLength(this.getWidth(), il.getHeight(), 5)) % maxLabel);
	    	break;
		case KeyEvent.VK_DOWN:
			changeBorders((currentLabel - il.getLength(this.getWidth(), il.getHeight(), 5)) % maxLabel);
	    	break;
		case KeyEvent.VK_RIGHT:
			changeBorders((currentLabel + il.getLength(this.getHeight(), il.getWidth(), 5)) % maxLabel);
	    	break;
		case KeyEvent.VK_LEFT:
			changeBorders((currentLabel - il.getLength(this.getHeight(), il.getWidth(), 5)) % maxLabel);
	    	break;
	    	
		default:
			break;
		}  
	}

	private void changeBorders(int newCurrent) {
		videoLabelList.get(currentLabel).setBorder(null);
		System.out.println("Old:"+currentLabel+" / New:"+newCurrent);
    	currentLabel = newCurrent;
    	videoLabelList.get(currentLabel).setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.RED));		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		JLabel a = (JLabel) e.getSource();
		
		videoLabelList.get(currentLabel).setBorder(null);
    	currentLabel = videoLabelList.indexOf(a);
    	videoLabelList.get(currentLabel).setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.RED));
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * for(int i = 0; i < maxLabel; i++){
			switch ((int)(Math.random() * 3)) {
			case 0:
				panelList.add(new JLabel("", image1, JLabel.CENTER));
				break;
			case 1:
				panelList.add(new JLabel("", image2, JLabel.CENTER));
				break;
			case 2:
				panelList.add(new JLabel("", image3, JLabel.CENTER));
				break;
	
			default:
				break;
			}
			panel.add(panelList.get(i));
			panelList.get(i).addMouseListener(this);
		}
	 */
	
}

