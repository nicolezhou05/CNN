import java.util.Scanner;

public class Chat extends Chatbot{

  Scanner in = new Scanner (System.in);
  String statement = in.nextLine();

  public Chat(){
    super();
    play = true;
    chat = true;
  }

  public String chat() {
    System.out.println("hello how's it going?");
    return getGoing(statement);
  }

  public String getGoing(String statement) {
    while (!statement.equals("bye"))
		{
			System.out.println (getResponse(statement));
			statement = in.nextLine();
    }
    return "bye";
  }
}
