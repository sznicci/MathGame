
/**
 * @author sznicci
 *
 * ${tags}
 */

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImagedLabel extends JLabel {
	private static final long serialVersionUID = 7629417661552049983L;
	private Image image = null;

	public ImagedLabel() {
		this.image = new ImageIcon(getClass().getResource("images/ures.jpg")).getImage();
	}

	public ImagedLabel(String filename) {
		this.image = new ImageIcon(filename).getImage();
	}

	public ImagedLabel(URL resource) {
		this.image = new ImageIcon(resource).getImage();
	}

	public void setImage(String filename) {
		this.image = new ImageIcon(filename).getImage();
	}

	public void setImage() {
		this.image = new ImageIcon(getClass().getResource("images/ures.jpg")).getImage();
	}

	public void setImage(URL resource) {
		this.image = new ImageIcon(resource).getImage();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
	}
}
