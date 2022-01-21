import java.util.Scanner;

//driver

public class Woo {

  public static void main(String[] args){
    // Opening
    System.out.println("--~~--~~--~~--\n");
    System.out.println("\n-~-~-~-\n\tjust a note: typing 'X' will end our conversation :((\n\t\tunless it's your friend's name ofc\n-~-~-~-\n");
    Chatbot chitty = new Chatbot();

    // Chitty's first intake
    System.out.println(chitty.sayHello());
		Scanner in = new Scanner (System.in);
    String statement = in.nextLine();
    if(statement.equals("X")){
      chitty.play = false;
    }

    System.out.println(chitty.getName(statement));

    statement = in.nextLine();
    System.out.println(chitty.firstGetResponse(statement));

    //menu interface options
    statement = in.nextLine();
    while (chitty.menu == true){
      System.out.println("1 " + statement);
      System.out.println("->> " + chitty.menuResponse(statement));
    }

    // while (chitty.gameResponse = true){
    //   statement = in.nextLine();
    //   System.out.println(chitty.games.gameMenu()); //error
    //   statement = in.nextLine();
    // }



    //game menu

    //get random responses while chatting w chitty
		// while (!statement.equals("bye") && chitty.play == true && chitty.chat == true)
		// {
		// 	System.out.println (chitty.getResponse(statement));
		// 	statement = in.nextLine();
		// }

  }

}
