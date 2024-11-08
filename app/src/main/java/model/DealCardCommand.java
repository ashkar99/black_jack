package model;

/**
 * Concrete Command for dealing a card.
 *  
 * */ 
public class DealCardCommand implements Command {
  private Deck deck;
  private Player player;
  private boolean showCard;

  public DealCardCommand(Deck deck, Player player, boolean showCard) {
      this.deck = deck;
      this.player = player;
      this.showCard = showCard;
  }

  @Override
  public void execute() {
    Card.Mutable c  = deck.getCard();
    c.show(showCard);
      player.dealCard(c);
  }
}
