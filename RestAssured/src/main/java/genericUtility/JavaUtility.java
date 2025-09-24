package genericUtility;

import java.util.Random;

public class JavaUtility {
	public int getRandomNumber()
	{	
		Random random= new Random();
		int randomNumber = random.nextInt(5000);
		return randomNumber;
	}
	
	  public char getRandomLetters(){
	        Random random = new Random(); 
	        char randomChar = (char) ('A' + random.nextInt(26));
			return randomChar;
	    }
	

}
