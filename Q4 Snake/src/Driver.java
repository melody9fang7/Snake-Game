
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener, KeyListener {

	// dimensions of display
	int dim = 680;

	// other
	boolean die = false;

	// score
	int curScore = 0;
	int bestScore = 0;

	// colors
	Color dg = new Color(0, 102, 0);
	Color lg = new Color(65, 199, 32);

	// snake
	int x = 320;
	int y = 350;
	int length = 50;
	int width = 25;
	int v_x = 0;
	int v_y = 0;
	boolean active = true;

	// apple
	Apple apple = new Apple(200, 200, "apple.png");

	public void paint(Graphics g) {

		super.paintComponent(g);

		// background
		g.setColor(lg);
		g.fillRect(0, 0, dim, dim);

		// scoring
		g.setColor(dg);
		g.setFont(new Font("Times New Roman", 0, 20));
		g.drawString("current score   " + curScore, 185, 60);
		g.drawString("best score   " + bestScore, 405, 60);

		// snake
		if (active) {
			g.setColor(dg);
			g.fillRect(x, y, length, width);
		}

		// apple
		if (apple.active) {
			apple.paint(g);
		}

		if (die) {
			g.setFont(new Font("Times New Roman", 0, 75));
			g.drawString("oops, you died!", 95, 240);
			g.drawString("click space to restart", 17, 400);
		}
	}

	public void move() {

		x += v_x;
		y += v_y;

		if (x >= 680 - length - 20 || x <= 0 || y >= 630 || y <= 0) {
			v_x = 0;
			v_y = 0;
			die();
			apple.setActive(false);
		}

	}

	public void collide(Apple a) {
		Rectangle aRect = new Rectangle(a.getX(), a.getY(), 50, 50);
		Rectangle sRect = new Rectangle(x, y, 50, 25);

		if (aRect.intersects(sRect)) {
			apple.setX((int) (Math.random() * 600));
			apple.setY((int) (Math.random() * 600));
			curScore++;
			length += 50;
		}

	}

	public void scores() {

		if (curScore > bestScore) {
			bestScore = curScore;
		}

	}

	public void restart() {
		apple.setActive(true);
		active = true;
		x = 320;
		y = 350;
		length = 50;
		curScore = 0;
		die = false;
	}

	public void die() {

		active = false;

		die = true;

	}

// end of update, do not delete

	public void actionPerformed(ActionEvent arg0) {
// TODO Auto-generated method stub

		move();
		repaint();
		collide(apple);
		scores();

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

		// moving paddles
		if (e.getKeyCode() == 39) { // if the right key is pressed

			v_x = 7;
			v_y = 0;

		}
		if (e.getKeyCode() == 38) { // if the up key is pressed

			v_x = 0;
			v_y = -7;

		}
		if (e.getKeyCode() == 40) { // if the down key is pressed

			v_x = 0;
			v_y = 7;

		}
		if (e.getKeyCode() == 37) { // if the left key is pressed

			v_x = -7;
			v_y = 0;

		}

		if (e.getKeyCode() == 32) { // if the space key is pressed

			restart();

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