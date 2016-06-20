/**
 * @author sznicci
 *
 * ${tags}
 */

import java.awt.event.*;
import java.util.Properties;

//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class SumController {
	private SumModel m_model;
	private SumView m_view;
//	private SendEmail m_mail= new SendEmail();
	
	public SumController(SumModel model, SumView view){
		m_model= model;
		m_view= view;
		
		view.addNextListener(new NextListener());
		view.addChoiceListener(new ChoiceListener());
		view.addFrameListener(new FrameListener());
		view.addMyMouseListener(new MyMouseListener());
	}
	
	class ChoiceListener implements ActionListener{
		public void actionPerformed(ActionEvent e) { 			
		    try{
		    	boolean good= m_model.check(Integer.parseInt(e.getActionCommand()));
		    	//m_view.reset();
		    	if(good){
		    		m_view.good.setImage(getClass().getResource("images/good.jpg"));
		    		m_view.updateScore();
		    		m_view.repaint();
			    	
		    	}else{
		    		m_view.setWrong();
		    		m_view.repaint();
		    	}  

		    }catch(Exception ex){ ex.printStackTrace(); }
		}
	}
	
	class NextListener implements ActionListener{
		public void actionPerformed(ActionEvent e) { 			
		    try{
		    	m_model.generate();
		    	m_view.exercise.setText(m_model.getExercise());
		    	m_view.choice1.setText(m_model.getChoice1());
		    	m_view.choice2.setText(m_model.getChoice2());
		    	m_view.choice3.setText(m_model.getChoice3());
		    	m_view.good.setImage(getClass().getResource("images/gw.jpg"));
		    	m_view.wrong.setImage(getClass().getResource("images/gw.jpg"));
		    	m_view.repaint();
		    }catch(Exception ex){ ex.printStackTrace(); }
		}
	}
	
	class FrameListener extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			JOptionPane.showMessageDialog(m_view, "Saving status.\n Press OK.");
			m_model.save();
//			m_mail.sendMail(new Integer(m_model.getGoodCounter()).toString());

			//System.out.println("closed");
	  	}
	}
	
	class MyMouseListener extends MouseAdapter{
		public void mouseEntered(MouseEvent e){
			
			if((ImagedButton)e.getSource()== m_view.choice1 && e.getButton()==0){
				m_view.choice1.setImage(getClass().getResource("images/gombOver.jpg"));
			}
			if((ImagedButton)e.getSource()== m_view.choice2 && e.getButton()==0){
				m_view.choice2.setImage(getClass().getResource("images/gombOver.jpg"));
			}
			if((ImagedButton)e.getSource()== m_view.choice3 && e.getButton()==0){
				m_view.choice3.setImage(getClass().getResource("images/gombOver.jpg"));
			}
			if((ImagedButton)e.getSource()== m_view.next && e.getButton()==0){
				m_view.next.setImage(getClass().getResource("images/nextOver.jpg"));
			}
		}
		public void mouseExited(MouseEvent e) {
			m_view.choice1.setImage(getClass().getResource("images/gomb.jpg"));
			m_view.choice2.setImage(getClass().getResource("images/gomb.jpg"));
			m_view.choice3.setImage(getClass().getResource("images/gomb.jpg"));
			m_view.next.setImage(getClass().getResource("images/next.png"));
	    }
	}

}
