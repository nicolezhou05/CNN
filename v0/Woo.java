import java.util.Scanner;

//driver

public class Woo{

  public static void main(String[] args){

    System.out.println("--~~--~~--~~--\n");
    System.out.println("\n-~-~-~-\n\tjust a note: typing 'X' will end our conversation :((\n\t\tunless it's your friend's name ofc\n-~-~-~-\n");
    Chatbot chitty = new Chatbot();

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
    while (chitty.menu == true){

      statement = in.nextLine();
    }
    //get random responses while chatting w chitty
		while (!statement.equals("bye") && chitty.play == true && chitty.chat == true)
		{
			System.out.println (chitty.getResponse(statement));
			statement = in.nextLine();
		}
    // while (!statement.equals("bye"))
    // {
    //   System.out.println(chitty.getResponse(statement));
    //   statement = in.nextLine();
    // }

  }

}
