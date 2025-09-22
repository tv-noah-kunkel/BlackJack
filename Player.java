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
        boolean validInput = false;
        while(validInput = false)
        if(hitStay == 'h')
        {
            hit(deck);
            System.out.println("You drew a(n) " +  hand.get(hand.size()-1).toString() + ". your hand value is now " + getHandValue() + ".");
            validInput = false;
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

    public double placeBet()  
    {
        Scanner betScan = new Scanner(System.in);
        boolean validBet = false;
        double bet = 0;
        while(validBet == false)
        {
            System.out.print("How much would you like to bet: ");
            bet = betScan.nextDouble();
            betScan.nextLine();
            if(bet > money)
            {
                System.out.println("Please enter a bet less than or equal to the amount of money you have.");
            }
            else if(bet < 0)
            {
                System.out.println("PLease enter a value than greater than zero.");
            }
            else
            {
                System.out.println("thank you you bet " + bet + " dollars" );
                validBet = true;
                money -= bet;                
            }
        }
        return bet;  
    }

    public void returnBet()
    {
        double bet = placeBet();
        if(win)
        {
            money += bet*2;
        }
    }

    public boolean outcome()
    {
        
    }



}
