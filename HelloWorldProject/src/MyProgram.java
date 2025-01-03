/*
 * TODO: Name
 * TODO: Date
 * TODO: Class Period
 * TODO: Program Description
 */
import java.util.Scanner;
import java.io.File;

//Yes, I know the file name should be something like ReviewProgram - working on it!
public class MyProgram {

	public static void main(String[] args) {
		//TODO: Implement Program Requirements Here
		Scanner x = new Scanner(System.in);
		try{
			File f = new File("src/data.txt");
			x = new Scanner (f);
			String val = x.nextLine();
			System.out.println(val);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
