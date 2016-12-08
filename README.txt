/**
 * Jake Mitchell (jmitch32), Koushul Ramjattun (kramjatt)
 * Pong_Mitchell_Ramjattun
 * 6 December 2016
 *
 * TAs: Jiageng Zhang, Dallis Polashenski
 */

=======================
// Project Structure //
=======================

Ball.java
Canvas.java
GameEngine.java
GameManager.java
InputManager.java
Paddle.java
PhysicsEngine.java
Pong.java

The PhysicsEngine has code for parabolic motion of the ball. But we commented it out since the motion was inconsistent. We are now using liner motion for the ball motion. All bounces work perfectly tough.

There is a countdown timer and the current level displayed on the top right corner.
The top left corner has the number of remaining lives and the current score of the user.

The paddle can be controlled using both the arrow keys and the mouse.

Push [space] to start the game (launch the ball).