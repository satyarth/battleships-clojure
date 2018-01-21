# Battleships game

Game state:

* Ship positions
	* Think of format
* Player moves

Iterate by rerunning the game over the above lists everytime a player moves?

Then we have a gameloop which runs the game function on updated versions of the above lists everytime a player moves.

##############
#            #
#   00X00    # 0 - Player ship (full health)
#           *# X - Player ship (hit)
#        0   # * - Enemy shot (miss)
#  0000  X   # ~ - Sunk ship (player)
#        0   #
#          ~ #
#          ~ #
##############
