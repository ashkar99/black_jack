package model;

import java.util.ArrayList;

/**
 * Implantation of observer-pettern.
 */
public class ObserverImpl {
  private ArrayList<ObserverInter> observer = new ArrayList<>();

  /**
   * Adding obeerver into list.
   */
  public void addObserver(ObserverInter o) {
    observer.add(o);
  }

  /**
   * player notify observer.
   */
  public void notifyObserversPlayer() {
    for (ObserverInter o : observer) {
      o.notifyPlayerNewCard();
    }
  }

  /**
   * dealer notify observer.
   */
  public void notifyObserversDelaer() {
    for (ObserverInter o : observer) {
      o.notifyDealerNewCard();
    }
  }

}