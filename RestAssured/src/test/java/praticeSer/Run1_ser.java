package praticeSer;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFSGame implements Serializable{
	String name;
	int level;
	long score;
	int life;
	public NFSGame(String name, int level, long score, int life) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}
		
}



public class Run1_ser {
	public static void main(String[] args) throws Throwable {
		NFSGame userObj = new NFSGame("hemanth", 10, 50000, 2);
		FileOutputStream fos = new FileOutputStream("./f.txt");
		
		ObjectOutputStream objOut = new ObjectOutputStream(fos);
		objOut.writeObject(userObj);
		System.out.println("====end====");
 		
	}

}
