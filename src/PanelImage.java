/**
 * @author sznicci
 *
 * ${tags}
 */

import javax.swing.*;

import java.awt.*;
import java.net.URL;

public class PanelImage extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private Image image = null;

    public PanelImage(String filename) {
        this.image = new ImageIcon(filename).getImage();
    }

    public PanelImage(URL resource) {
    	this.image = new ImageIcon(resource).getImage();
	}

	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
    }
}
