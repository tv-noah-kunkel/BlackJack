import java.util.ArrayList;


public class Run {
    public static void main(String[] args) {
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
        

        for(Card card : deck.getCards())
        {
            System.out.println(card);
        }
        boolean keepPlaying = true;
      while(keepPlaying)
      {

        for(int i = 0; i < players.size(); i++)
        {
            players.get(i).placeBet();
        }
        for(int i =0; i < players.size(); i++)
        {
            players.get(i).playTurn(deck);
            handVals.add(players.get(i).getHandValue());
        } 
                                
        
      }  


         
    }
}
