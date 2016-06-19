/**
 * @author sznicci
 *
 * ${tags}
 */

import java.io.*;
import java.util.*;

public class SumModel {
	private int number1;
	private int number2;
	private int result1;
	private int result2;
	private int goodResult;
	private ArrayList<Integer> choices;
	private int goodCounter;
	private boolean goodCChecker;
	private int rand;
	
	public SumModel(){
		load();
		generate();
	}
	
	public void save(){
		try {
			 
			String content= getGoodCounter()+"";
 
			File saveFile= new File("C:/Users/Public/Documents/eriJatekMentes.txt");
 
			// if file doesnt exists, then create it
			if (!saveFile.exists()) {
				saveFile.createNewFile();
			}
 
			FileWriter fw = new FileWriter(saveFile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void load(){
		try{
			File loadFile= new File("C:/Users/Public/Documents/eriJatekMentes.txt");
			
			
			if (!loadFile.exists()) {
				setGoodCounter(0);
				return;
			}

			FileReader fileReader= new FileReader(loadFile);
			BufferedReader reader= new BufferedReader(fileReader);

			String line= null;
			
			while( (line= reader.readLine()) != null ){
				setGoodCounter(Integer.parseInt(line));
			}
			
			reader.close();
		}catch(Exception ex){ ex.printStackTrace(); }
	}
	
	public void generate(){
		goodCChecker= false;
		choices= new ArrayList<Integer>();

		if(getGoodCounter()<71){
			rand= 10;
		}
		else if(getGoodCounter()>=71 && getGoodCounter()<251){
			rand= 15;
		}
		else if(getGoodCounter()>=251){
			rand= 20;
		}
		number1= (int) (Math.random() *rand);
		number2= (int) (Math.random() *rand);
		
		goodResult= number1+number2;
		/*System.out.println("jo: "+goodResult);
		System.out.println("num1: "+number1);
		System.out.println("num2: "+number2);*/
		do{
			result1= (int) (Math.random() *(rand*2));
		} while(goodResult==result1);
		do{
			result2= (int) (Math.random() *(rand*2));
		} while(result2==result1 || result2==goodResult);
		choices.add(result1);
		choices.add(result2);
		choices.add(goodResult);
		long seed = (long) (Math.random() *100); //System.nanoTime();
		Collections.shuffle(choices, new Random(seed));

	}
	
	public String getExercise(){
		return number1+" + "+number2+" = ";
	}
	
	public String getChoice1(){
		return choices.get(0).toString();
	}
	public String getChoice2(){
		return choices.get(1).toString();
	}
	public String getChoice3(){
		return choices.get(2).toString();
	}
	
	public boolean check(int result){
		if(!goodCChecker){
			if(goodResult == result){
				setGoodCounter(getGoodCounter() + 1);
			}
			goodCChecker= true;
			System.out.println("gcounter: "+getGoodCounter());
		}
		//System.out.print(goodResult +" "+ result);
		return (goodResult == result) ? true : false;
	}
	
	public static void main(String[] args){
		/*SumModel oM= new SumModel();
		oM.generate();
		System.out.println(oM.getExercise());
		System.out.println(oM.getChoice1());
		System.out.println(oM.getChoice2());
		System.out.println(oM.getChoice3());*/
	}

	protected int getGoodCounter() {
		return goodCounter;
	}

	protected void setGoodCounter(int goodCounter) {
		this.goodCounter = goodCounter;
	}
}
