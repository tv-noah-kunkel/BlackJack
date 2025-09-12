import java.util.ArrayList;


public class Run {
    public static void main(String[] args) {
        Deck deck = new Deck();
        ArrayList<Player> players = new ArrayList<>();

        Player rael = new Player("Rael");
        Player finn = new Player("Finn");
        Player thomas = new Player("Thomas");
        Player graham = new Player("graham");
        Dealer robert = new Dealer();
        
        players.add(rael);
        players.add(finn);
        players.add(thomas);
        players.add(graham);
        players.add(robert);

        for(Card card : deck.getCards())
        {
            System.out.println(card);
        }


         
    }
}
