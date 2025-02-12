# A3

Assignment 3

## Members
Zyad Dabbagh zd222ay
Sadek Alashkar sa225ad


## How to Play Blackjack

This guide explains the rules of Blackjack and how to play it. Win conditions vary depending on the strategy chosen.

### Objective

Get as close to 21 points as possible without going over (busting). You aim to have a higher total than the dealer without exceeding 21.

### Card Values

- Number cards are worth their face value.
- Face cards (King, Queen, Jack) are worth 10 points.
- Aces can be worth 1 or 11 points, depending on which is more favorable.

### Game Start

- The player and the dealer are dealt two cards. The dealer shows one card face up and keeps the other face down.
- Player review their cards and decide on their next move.

### Player Choices

- **Play**: Start new game.
- **Hit**: Draw another card to get closer to 21.
- **Stand**: Keep your current hand and end your turn.
- **Quit**: Quit the game.

### Dealer’s Turn (Soft 17 Rule)

- After player have finished their turns, the dealer reveals their hidden card.
- The dealer must **hit until reaching at least 17**.
- If the dealer has a "soft 17" (a hand with an Ace counted as 11, e.g., Ace + 6), the dealer **must hit** and draw another card.

### Winning the Game

- If your hand is closer to 21 than the dealer’s without going over, you win.
- If you bust (exceed 21), you lose immediately.
- If the dealer busts, the player win.
- **If there is a tie**:
  - With **DealerWinsOnTieStrategy**, the dealer wins the tie.
  - With **PlayerWinsOnTieStrategy**, the player wins the tie.
