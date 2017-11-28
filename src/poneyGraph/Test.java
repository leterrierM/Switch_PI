package poneyGraph;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JPanel top = new JPanel(new GridLayout(1,1));
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		top.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.blue));
		left.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.RED));
		right.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.green));
		top.add(left);
		top.add(right);
		JFrame frame = new JFrame();
		frame.add(top);
		frame.setSize(400,400);
		frame.setVisible(true);
	}

}
