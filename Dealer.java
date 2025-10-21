public class Dealer extends Player
{
    public Dealer()
    {
        super("Robert");
    }

    public boolean isSoft()
    {
        int handVal = 0;
        int aces = 0;
        for (Card card : this.getHand())
        {
            handVal += card.getValue();
            if(card.getFace().equals("A"))
            {
                aces++;
            }

            while ( handVal > 21  && aces > 0)
            {
                return true;
            }

        }
        return false;
    }

    public void dealerPlayTurn(Deck deck)
    {
        int handVal = this.getHandValue();
        if ( handVal == 21)
        {
            System.out.println("\nThe dealer has 21, better luck next time.");
        }
        else if (handVal >= 17)
        {
            if (isSoft())
            {
                hit(deck);
            }
        }
        else if (handVal < 17)
        {
            hit(deck);
        }
        System.out.println("dealer hand: " + this.getHand());

    }

    
}