import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        startApp();
    }

    public static void startApp()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What type of Poker Application would you like to run? enter: '1' (Test) | '2' (Game) | 'enter' (quit).");
        String choice = scanner.nextLine();
        while(!choice.isEmpty())
        {
            if(choice.charAt(0) == '1')
            {
                TestCases.test1();
                TestCases.test2();
                TestCases.test3();
                TestCases.test4();
                TestCases.test5();
                TestCases.test6();
                TestCases.test7();
                // TestCases.test8();
                // TestCases.test9();
                // TestCases.test10();
                // TestCases.test11();
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
