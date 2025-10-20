import java.util.ArrayList;
import java.util.Scanner;

public class Player
{

    private String name;
    private double money;
    private ArrayList<Card> hand = new ArrayList<>();
    private double bet;

    public Player(String name)
    {
        this.name = name;
        this.money = 100;
    }

    public void playTurn(Deck deck, Scanner scanner)
    {   
        placeBet(scanner);
        getStartingHand(deck);
        System.out.println("Your hand is " + hand.get(0).toString()+ " and " + hand.get(1).toString());
        char hitStay;
        System.out.println("would you" + name + "like to hit(h) or stay(s): ");
        scanner.nextLine();
        String hs = scanner.nextLine();
        hitStay = hs.charAt(0);
       
        
        boolean validInput = false;
        while(validInput == false)
        {
        if(hitStay == 'h')
        {
            hit(deck);
            System.out.println("You drew a(n) " +  hand.get(hand.size()-1).toString() + ". your hand value is now " + getHandValue() + ".");
            if(getHandValue() == -1)
            {
                System.out.println("You Busted");
                validInput = true;
            }
            else
            {
            System.out.println("Your hand is " + hand.toString() + "with a value of " + getHandValue());
            System.out.print("would you" + name + "like to hit(h) or stay(s): ");
            hitStay = scanner.nextLine().charAt(0);
            }
            
        }
        else if (hitStay == 's') 
        {
            System.out.println("You stayed.");
            System.out.println("Your hand is " + hand.toString());
            validInput = true;    
        }
        else 
        {
            System.out.println("Not a valid input.");
        }
    }
}
    public void hit(Deck deck)
    {
        hand.add(deck.getTopCard());
        deck.discard(0);
    }

    public int getHandValue()
    {
        int handVal = 0;
        int aces = 0;
        for(Card card : this.hand)
        {
            handVal += card.getValue();
            if(card.getFace().equals("A"))
            {
                aces++;
            }

            while(handVal > 21 && aces > 0)
            {
                handVal -= 10;
                aces--;
            }
        }
            if(handVal > 21)
            {
                handVal = -1;
                System.out.println("You Busted!");
            }
        
            return handVal;
    }

    public void getStartingHand(Deck deck)
    {

        for(int i = 0; i < 2; i++)
        {
        hand.add(deck.getTopCard());
        deck.discard(0);
        }


    }

    public void placeBet(Scanner betScan)  
    {
        boolean validBet = false;
        double bet = 0;
        while(validBet == false)
        {   
            System.out.println("You have " + money + " dollars.");
            System.out.print("How much would you like to bet: ");
            bet = betScan.nextDouble();
            
            // betScan.close();
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
        
        this.bet = bet;  
        
    }

    public void returnBet(boolean win)
    {
        if(win)
        {
            money += this.bet*2;
            System.out.println("You won!");
            System.out.println("You now have " + money);

        }
        else
        {
            System.out.println("you Lost :(");
        }
    }

    


    public String getName()
    {
        return name;
    }

    public ArrayList<Card> getHand()
    {
        return this.hand;
    }
}
