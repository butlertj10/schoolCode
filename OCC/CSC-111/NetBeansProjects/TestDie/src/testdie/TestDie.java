
package testdie;

public class TestDie
{
    public static void main (String [ ] args)
    {
        //Local Constants
        final int MAX_ROLLS = 1000; //Maximum number of rolls

        //Local Variables
        int num1, num2; //dice
        int total; //sum of a roll
        boolean doubles; //true if doubles has been rolled
        int numDoubles = 0; //number of doubles rolled
        int doubleValue; //face value if doubles has been rolled
       
        //Instantiate two Objects of the external Class Die
        Die die1 = new Die( ); //create one die Object of Class Die
        Die die2 = new Die( ); // create a second die Object of Class Die
        
        //Test the roll of one die
        num1 = die1.roll( );
        num2 = die2.roll ( );
        System.out.println("You have rolled a " + num1 + " and a " + num2);
        
        //Test returning the sum of a roll of a pair of dice
        total = die1.sum(num1, num2);
        System.out.println("You have rolled a " + total);
        
        //Test for number of doubles rolled out of 1000
        for (int numRolls = 1; numRolls <= MAX_ROLLS; numRolls++)
        {
            //Roll two dice
            num1 = die1.roll( );
            num2 = die2.roll ( );
            
            //Determine if doubles has been rolled
            doubles = die1.isDoubles(num1, num2);
            if (doubles == true)
            numDoubles++;
        }
        //Display number of doubles rolled
        System.out.println("You have rolled doubles " + numDoubles + " out of 1000 rolls.");       

       //Test for face value if doubles is rolled
       do
       {
            //Roll two dice
           num1 = die1.roll( );
           num2 = die2.roll ( );
            //Determine if doubles has been rolled
           doubleValue = die1.faceValue(num1, num2);
        }
        while (doubleValue == 0); //Stop when doubles rolled

        //Display face value of doubles
       System.out.println("You have rolled a double " + doubleValue + ".");
    }//end main
}//end text die