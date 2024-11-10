import model.Card;
import model.Dealer;
import model.Deck;
import model.Player;
import model.rules.RulesFactory;
import model.rules.SoftStrategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SoftTest {
  private SoftStrategy softRule;
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

    softRule = rulesFactory.getSoftRule();

  }

  @Test
  void dealerShouldHitOnSoft17() {
    // Give dealer a "soft 17" hand: Ace and a 6

    Card.Mutable aceOfHearts = new Card.Mutable(Card.Color.values()[0], Card.Value.values()[12]);
    Card.Mutable sixOfSpades = new Card.Mutable(Card.Color.values()[1], Card.Value.values()[4]);
    aceOfHearts.show(true);
    sixOfSpades.show(true);
    dealer.dealCard(aceOfHearts);
    dealer.dealCard(sixOfSpades);
    dealer.showHand();

    // Assert that the dealer should take another card on soft 17
    assertTrue(softRule.softEdition(dealer), "Dealer should hit on soft 17");
  }

  @Test
  void dealerShouldNotHitAbove17() {
    // Give dealer a hand that adds up to 18
    Card.Mutable sevenClubs = new Card.Mutable(Card.Color.values()[0], Card.Value.values()[5]);
    Card.Mutable ace = new Card.Mutable(Card.Color.values()[1], Card.Value.values()[12]);
    ace.show(true);
    sevenClubs.show(true);
    dealer.dealCard(sevenClubs);

    dealer.dealCard(ace);
    dealer.showHand();
    // Assert that the dealer should not hit on 18
    assertFalse(softRule.softEdition(dealer) , "Dealer should not hit on 18");
    System.out.println("tetstetette");
  }

  @Test
  void dealerShouldNotHitOnHard17() {
    // Give dealer a "hard 17" hand (e.g., 10 and 7)

    Card.Mutable ten = new Card.Mutable(Card.Color.values()[0], Card.Value.values()[8]);
    Card.Mutable seven = new Card.Mutable(Card.Color.values()[1], Card.Value.values()[5]);

    ten.show(true);
    seven.show(true);
    dealer.dealCard(ten);
    dealer.dealCard(seven);

    // Assert that the dealer should not take another card on hard 17
    assertFalse(softRule.softEdition(dealer), "Dealer should not hit on hard 17");
  }
}
