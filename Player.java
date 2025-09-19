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

    public void playTurn(Deck deck)
    {
        char hitStay;
        Scanner scanner = new Scanner(System.in);
        System.out.print("would you like to hit(h) or stay(s): ");
        hitStay = scanner.next().charAt(0);
        boolean validInput;
        while(validInput = false)
        if(hitStay == 'h')
        {
            hit(deck);
            System.out.println("You drew a(n) " +  hand.get(hand.size()-1).toString() + ". your hand value is now " + getHandValue() + ".");
            validInput = true;
        }
        else if (hitStay == 's') 
        {
            System.out.println("You stayed.");
            validInput = true;    
        }
        else 
        {
            System.out.println("Not a valid input.");
        }



    }

    public void hit(Deck deck)
    {
        hand.add(deck.getTopCard());
        deck.discard(0);
    }

    public int getHandValue()
    {
        int handValue = 0;
        for(int i = 0; i > hand.size(); i++)
        {
            if(hand.get(i).getFace() == "A")
            {
                if((handValue + 11) < 21)
                {
                    handValue += 11;
                }
                else
                {
                    handValue+=1; 
                }
            }
            else 
            {
                handValue += hand.get(i).getValue();
            }
        }

        if(handValue > 21) 
        {
            handValue = -1;
        }  
    


        return handValue;
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