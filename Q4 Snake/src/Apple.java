import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

/* class to represent a Ship object in a game */
public class Apple {

	// attributes of a ship object
	public int x, y; // position
	private Image img; // for sprite image
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	public boolean active = true;

	// constructor
	public Apple(String fileName) {
		x = 200;
		y = 200;

		// do not touch
		img = getImage(fileName);
		updateShip();
	}

	// 2nd constructor that takes in desired position
	public Apple(int paramX, int paramY, String paramFileName) {
		this(paramFileName); // calls the base constructor

		// the this() call will setup some variables
		// the rest is done here
		x = paramX;
		y = paramY;

		// anytime you alter x or y, you must call updateShip()
		updateShip();

	}
	

	// draw the affinetransform
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		// ship will handle drawing active enemyFire

	}

	private void updateShip() {
		tx.setToTranslation(x, y);
	}

	// converts image to make it drawable in paint
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Apple.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setActive( boolean active) {
		
		this.active = active;
		
	}

	public void setX(int x) {
		this.x = x;
		updateShip(); // call this method anytime x or y changes
	}

	public void setY(int y) {
		this.y = y;
		updateShip();
	}

	public int getY1() {
		return y;
	}

}
