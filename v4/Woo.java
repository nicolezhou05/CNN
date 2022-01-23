import java.util.Scanner;

//driver

public class Woo {

  public static void main(String[] args){
    // Opening
    System.out.println("--~~--~~--~~--\n");
    Chatbot chitty = new Chatbot();

    // Chitty's first intake
    System.out.println(chitty.sayHello());
		Scanner in = new Scanner (System.in);
    String statement = in.nextLine();

    System.out.println(chitty.getName(statement));

    statement = in.nextLine();
    System.out.println(chitty.firstGetResponse(statement));

    //menu interface options
    statement = in.nextLine();
    while (chitty.menu == true){
      System.out.println(chitty.menuResponse(statement));
    }

  }

}
