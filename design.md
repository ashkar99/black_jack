# BlackJack OO-Design
This document describes the current design. Note that some dependencies have been left out for readability reasons. For example there are a lot of dependencies to the Card class.

## Class Diagram
The application uses the model-view-controller (MVC) architectural pattern. The view is passive and gets called from the controller. 

@startuml
'Command to disable symbols on access modifiers
skinparam classAttributeIconSize 0
skinparam linetype ortho
package model.rules {
    class DealerWinsOnTieStrategy
    class PlayerWinsOnTieStrategy
    PlayerWinsOnTieStrategy ..|> WinStrategy
    DealerWinsOnTieStrategy ..|> WinStrategy
    interface WinStrategy <<interface>>
    interface SoftStrategy <<interface>>
    class BasicHitStrategy
    interface HitStrategy <<interface>>
    BasicHitStrategy ..|> HitStrategy
    BasicHitStrategy ..|> SoftStrategy
    class RulesFactory
    RulesFactory ..> HitStrategy
    RulesFactory ..> NewGameStrategy
    class AmericanNewGameStategy
    class InternationalNewGameStrategy
    interface NewGameStrategy <<interface>>
    NewGameStrategy <|.. AmericanNewGameStategy
    NewGameStrategy <|.. InternationalNewGameStrategy
    
}
package model {
    class Deck
    class Dealer
    class Game
    class Player
    class Mutable
    class Card
    interface ObserverInter <<interface>> 
    abstract ObserverImpl <<abstract>> 
    ObserverImpl --> ObserverInter
    Player --^ ObserverImpl
    Dealer ..> RulesFactory
    Dealer --> WinStrategy
    Dealer --> HitStrategy
    Dealer --> NewGameStrategy
    Dealer ..> Player
    Dealer --^ Player
    Dealer --> "-deck" Deck
    Deck --> "-cards" Mutable
    Game --> "-dealer" Dealer
    Game --> "-player" Player
    together {
    Mutable --+ Card
    Mutable --^ Card
    note left of Mutable
        (from Card)
    end note
    enum Color <<enumeration>>
    enum Value <<enumeration>>
    Color --+ Card
    Value --+ Card
    }
    Player --> "-hand" Mutable
}
package view {
    enum Choice
    class EnglishView
    class SwedishView
    interface View <<interface>>
    EnglishView ..|> View
    SwedishView ..|> View
    View ..> Card
}
package controller {
    class App
    class Player
    App --> Player
    App --> view
    App --> Game
    Player ..|> ObserverInter
    Player --> View
    Player --> Game
}

' Hides the circle symbols in plantUML
hide interface circle
hide class circle
hide enum circle
@enduml

## Stand - Sequence Diagram
This is the detailed sequence diagram for the `Game.stand` method. This is what should be implemented.

![Stand Sequence diagram](img/stand_seq.jpg)
