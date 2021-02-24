import java.util.Scanner;
public class Game
{
    private Player player1;
    private Player player2;
    private boolean playAgain = true;
    public Game()
    {
       player1 = new Player();
       player2 = new Player();
    }
    public void play()
    {
        Scanner sc = new Scanner(System.in);
        
        //prompts for input, checks input and changes number of pieces
        while(playAgain == true)
        {
            //decides randomly who goes first
            Player starterPlayer;
            int currPlayer = (int)(Math.random() + 1);
            if(currPlayer == 1)
            {
                starterPlayer = player1;
            }
            else
            {
                starterPlayer = player2;
            }
            System.out.println(starterPlayer.getName() + " you are first!");
            //loops until game ends
            while(Board.getNumPieces() > 1)
            {
                System.out.println("There are " + Board.getNumPieces() + " pieces.");
                System.out.println(starterPlayer.getName() + ", how many pieces would you like to remove?: ");
                int num = sc.nextInt();
                //checks valid response
                while(num < 1 || num > Board.getNumPieces()/2)
                {
                    System.out.println(starterPlayer.getName() + ", how many pieces would you like to remove?: ");
                    num = sc.nextInt();
                }
                //removes pieces
                Board.removePieces(num);
                //switch players
                if(currPlayer == 1)
                {
                    currPlayer = 2;
                    starterPlayer = player2;
                } 
                else
                {
                    currPlayer = 1;
                    starterPlayer = player1;
                }
            }//round has ended
            if(currPlayer == 1)
                {
                    System.out.println(player2.getName() + " wins!");
                    player2.incrScore();

                }
                else
                {
                    System.out.println(player1.getName() + " wins!!");
                    player1.incrScore();
                }
            System.out.println(player1.getName() + "'s score: " + player1.getScore());
            System.out.println(player2.getName() + "'s score: " + player2.getScore());
            System.out.println("Would you like to play again? 1(Yes) 2(No)");
            int answer = sc.nextInt();
            if(answer == 1)
            {
                Board.populate();
            }
                else if(answer == 2)
            {
            System.out.println("Thanks for playing!");
            playAgain = false;
            }
        }//game ends
    }
}
//:)