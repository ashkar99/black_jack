package controller;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import model.Game;
import model.ObserverInter;
import view.View;


/**
 * Scenario controller for playing the game.
 */
public class Player implements ObserverInter {
  private Game game;
  private View view;

   /**
   * player constructor.
   */
  public Player(Game game, View view) {
    this.game = game;
    this.view = view;
    this.game.addObserver(this);
  }
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

    int input = view.getInput();

    if (input == 'p') {
      game.newGame();
    } else if (input == 'h') {
      game.hit();
    } else if (input == 's') {
      game.stand();
    }

    return input != 'q';
  }

  @Override
  public void notifyPlayerNewCard() {
    view.displayNotificationPlayer(game.getPlayerHand());
  }


  @Override
  public void notifyDealerNewCard() {
    view.displayNotificationPlayer(game.getDealerHand());
    
  }
}