import java.util.Scanner;

public class EndingLetter extends Chatbot{

  Scanner in = new Scanner (System.in);
  String statement = in.nextLine();

  String[] dictionary;

  public EndingLetter(){
    super();
    play = true;
  }

  public void fillDictionary(String[] dictionary);
}
