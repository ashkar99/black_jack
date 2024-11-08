package model.rules;

/**
 * Creates concrete rules.
 */
public class RulesFactory {

  /**
   * Creates the rule to use for the dealer's hit behavior.
   *
   * @return The rule to use
   */
  public HitStrategy getHitRule() {
    return new BasicHitStrategy();
  }

  /**
   * Creates the rule to use for the dealer's hit behavior (Soft 17 edition).
   *
   * @return The rule to use
   */
  public SoftStrategy getSoftRule() {
    return new BasicHitStrategy();
  }

  /**
   * Crates the rule to use when starting a new game.
   *
   * @return The rule to use.
   */
  public NewGameStrategy getNewGameRule() {
    return new AmericanNewGameStrategy();
  }

  /**
   * Creates the rule to use for the dealer Wins On Tie.
   */
  public WinStrategy getWinRuleDealerWin() {
    return new DealerWinsOnTieStrategy();
  }

  /**
   * Creates the rule to use for the dealer Wins On Tie.
   */
  public WinStrategy getWinRulePlayerWin() {
    return new PlayerWinsOnTieStrategy();
  }

}