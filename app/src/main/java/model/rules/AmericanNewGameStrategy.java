package model.rules;

import model.Dealer;
import model.Deck;
import model.Player;

class AmericanNewGameStrategy implements NewGameStrategy {

  public boolean newGame(Deck deck, Dealer dealer, Player player) {

    for (int i = 0; i < 4; i++) {
      if (i % 2 != 0) {
        if (i == 3) {
          dealer.dealCard(dealer, false);
        } else {
          dealer.dealCard(dealer, true);
        }
      } else {
        dealer.dealCard(player, true);
      }
    }

    return true;
  }
}