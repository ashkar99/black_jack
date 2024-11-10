package view;

import model.Card;

/**
 * Encapsulates the generic view functionality for displaying game information.
 */
public interface View {

  /**
   * Displays a welcome message and game instructions.
   */
  void displayWelcomeMessage();

  /**
   * Reads and returns a single character input from the keyboard.
   *
   * @return the ASCII value of the pressed character.
   */
  int getInput();

  /**
   * Gets the player's choice based on keyboard input.
   *
   * @return the selected Choice, such as Play, Hit, Stand, or Quit.
   */
  Choice choices();

  /**
   * Displays the details of a single card.
   *
   * @param card The card to display.
   */
  void displayCard(model.Card card);

  /**
   * Displays the player's hand and score.
   *
   * @param hand  an Iterable collection representing the player's hand.
   * @param score the player's current score.
   */
  void displayPlayerHand(Iterable<model.Card> hand, int score);

  /**
   * Displays the dealer's hand and score.
   *
   * @param hand  an Iterable collection representing the dealer's hand.
   * @param score the dealer's current score.
   */
  void displayDealerHand(Iterable<model.Card> hand, int score);

  /**
   * Displays the game outcome, indicating if the dealer won.
   *
   * @param dealerIsWinner True if the dealer won, otherwise false.
   */
  void displayGameOver(boolean dealerIsWinner);

  /**
   * Displays a notification showing the player's most recent card.
   *
   * @param playerHand an Iterable collection of the player's hand.
   */
  void displayNotificationPlayer(Iterable<Card> playerHand);

  /**
   * Displays a notification showing the dealer's most recent card.
   *
   * @param playerHand an Iterable collection of the dealer's hand.
   */
  void displayNotificationDealer(Iterable<Card> playerHand);
}
