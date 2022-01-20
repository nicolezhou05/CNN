import java.util.Scanner;

public class GuessNum extends Chatbot{

  //instance vars
  private int _lo, _hi, _guessCtr, _target;
  Scanner sc = new Scanner( System.in );
  int guess = sc.nextInt();

  public GuessNum( int a, int b ){
    _lo = Math.min(a,b);
    _hi = Math.max(a,b);
    _guessCtr = 1;
    _target = (int)(Math.random() * Math.max(a, b)) + Math.min(a, b);
  }

  public void playIter(){
    //int guess;
    while( true ) {
      System.out.print("Guess a num bt " + _lo + " & " + _hi + ": ");
      guess = sc.nextInt();
      if (guess > _target){
        _hi = guess - 1;
        System.out.println("Too high, try again...");
      }
      else if (guess < _target){
        _lo = guess + 1;
        System.out.println("Too low, try again...");
      }
      else{
        System.out.println("Correct! It took " + _guessCtr + " guesses.");
        break;
      }
      _guessCtr++;
    }
  }

}
