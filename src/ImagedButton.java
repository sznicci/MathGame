/**
 * @author sznicci
 *
 * ${tags}
 */

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ImagedButton extends JButton {
	private static final long serialVersionUID = 4583012375836531732L;
	private Image image = null;

    public ImagedButton(String filename) {
        this.image = new ImageIcon(filename).getImage();
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorder(BorderFactory.createEmptyBorder());
    }
    
    public ImagedButton(URL filename) {
        this.image = new ImageIcon(filename).getImage();
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorder(BorderFactory.createEmptyBorder());
    }
    public void setImage(){
    	this.image = new ImageIcon(getClass().getResource("images/gomb.jpg")).getImage();
    }

	public void setImage(String filename){
    	this.image = new ImageIcon(filename).getImage();
    }
	public void setImage(URL resource) {
    	this.image = new ImageIcon(resource).getImage();		
	}

	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
        g.drawString(getText(), 20, 65);
    }
}
