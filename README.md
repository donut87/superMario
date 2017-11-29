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
