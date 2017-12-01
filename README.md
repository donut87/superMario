# Super Mario kata

This repository startet as a clone of https://github.com/Uli-Armbruster/katas-SuperMario.

For several reasons I have decided to cut it loose and make it something independent.

The goal is to have a SOLID approach to implementing some requirements concerning a game with a well known plumber as the main character

### Requirements

#### Iteration 1
- When Super Mario starts, he is small
- When Small Mario is hit by an enemy, he dies and cannot be played with anymore

#### Iteration 2
- When Small Mario finds a Mushroom, he grows
- When Mario with a Mushroom finds another Mushroom, he stays in the same state
- When Mario with a Mushroom is hit by an enemy, he becomes a Small Mario

#### Iteration 3
- When Mario starts, he has 3 lives
- When Mario dies, he loses a live
- When Mario has used all lives, he dies and cannot be played with anymore

#### Iteration 4
- When Mario finds a live, his live count increases
- When a dead Mario finds a live, he can be played with again

#### Iteration 5
- When Mario finds a Fire Flower, he becomes Mario with Fire Flower
- When Mario with Fire Flower is hit by an enemy, he becomes Mario with Mushroom
- When Mario with Fire Flower finds a Mushroom, he stays Mario with Fire Flower

#### Iteration 6
- When Mario finds an Ice Flower, he becomes Mario with Ice Flower
- When Mario with Ice Flower is hit by an enemy, he becomes Mario with Mushroom
- When Mario with Ice Flower finds a Mushroom, he stays Mario with Ice Flower
- When Mario with Ice Flower finds a Fire Flower, he becomes Mario with Fire Flower
- When Mario with Ice Flower gets order to shoot, he shoots Ice
- When Mario with Fire Flower gets order to shoot, he shoots Fire
- Every other Mario does nothing, when ordered to shoot

#### Iteration 7
- When Mario finds a star, then he loses this star after 1 second
- When Mario owns a star and is hit by an enemy, nothing happens to him
- When Small Mario with a star finds Mushroom or a flower, he then grows without losing the star

#### Iteration 8
- When Mario finds a Yoshi, the his size (Small, Mushroom, Fire- or Iceflower) does not change
- When Mario with Yoshi is hit by an enemy, then he loses Yoshi. Otherwise nothing changes
- When Small Mario with Yoshi finds Mushroom or a flower, he then grows without losing the star

#### Iteration 9
- When Mario finds points, these points sum up in an account
- When Marios account contains 100 Points, then Mario gets a new live and his points account is set to 0
- When Mario has no more lives left and dies, he then loses all his points

#### Iteration 10
- There has to be game mode 'Infinity', where Mario has an endless number of lives and starts each one as small Mario

#### Iteration 11
- There has to be a game mode 'BigWorld', where Mario a only has two lives, but starts as Mario with Mushroom for each live

#### Iteration 12
- There has to be a game mode 'TabulaRasa', where Mario has 3 lives and
  - starts as small Mario
  - after that starts as Mario with Mushroom
  - with his last live starts as Mario with Fireflower
  - when he finds a live, he gets two extra lives as Mario with Mushroom

#### Taking it even further
- After 3 lost lives, Mario gets another 3 lives and a counter is increased
- This counter tracks how often Mario has died and had to be reanimated
