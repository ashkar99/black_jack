package view;

import model.Card;

/**
 * Implements an English console view for a Blackjack game.
 */
public class EnglishView implements View {

  /**
   * Clears the console and displays a welcome message with game instructions.
   */
  public void displayWelcomeMessage() {
    for (int i = 0; i < 50; i++) {
      System.out.print("\n");
    }
    System.out.println("Hello Black Jack World");
    System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
  }

  /**
   * Reads a single character input from the keyboard, ignoring newline and
   * carriage return.
   *
   * @return the ASCII value of the pressed character or 0 if an error occurs.
   */
  public int getInput() {
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }
      return c;
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return 0;
    }
  }

  /**
   * Determines the game choice based on user input.
   *
   * @return the selected Choice (Play, Hit, Stand, Quit) or null if invalid.
   */
  public Choice choices() {
    int input = getInput();
    if (input == 'p') {
      return Choice.Play;
    }
    if (input == 'h') {
      return Choice.Hit;
    }
    if (input == 's') {
      return Choice.Stand;
    }
    if (input == 'q') {
      return Choice.Quit;
    }
    return null;
  }

  /**
   * Displays a single card with its value and color.
   *
   * @param card the card to display.
   */
  public void displayCard(model.Card card) {
    System.out.println("" + card.getValue() + " of " + card.getColor());
  }

  /**
   * Displays the player's hand and current score.
   *
   * @param hand  the player's hand as an Iterable of Cards.
   * @param score the current score of the player.
   */
  public void displayPlayerHand(Iterable<model.Card> hand, int score) {
    displayHand("Player", hand, score);
  }

  /**
   * Displays the dealer's hand and current score.
   *
   * @param hand  the dealer's hand as an Iterable of Cards.
   * @param score the current score of the dealer.
   */
  public void displayDealerHand(Iterable<model.Card> hand, int score) {
    displayHand("Dealer", hand, score);
  }

  /**
   * Displays a hand of cards for a specified player (dealer or player) with their
   * score.
   *
   * @param name  the name of the player (e.g., "Player" or "Dealer").
   * @param hand  the hand of cards as an Iterable of Cards.
   * @param score the score of the player.
   */
  private void displayHand(String name, Iterable<model.Card> hand, int score) {
    System.out.println(name + " Has: ");
    for (model.Card c : hand) {
      displayCard(c);
    }
    System.out.println("Score: " + score);
    System.out.println("");
  }

  /**
   * Displays the game result at the end, indicating if the dealer or player has
   * won.
   *
   * @param dealerIsWinner True if the dealer won, otherwise false.
   */
  public void displayGameOver(boolean dealerIsWinner) {
    System.out.println("GameOver: ");
    if (dealerIsWinner) {
      System.out.println("Dealer Won!");
    } else {
      System.out.println("You Won!");
    }
  }

  /**
   * Displays the last card dealt to the player.
   *
   * @param hand the player's hand as an Iterable of Cards.
   */
  private void disPlayerCard(Iterable<Card> hand) {
    model.Card c = null;
    for (model.Card card : hand) {
      c = card;
    }
    System.out.println("Card value: " + c.getValue() + c.getColor());
    pause();
  }

  /**
   * Displays the last card dealt to the dealer.
   *
   * @param hand the dealer's hand as an Iterable of Cards.
   */
  private void disDealerCard(Iterable<Card> hand) {
    model.Card c = null;
    for (model.Card card : hand) {
      c = card;
    }
    System.out.println("Card value: " + c.getValue() + c.getColor());
    pause();
  }

  /**
   * Pauses the execution for 1.5 seconds to allow the user to view recent
   * changes.
   */
  private void pause() {
    try {
      System.out.println("");
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * Notifies the user of the player's recent card by displaying it.
   *
   * @param hand the player's hand as an Iterable of Cards.
   */
  public void displayNotificationPlayer(Iterable<Card> hand) {
    disPlayerCard(hand);
  }

  /**
   * Notifies the user of the dealer's recent card by displaying it.
   *
   * @param hand the dealer's hand as an Iterable of Cards.
   */
  public void displayNotificationDealer(Iterable<Card> hand) {
    disDealerCard(hand);
  }
}
