import java.util.Scanner;

/*
 * Main Class to start the application
 */
public class App {
    public static void main(String[] args) throws Exception {
        startApp();
    }

    /*
     * Function gives you choices to run test cases, play a game of poker, or quit the application.
     */
    public static void startApp()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nTo see poker rules visit: https://bicyclecards.com/how-to-play/basics-of-poker\n");
        System.out.println("ATTENTION: For best experience please play with a window/terminal Full Screen.");
        System.out.println("What type of Poker Application would you like to run? enter: '1' (Test) | '2' (Game) | 'enter' (quit).");
        String choice = scanner.nextLine();
        while(!choice.isEmpty())
        {
            if(choice.charAt(0) == '1')
            {
                TestCases.test1();
                TestCases.test1a();
                TestCases.test1b();
                TestCases.test2();
                TestCases.test2a();
                TestCases.test2b();
                TestCases.test3();
                TestCases.test3a();
                TestCases.test3b();
                TestCases.test4();
                TestCases.test4a();
                TestCases.test5();
                TestCases.test5a();
                TestCases.test5b();
                TestCases.test6();
                TestCases.test6a();
                TestCases.test6b();
                TestCases.test6c();
                TestCases.test7();
                TestCases.test7a();
                TestCases.test8();
                TestCases.test8a();
                TestCases.test9();
                TestCases.test10();  
            }
            else if(choice.charAt(0) == '2')
            {
                Game.startGame(scanner);
            }
            else if(choice.isEmpty())
            {
                System.out.println("You quite the application");
            }
            System.out.println("What type of Poker Application would you like to run Test: (1) | Game: (2) | Quit: press enter");
            choice = scanner.nextLine();
        }
        
        scanner.close();
        System.out.println("Application ended.");
    }
   
}
