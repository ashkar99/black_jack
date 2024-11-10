# BlackJack OO-Design
This document describes the current design. Note that some dependencies have been left out for readability reasons. For example there are a lot of dependencies to the Card class.

## Class Diagram
The application uses the model-view-controller (MVC) architectural pattern. The view is passive and gets called from the controller. 

```mermaid
classDiagram
class DealerWinsOnTieStrategy
class PlayerWinsOnTieStrategy
class BasicHitStrategy
class RulesFactory
class AmericanNewGameStrategy
class InternationalNewGameStrategy
class Deck
class Dealer
class Game
class Player
class Mutable
class Card
class EnglishView
class SwedishView
class App
class Choice

DealerWinsOnTieStrategy --|> WinStrategy
PlayerWinsOnTieStrategy --|> WinStrategy
BasicHitStrategy --|> HitStrategy
BasicHitStrategy --|> SoftStrategy
RulesFactory --> HitStrategy
RulesFactory --> NewGameStrategy
AmericanNewGameStrategy --|> NewGameStrategy
InternationalNewGameStrategy --|> NewGameStrategy
Deck --> "-cards" Mutable
Dealer --> RulesFactory
Dealer --> WinStrategy
Dealer --> HitStrategy
Dealer --> NewGameStrategy
Dealer --> "-deck" Deck
Game --> "-dealer" Dealer
Game --> "-player" Player
Mutable --|> Card
Color --|> Card
Value --|> Card
Player --> "-hand" Mutable
Player --|> ObserverImpl
Dealer --|> Player
Dealer --|> ObserverImpl
ObserverImpl --> ObserverInter
EnglishView --|> View
SwedishView --|> View
View --> Card
App --> Player
App --> view
App --> Game
Player --|> ObserverInter
Player --> View
Player --> Game


```

## Stand - Sequence Diagram
This is the detailed sequence diagram for the `Game.stand` method. This is what should be implemented.

![Stand Sequence diagram](img/stand_seq.jpg)
