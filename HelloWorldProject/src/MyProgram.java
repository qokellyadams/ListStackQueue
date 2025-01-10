/*
 * TODO: Name
 * TODO: Date
 * TODO: Class Period
 * TODO: Program Description
 */
import java.util.Scanner;
import java.io.File;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class MyProgram {
	public static int val = 0;
	public static void main(String[] args) {

		int limitTrackA = 100000, limitTrackB = 100000, limitTrackC = 100000;
		
		// TEACHER ONLY START
		
		int trackAWgt = 0, trackBWgt = 0, trackCWgt = 0;
		Stack <Train> trackA = new Stack <Train>();
		Stack <Train> trackB = new Stack <Train>();
		Stack <Train> trackC = new Stack <Train>();
		Stack <Train> trackExtra = new Stack <Train>();
		Stack <Train> trackOver = new Stack <Train>();
		Queue <Train> inputList = new LinkedList <Train>();
		boolean over = false;
		// TEACHER ONLY END

		Scanner x = new Scanner(System.in);
		try{
			File f = new File("HelloWorldProject/src/data.txt");
			x = new Scanner (f);
			String name = x.nextLine();
			while (!name.equals("END"))
			{
				Train t = readTrain(x, name);
				System.out.println("adding " + t);
				inputList.add(t);
				name = x.nextLine();
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		while(!inputList.isEmpty())
		{
			Train t = inputList.remove();
			if(t.isEngine())
			{
				Stack <Train> toEmpty; 
				if(t.getDestination().equals("Trenton"))
					toEmpty = trackA;
				else if(t.getDestination().equals("Charlotte"))
					toEmpty = trackB;
				else
					toEmpty = trackC;
				System.out.println("\n"+t);
				while(!toEmpty.empty())
				{
					System.out.println(toEmpty.pop());
				}
			}
			else
			{
				if(t.getDestination().equals("Trenton"))
				{
					if (t.getMiles() > 700)
						trackOver.push(t);
					else if(trackAWgt + t.getWeight() < limitTrackA)
					{
						trackA.push(t);
						trackAWgt += t.getWeight();
					}
					else
					{
						emptyTrain(trackA, "Trenton");
						trackA.push(t);
						trackAWgt = t.getWeight();
					}
				}
				else if(t.getDestination().equals("Charlotte"))
				{
					if (t.getMiles() > 700)
						trackOver.push(t);
					else if(trackBWgt + t.getWeight() < limitTrackB)
					{
						trackB.push(t);
						trackBWgt += t.getWeight();
					}
					else
					{
						emptyTrain(trackB, "Charlotte");
						trackB.push(t);
						trackBWgt = t.getWeight();
					}
				}
				else if(t.getDestination().equals("Baltimore"))
				{
					if (t.getMiles() > 700)
						trackOver.push(t);
					else if(trackCWgt + t.getWeight() < limitTrackC)
					{
						trackC.push(t);
						trackCWgt += t.getWeight();
					}
					else
					{
						emptyTrain(trackC, "Baltimore");
						trackC.push(t);
						trackCWgt = t.getWeight();
					}
				}
				else 
					trackExtra.push(t);
			}
			if(inputList.isEmpty() && !over)
			{
				if(!trackOver.empty())
				{
					over = true;
					//System.out.println("adding overs");
					while(!trackOver.empty())
					{
						System.out.println(trackOver.peek());
						inputList.add(trackOver.pop());
					} // end while
				} // end if 
			} // end if
		} // end while processing list of input
		// emptying all the trains:
		System.out.println("\nEnd of Day - Sending remaining trains:");
		if (!trackA.isEmpty())
			emptyTrain(trackA, "Trenton");
		if (!trackB.isEmpty())
			emptyTrain(trackB, "Charlotte");
		if (!trackC.isEmpty())
			emptyTrain(trackC, "Baltimore");
		if (!trackExtra.isEmpty())
		{
			System.out.println("\nThese are the cars remaining in the yard:");
			while(!trackExtra.empty())
			{
				System.out.println(trackExtra.pop());
			}
		}
	}

	public static Train readTrain(Scanner x, String name)
	{
		Train ret;
		if (name.substring(0,3).equals("CAR"))
		{
			String product = x.nextLine();
			String origin = x.nextLine();
			String destination = x.nextLine();
			int weight = x.nextInt();
			x.nextLine();
			int miles = x.nextInt();
			x.nextLine();
			ret = new Train(name, product, origin, destination, weight, miles);
		}
		else
		{
			String destination = x.nextLine();
			ret = new Train(name, destination);
		}
		return ret;
	}

	public static void emptyTrain(Stack <Train> myTrack, String d)
	{
		System.out.println("\nENG00000 leaving for "+ d + " with the following cars: " + val++);
		while(!myTrack.empty())
		{
			System.out.println(myTrack.pop());
		}
	}
}
