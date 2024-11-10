package model;

/**
 * Observer interface.
 */
public interface ObserverInter {

  /**
   * NOtify player that he took new card.
   */
  public void notifyPlayerNewCard();

  /**
   * NOtify dealer that he took new card.
   */
  public void notifyDealerNewCard();
}
