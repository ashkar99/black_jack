package model.rules;

import model.Player;

/*
 * Rulles for dealer or player winner on tie.
 */
public interface WinStrategy {

  /**
   * Determines if the dealer is the winner based on the implemented strategy.
   *
   * @param dealer The dealer player.
   * @param player The human player.
   * @return True if the dealer wins, otherwise false.
   */
  boolean isDealerWinner(Player dealer, Player player);
}