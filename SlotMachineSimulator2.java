import java.util.Scanner;
//importing the DecimalFormatter is different than in the book! :<
import java.text.DecimalFormat;
import java.util.Random;

public class SlotMachineSimulator2
{
   public static void main(String[] args)
   {
      double monies;
      double winnings = 0.00;
      double accumulator = 0;
      int randomNum1, randomNum2, randomNum3;
      String symbol1, symbol2, symbol3;
      String isSucker;
   
    //creating objects
      Scanner keyboard = new Scanner(System.in);
    //declaring format for monies
      DecimalFormat formatter = new DecimalFormat("$#,##0.00");
   
        danglingCarrot();
   
      do
      {
         winnings = 0.00;
         System.out.print("To play, please enter the amount you wish to wager: ");
         monies = keyboard.nextDouble();
         System.out.println();
         if (monies == 0)
         {
            System.out.println("Can't play if you don't pay!");
            break;
         }
         if (monies < 0)
         {
            System.out.println("No need to be negative when you can win BIG!!");
            System.out.print("Please enter the amount you wish to wager to play: ");
            monies = keyboard.nextDouble();
            System.out.println();
         }
         if (monies >= 1)
         {
         //random object
            Random randomNumber = new Random();
         //generating random numbers for symbols
            randomNum1 = randomNumber.nextInt(6);
         //System.out.print(randomNum1 + " ");//troubleshooting line
            symbol1 = intToSymbol(randomNum1);
            System.out.print("[" + symbol1 + "]");
         
            randomNum2 = randomNumber.nextInt(6);
         //System.out.print(randomNum2 + " ");//troubleshooting line
            symbol2 = intToSymbol(randomNum2);
            System.out.print("[" + symbol2 + "]");
         
            randomNum3 = randomNumber.nextInt(6);
         //System.out.print(randomNum3 + " ");//troubleshooting line
            symbol3 = intToSymbol(randomNum3);
            System.out.println("[" + symbol3 + "]");
            System.out.println();
         }
      
        //winner winner!
         if (symbol1.equals(symbol2) && symbol2.equals(symbol3))
            winnings = tripleTheMonies(monies);
      
        //#HOPE
         if ((symbol1 != symbol2) && (symbol1 != symbol3) && (symbol2 != symbol3))
         {
            System.out.println("Ooooh! Soo close!!");
            System.out.println();
         }
         
         else
         {
          //keep them addicted!
            if (symbol1.equals(symbol2) || symbol1.equals(symbol3) || symbol2.equals(symbol3))
               winnings = doubleTheMonies(monies);
         }
         accumulator = accumulator + winnings;
         System.out.println("You've just won " + formatter.format(winnings) + "!!");
         System.out.println("You're grand total is " + formatter.format(accumulator) + "!");
         System.out.print("Would you like a chance to win MORE? (Enter 'y' for yes): ");
         isSucker = keyboard.nextLine().toLowerCase();
         System.out.print("x" + isSucker + "x");
      } while (isSucker == "y");
   }

   ////Module: danglingCarrot (intro)
   public static void danglingCarrot()
   {
      System.out.println("SLIPPY SAM'S SLOTS");
      System.out.println();
      System.out.println("Welcome to Slippy Sam's Slots!");
      System.out.println("Give us your money for your chance to win BIG!");
      System.out.println("Match two and double your money!");
      System.out.println("Match three and TRIPLE your money!!");
      System.out.println();
   }

  ////Function: randomBarrels (calls random object to assign a random number to each barrel)
   //public static
   
   ////Function: intToSymbol (returns string-type for "symbol1", "symbol2", "symbol3")
   public static String intToSymbol(int randomNumArg)
   {
      String symbolReturn = "temp";
      if (randomNumArg == 0)
         symbolReturn = "Cherries";
      if (randomNumArg == 1)
         symbolReturn = "Oranges";
      if (randomNumArg == 2)
         symbolReturn = "Plums";
      if (randomNumArg == 3)
         symbolReturn = "Bells";
      if (randomNumArg == 4)
         symbolReturn = "Melons";
      if (randomNumArg == 5)
         symbolReturn = "Bars";
      return symbolReturn;
   }

   ////Function: tripleTheMonies (returns double-type for "winnings")
   public static double tripleTheMonies(double winningArgs)
   {
      double chickenDinner = winningArgs * 3;
      return chickenDinner;
   }

   ////Function: doubleTheMonies (returns double-type for "winnings")
   public static double doubleTheMonies(double winningArgs)
   {
      double fodder = winningArgs * 2;
      return fodder;
   }
}
