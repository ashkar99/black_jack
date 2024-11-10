package model.rules;

import java.util.ArrayList;

public class ObserverImpl {
  private ArrayList<ObserverInter> observer = new ArrayList<>();

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