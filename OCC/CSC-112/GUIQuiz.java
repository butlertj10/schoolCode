package guiquiz;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author t.j.butler2
 */
public class GUIQuiz 
{
   private static mainFrame frame;
    
   public static void main(String[] args) 
    {
        ArrayList<QuestionAnswer> testQuestions = new ArrayList<QuestionAnswer>(); 
        
        frame = new mainFrame("Quiz");

        takeTest(testQuestions);
    }

    /**
     *
     * @param testQuestions
     */
    public static void takeTest(ArrayList<QuestionAnswer> testQuestions)
    {
        int score = 0;
        Scanner input = new Scanner(System.in);
        
        for (int i = 0; i < testQuestions.size(); i++) 
        {
            System.out.println(testQuestions.get(i).GetQuestion());
            String qAnswer = input.nextLine();
            
            if (qAnswer.equals(testQuestions.get(i).GetAnswer()))
                score++;
       }
        
        // Make into a %
        System.out.println("Your Score: " + score );
    } 

}
    