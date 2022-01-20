import java.util.Scanner;
import java.util.ArrayList;

public class EndingLetter extends Chatbot{

  Scanner in = new Scanner (System.in);
  String statement = in.nextLine();

  String mode = "";

  private String[] easyA = {"apple", "ant", "annoy", "almost", "app"};
  private String[] easyB = {"bunny", "boy", "ball", "bin", "board"};
  private String[] easyC = {"cat", "corn", "cap", "coat", "clap"};
  private String[] easyD = {"dog", "dime", "dizzy", "doll", "dart"};
  private String[] easyE = {"elephant", "eat", "envelope", "earn", "elevator"};
  private String[] easyF = {"fairy", "far", "frill", "fast", "fork"};
  private String[] easyG = {"gorilla", "gourd", "grin", "greet", "grow"};
  private String[] easyH = {"happy", "horn", "hat", "hiccup", "hotel"};
  private String[] easyI = {"igloo", "ill", "ink", "indigo", "imp"};
  private String[] dictionary2;

  public EndingLetter(){
    super();
    play = true;
  }

  public void fillDictionary(String[] dictionary){
    if (mode == "easy"){
      A[] = {"apple", "ant", "annoy", "almost", "app"};
      B[] = {"bunny", "boy", "ball", "bin", "board"};
      C[] = {"cat", "corn", "cap", "coat", "clap"};
      D[] = {"dog", "dime", "dizzy", "doll", "dart"};
      E[] = {"elephant", "eat", "envelope", "earn", "elevator"};
      F[] = {"fairy", "far", "frill", "fast", "fork"};
      G[] = {"gorilla", "gourd", "grin", "greet", "grow"};
      H[] = {"happy", "horn", "hat", "hiccup", "hotel"};
      I[] = {"igloo", "ill", "ink", "indigo", "imp"};
    }
  }
}
