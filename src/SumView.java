/**
 * @author sznicci
 *
 * ${tags}
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class SumView extends JFrame {
	private static final long serialVersionUID = 3121276284336142088L;
	
	private SumModel m_sum;
	PanelImage backgroundImage;
	ImagedButton buttonImage;
	JPanel content;
	JLabel exercise;
	JPanel choices;
	JPanel rewards;
	ImagedButton choice1;
	ImagedButton choice2;
	ImagedButton choice3;
	ImagedButton next;
	ImagedLabel good;
	ImagedLabel wrong;
	ImagedLabel[][] reward= new ImagedLabel[5][4];
	int[] score= new int[reward.length];

	
	public void setWrong(){
		System.out.print("setwrong");
		wrong.setImage(getClass().getResource("images/wrong.jpg"));
		wrong.setPreferredSize(new Dimension(60, 60));
	}	
	public void setGood(){
		System.out.print("setgood");
		good.setImage(getClass().getResource("images/good.jpg"));
		good.setPreferredSize(new Dimension(60, 60));
	}
	
	public void updateScore(){
		int newscore= m_sum.getGoodCounter();
		for(int i= 0; i< score.length; i++){

			score[i]= newscore%(reward[0].length+1);
			newscore= newscore/(reward[0].length+1);
			//System.out.println("i: "+score[i]);
		}
		
		for(int i= 0; i< reward.length; i++){
			for(int j= 0; j< score[i]; j++){
				//System.out.println("i: "+i);
				//System.out.println("j%5+1: "+((j%5)+1));
				//System.out.println("j%7: "+(j%7));
				//m_view.rewards.add(m_view.reward[(i%7)]);
				reward[i][j].setImage(getClass().getResource("drawings/00"+(i+1)+".jpg"));
			}
			for(int j= score[i]; j< reward[0].length; j++){
				reward[i][j].setImage();
			}
		}
	}
	
	public void reset(){
		choice1.setImage(getClass().getResource("images/gomb.jpg"));
		choice2.setImage(getClass().getResource("images/gomb.jpg"));
		choice3.setImage(getClass().getResource("images/gomb.jpg"));
		next.setImage(getClass().getResource("images/next.png"));
	}
	
	public SumView(SumModel sum){
		//logic set up
		m_sum= sum;

		backgroundImage= new PanelImage(getClass().getResource("images/hatter.jpg"));

		exercise= new JLabel(m_sum.getExercise());
		exercise.setPreferredSize(new Dimension(350, 130));
		//transparent label, set background
		exercise.setOpaque(false);
		exercise.setBackground(new Color(255, 255, 255));
		
		//choices buttons
		choice1= new ImagedButton(getClass().getResource("images/gomb.jpg"));
		choice2= new ImagedButton(getClass().getResource("images/gomb.jpg"));
		choice3= new ImagedButton(getClass().getResource("images/gomb.jpg"));
		choice1.setText(m_sum.getChoice1());
		choice1.setPreferredSize(new Dimension(100, 100));
		choice2.setText(m_sum.getChoice2());
		choice2.setPreferredSize(new Dimension(100, 100));
		choice3.setText(m_sum.getChoice3());
		choice3.setPreferredSize(new Dimension(100, 100));
		
		//next, labels
		next= new ImagedButton(getClass().getResource("images/next.png"));
		next.setPreferredSize(new Dimension(70, 70));
		good= new ImagedLabel(getClass().getResource("images/gw.jpg"));
		good.setPreferredSize(new Dimension(60, 60));
		wrong= new ImagedLabel(getClass().getResource("images/gw.jpg"));
		wrong.setPreferredSize(new Dimension(60, 60));
		
		//set font
		Font f;
		try {
			f= Font.createFont(Font.TRUETYPE_FONT, SumView.class.getClassLoader().getResourceAsStream("Fonts/hunNums.ttf")); 
			exercise.setFont(f.deriveFont(90f));
			choice1.setFont(f.deriveFont(63f));
			choice2.setFont(f.deriveFont(63f));
			choice3.setFont(f.deriveFont(63f));
		} catch (FontFormatException e) { e.printStackTrace();
		} catch (IOException e) { e.printStackTrace(); }
		
		//set panel
		content= new JPanel();
		choices= new JPanel();
		rewards= new JPanel();
		content.setOpaque(false);
		choices.setOpaque(false);
		rewards.setOpaque(false);
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.add(exercise);
		content.add(choices);
		content.add(rewards);
		
		choices.add(choice1, BorderLayout.SOUTH);
		choices.add(choice2, BorderLayout.SOUTH);
		choices.add(choice3, BorderLayout.SOUTH);
		choices.add(next, BorderLayout.SOUTH);
		choices.add(good, BorderLayout.SOUTH);
		choices.add(wrong, BorderLayout.SOUTH);
		
		rewards.setLayout(new GridLayout(reward.length,reward[0].length));
		for(int i= 0; i< reward.length; i++){
			for(int j= 0; j< reward[0].length; j++){
				rewards.add(reward[i][j]= new ImagedLabel());
				reward[i][j].setPreferredSize(new Dimension(100, 100));
			}
		}
		
		updateScore();
	}
	
	public void addChoiceListener(ActionListener cal){
		choice1.addActionListener(cal);
		choice2.addActionListener(cal);
		choice3.addActionListener(cal);
	}
	
	public void addNextListener(ActionListener cal){
		next.addActionListener(cal);
	}

	public void addFrameListener(WindowAdapter frameListener) {
		this.addWindowListener(frameListener);
		
	}
	
	public void addMyMouseListener(MouseAdapter mouseListener) {
		choice1.addMouseListener(mouseListener);
		choice2.addMouseListener(mouseListener);
		choice3.addMouseListener(mouseListener);
		next.addMouseListener(mouseListener);
		
	}

}
