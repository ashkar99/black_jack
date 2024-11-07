import model.Card;
import model.Dealer;
import model.Deck;
import model.Player;
import model.rules.HitStrategy;
import model.rules.RulesFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SoftTest {

  private HitStrategy soft17HitStrategy;
  private Dealer dealer;
  private Deck deck;
  private Player player;

  @BeforeEach
  void setUp() {
    // Set up the test environment by creating instances of the required objects
    RulesFactory rulesFactory = new RulesFactory();
    dealer = new Dealer(rulesFactory);
    player = new Player();
    deck = new Deck();

    // Replace the hit strategy in the dealer with the Soft17 strategy
    soft17HitStrategy = rulesFactory.getHitRule();
    dealer = new Dealer(rulesFactory) {
      @Override
      public boolean doHit() {
        return soft17HitStrategy.doHit(this);
      }
    };
  }

  @Test
  void dealerShouldHitOnSoft17() {
    // Give dealer a "soft 17" hand: Ace and a 6
    dealer.dealCard(new Card(Card.Value.Ace, Card.Color.Hearts));
    dealer.dealCard(new Card(Card.Value.Six, Card.Color.Spades));

    // Assert that the dealer should take another card on soft 17
    assertTrue(soft17HitStrategy.doHit(dealer), "Dealer should hit on soft 17");
  }

  @Test
  void dealerShouldNotHitAbove17() {
    // Give dealer a hand that adds up to 18
    dealer.dealCard(new Card(Card.Value.Seven, Card.Color.Clubs));
    dealer.dealCard(new Card(Card.Value.Ace, Card.Color.Diamonds));

    // Assert that the dealer should not hit on 18
    assertFalse(soft17HitStrategy.doHit(dealer), "Dealer should not hit on 18");
  }

  @Test
  void dealerShouldNotHitOnHard17() {
    // Give dealer a "hard 17" hand (e.g., 10 and 7)
    dealer.dealCard(new Card(Card.Value.Ten, Card.Color.Clubs));
    dealer.dealCard(new Card(Card.Value.Seven, Card.Color.Diamonds));

    // Assert that the dealer should not take another card on hard 17
    assertFalse(soft17HitStrategy.doHit(dealer), "Dealer should not hit on hard 17");
  }
}
