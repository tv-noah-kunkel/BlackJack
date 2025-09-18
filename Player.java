import java.util.ArrayList;
import java.util.Scanner;

public class Player
{

    private String name;
    private double money;
    private ArrayList<Card> hand = new ArrayList<>();
    Scanner myScanner = new Scanner(System.in);

    public Player(String name)
    {
        this.name = name;
        this.money = 100;
    }

    public void playTurn()
    {
        
    }

    public void hit()
    {
        //do stuff
    }

    public int getHandValue()
    {
        for(int i = 0; i > hand.size(); i++)
        {
            if(hand.face(i) == )
            {

            }
        }


        return 1;
    }

    public void getStartingHand(Deck deck)
    {

        for(int i = 0; i < 2; i++)
        {
        hand.add(deck.getTopCard());
        deck.discard(0);
        }


    }




}