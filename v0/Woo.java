import java.util.Scanner;

//driver

public class Woo{

  public static void main(String[] args){

    Chatbot chitty = new Chatbot();

    System.out.println(chitty.sayHello());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
    System.out.println(chitty.startTalking(statement));

		while (!statement.equals("bye"))
		{
			System.out.println (chitty.getResponse(statement));
			statement = in.nextLine();
		}
  }
}
