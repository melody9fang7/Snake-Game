
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener, KeyListener {

    //dimensions of display
	int dim = 680;
	
	//score
	int score = 0;

	//colors
	Color dg = new Color(0,102,0);
	Color lg = new Color(65,199,32);
	
	//snake
	int x = 320;
	int y = 350;
	int length = 50;
	int width = 25;
	int v_x = 1;
	int v_y = 1;

	public void paint(Graphics g) {

		super.paintComponent(g);

        //background
		g.setColor(lg);
		g.fillRect(0, 0, dim, dim);

        //scoring
		g.setColor(dg);
		g.setFont(new Font("Times New Roman", 0, 40));
		g.drawString(score + "", 0, 30);
		
		//snake
		g.setColor(dg);
		g.fillRect(x, y, length, width);

	}


// end of update, do not delete

	public void actionPerformed(ActionEvent arg0) {
// TODO Auto-generated method stub

		repaint();

	}

	public static void main(String[] arg) {
		Driver d = new Driver();
	}

	public Driver() {

		JFrame f = new JFrame();
		f.setTitle("Pong");
		f.setSize(dim, dim);
		f.setBackground(Color.WHITE);
		f.setResizable(false);

		f.addKeyListener(this);

		f.add(this);
		t = new Timer(17, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	Timer t;

	@Override
	public void keyPressed(KeyEvent e) {

        //moving paddles
		if (e.getKeyCode() == 39) { //if the a certain key is pressed
			x += v_x;
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
     // TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
     // TODO Auto-generated method stub

	}
}