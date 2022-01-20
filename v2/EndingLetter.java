import java.util.Scanner;
import java.util.ArrayList;

public class EndingLetter extends Chatbot{

  Scanner in = new Scanner (System.in);
  String statement = in.nextLine();

  String mode = "";

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
