package model.rules;

import model.Player;

/**
 * With this strategy dealer win om tie.
 */
public class DealerWinsOnTieStrategy implements WinStrategy {
  @Override
  public boolean isDealerWinner(Player dealer, Player player) {
    int dealerScore = dealer.calcScore();
    int playerScore = player.calcScore();

    if (playerScore > 21) {
      return true; // Player busts, dealer wins
    }
    if (dealerScore > playerScore) {
      return false; // Dealer busts, player wins
    }
    return dealerScore >= playerScore; // Dealer wins on tie
  }
}