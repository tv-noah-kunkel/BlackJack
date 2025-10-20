import java.util.ArrayList;
import java.util.Scanner;


public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Integer> handVals = new ArrayList<>();
        Player rael = new Player("Rael");
        Player finn = new Player("Finn");
        Player thomas = new Player("Thomas");
        Player graham = new Player("graham");
        Dealer robert = new Dealer();
        
        players.add(rael);
        players.add(finn);
        players.add(thomas);
        players.add(graham);
        

        boolean keepPlaying = true;
      while(keepPlaying)
      {

        for(int i =0; i < players.size(); i++)
        {
            System.out.println(players.get(i).getName() + "'s turn.");
            players.get(i).playTurn(deck, scanner);
            handVals.add(players.get(i).getHandValue());
        } 

        robert.dealerPlayTurn(deck);

        for (int i = 0; i < players.size();i++)
        {
          if (handVals.get(i) > robert.getHandValue())
          {
            players.get(i).returnBet(true);
          }
          else
          {
            players.get(i).returnBet(false);
          }
        }
                                
        
      }  


         
    }
}
