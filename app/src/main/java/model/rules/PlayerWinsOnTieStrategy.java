package model.rules;

import model.Player;

/**
 * With this strategy player win om tie.
 */
public class PlayerWinsOnTieStrategy implements WinStrategy {
  @Override
  public boolean isDealerWinner(Player dealer, Player player) {
    int dealerScore = dealer.calcScore();
    int playerScore = player.calcScore();

    if (playerScore > 21) {
      return true; // Player busts, dealer wins
    }
    if (dealerScore > 21) {
      return false; // Dealer busts, player wins
    }
    return dealerScore > playerScore; // Player wins on tie
  }
}