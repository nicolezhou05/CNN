import java.util.Scanner;
import java.util.Random;

public class Hangman extends Chatbot{

  //instance variables
  private int lives = 10;
  private String word = "";
  private String unguessed = "";

  Scanner in = new Scanner (System.in);
  String statement = "";

  String[] dictionary = {"snake", "auspicious", "magnanimous", "computer", "science", "programming"}

  public void randomWord(){
    Random ran = new Random();
    word = dictionary[ran.nextInt(dictionary.length)];
    System.out.println("Your word has " + word.length() + " letters");
    System.out.println("You have 10 lives. Start guessing one letter at a time! Please use lowercase!");
    unguessed = "_" * word.length();
    System.out.println(unguessed);
  }

  public void hangmanGame(){
    statement = in.nextLine();
    while (int i = 0; (i < word.length()) && (lives > 0); i += 1){
      if (statement.equals(word[1])){
        unguessed[i] = word[i];
      }
    }
  }
}
