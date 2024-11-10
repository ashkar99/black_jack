package controller;

import model.Game;
import view.Choice;
import view.View;


/**
 * Scenario controller for playing the game.
 */
public class Player {

  /**
   * Runs the play use case.

   * @param game The game state.
   * @param view The view to use.
   * @return True as long as the game should continue.
   */
  public boolean play(Game game, View view) {
    view.displayWelcomeMessage();

    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore());

    if (game.isGameOver()) {
      view.displayGameOver(game.isDealerWinner());
    }

    Choice c = view.choices();  // get user choice.
    if (c == Choice.Play) {
      game.newGame();
    }
    if (c == Choice.Hit) {
      game.hit();
    }
    if (c == Choice.Stand) {
      game.stand();
    }

    return c != Choice.Quit;
  }
}