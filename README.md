# adventure-Coffee

  -------------------------------------------------------------------------------------------------
  -------------------------------------------------------------------------------------------------
  
  Grade recieved: 103% 
    + Bonus: added functionality of save-game.
  
  -------------------------------------------------------------------------------------------------
  -------------------------------------------------------------------------------------------------
  
COMP1405 Assignment #4/5 Specifications
1. THE GAME
  A (human) player will enter the game world (that already
  contains other players and things). The goal of the game is for the (human) player to retrieve
  something from the game world and exit with it (it might be another player or a thing).
  The game world will be read from a le that species each room in the world. Each room will
  have a list of contents (things), players, and exits (doors to other rooms).

2. DETAILS
  Your game must have the following classes: World, Room, Player and Thing.
  World: 
    Your world class will need to read the game world from a le. It will need to keep track
    of the entrance to the world so that the human player can enter it. Your world class should also be
    able to save a game in progress. That is, save the state of the game so that it can be loaded later
    and continued (from the same point in the game). Your world will need to hold your collection of
    rooms in some way. (You can use either an array or a linked-structure.)
  Room: 
    A room is where everything happens. A room contains players, things and doors to other
    rooms. A player should be able to take things from a room and leave things in a room. Doorways
    between rooms can be simple doors (that can always be opened), be locked (requiring a key to
    be found rst) or one-way (you can go from room A to B, but not from B to A). A basic room
    will have 1-4 adjacent rooms. You do not need to consider a room having more than one doorway
    (adjacent room) in any given direction.
  Player: 
    Each players should have a specic role in the game. There will be several players in the
    game including a human players and at least N more players. Each team member will contribute
    a specic computer controlled player that have different behaviours.
    For the human player, we will North, South, East, and West to denote directions. N, S, E and
    W will be sufficient.
  Thing: 
    There will be several things in the game. Examples might food, treasure, radioactive
    material, keys, locked boxes, etc. There needs to be at least N different things that have different
    behaviour.
    
3. FILE FORMAT
  The file format for the world will be as follows:
  
      total number of rooms
      room number
      room name
      rooms adjacent to room (comma separated)
      players in room (comma separated)
      things in the room (comma sepatated)
      room number
      room name
      rooms adjacent to room (comma separated)
      players in room (comma separated)
      ...
  For example, if there are 4 rooms in the world (2x2 grid) then the file might look like (# denotes
  a comment and will not be part of the actual file; I have included it for clarity of the file)
  
        4                           # 4 rooms in total
        1                           # room 1
        Entrance                    # room 1 is the Entrance
        2, 3                        # you can go to room 2 and 3 from room 1
        0, 1, 0, 1                  # there is one player1 and one player3 in the room
        1, 1, 0, 0, 0               # there is one thing0 and thing1 in the room
        2                           # room 2
        CS Lab                      # room 2 is the CS lab
        1, 4                        # you can go to room 1 and 4 from room 2
        0, 0, 0, 0                  # there are no players in the room
        0, 1, 0, 0, 0               # there is one thing1 in the room
        3                           # room 3
        Washroom                    # The washroom
        1, 4                        # you can go to room 1 and 4 from room 3
        0, 0, 0, 0                  # no player is in the washroom
        0, 0, 0, 0, 1               # there is one thing4 in the room
        4                           # room 4
        2, 3                        # you can go to room 2 and 3 from room 4
        1, 0, 0, 0                  # there is one player1 in the room
        0, 0, 1, 0, 1               # there is one thing2 and thing4 in the room
        
        
  For the players and things, I assume you have 4 different player classes and call them for
  simplicity player0, player1, player2, player3 in the comments above. In your program, you will use
  your own classes. Same for the things. Here, thing2 is Rodney is found in room 4 of the game.
  You can store the game using a 2d array or using a linked structure. Any le that we give you
  will be given as above and you can assume that the world looks like a rectangle. The rst room
  (#1) is the top-left room. The rooms are then given (in order of room number) and will be given
  as the rows. For example, the world of the le above corresponds to a world that looks like
  1 2
  3 4
  You will need to determine the shape (number of rows and columns) based on which rooms
  room # 1 is adjacent to.
  
  -------------------------------------------------------------------------------------------------
  -------------------------------------------------------------------------------------------------
  
Assignment 4/5 -- Project Rubric
================================

This rubric assumes that you have 4 team members. Things ending with a number correspond to work done by team a team member (which we arbitrarily numbeer 1-4). Anything ending with 0 is a team effort.

Assignment 4/5 [40 marks]
-------------------------

All games must accept the input "h" to ask for help. This should let the user know which commands that they can enter to play the game.

Team
__/10 : human player can navigate the world (look around, pick things up, etc)
__/5 : UML diagram or PDF drawing of all classes in submission
__/5 : class design (abstract/concrete/interface) 
__/2 : file i/o (read world initial state to begin game)
__/3 : game play (user friendly, easy to follow, etc)


Individual
__/10 : Player class P1 - player does something non-trivial/unique
__/10 : Player class P2 - player does something non-trivial/unique
__/10 : Player class P3 - player does something non-trivial/unique
__/10 : Player class P4 - player does something non-trivial/unique

__/5 : Thing class T1 - thing does something non-trivial/unique
__/5 : Thing class T2 - thing does something non-trivial/unique
__/5 : Thing class T3 - thing does something non-trivial/unique
__/5 : Thing class T4 - thing does something non-trivial/unique

Extras (individual)
__/ : file i/o (save game to be continued later)
__/ : other1
__/ : other2
__/ : other3
__/ : other4
