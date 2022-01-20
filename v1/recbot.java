import java.util.Scanner;

public class Recbot extends Chatbot {

  Scanner in = new Scanner (System.in);
  String statement = in.nextLine();

  public recbot() {
    super();
  }

  public String languageSetting() {
    String a = "we have a selection of languages to select from. choose any (as most of the works have English translations.)";
    String b = "\n\t- 'English' \n\t\t>press 'eng' to browse~";
    String c = "\n\t- 'Chinese' \n\t\t>press 'cn' to browse~";
    String d = "\n\t- 'Korean' \n\t\t>say 'kn' to browse~";
    String e = "\n\t- 'Japanese' \n\t\t>say 'jp' to browse~";
    return a + b + c + d + e;
  }

}
