package praticeSer;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Run2_deSerTEst {

	public static void main(String[] args) throws Throwable {

		FileInputStream input = new FileInputStream("./f.txt");
		ObjectInputStream ObjIn = new ObjectInputStream(input);
		NFSGame userObj=(NFSGame)ObjIn.readObject();
		
		System.out.println(userObj.name);
		System.out.println(userObj.level);
		System.out.println(userObj.score);
		System.out.println(userObj.life);

	}

}
