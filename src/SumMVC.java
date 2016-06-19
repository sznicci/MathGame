/**
 * @author sznicci
 *
 * ${tags}
 */

import java.awt.BorderLayout;
import javax.swing.*;

public class SumMVC {

	public static void main(String[] args){
		SumModel c_model= new SumModel();
		SumView c_view= new SumView(c_model);
		SumController sumC= new SumController(c_model, c_view);
		
		c_view.getContentPane().add(BorderLayout.CENTER, c_view.backgroundImage);
		c_view.backgroundImage.add(c_view.content);
		c_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c_view.setSize(1024, 768);
		c_view.setVisible(true);
	}


}
