# java-exercice

## Context
Little Java exercice to control the Manage a bunch of mowers on a rectangular yard.

We assume the yard can be see as a two dimensions cartesian coordinate system, and that the position a mower can determined by the those coordinates and the cardinal direction *{N, W, E, S}* where N represents the NORTH and so on.

Instructions are given in a file that looks like the following lines

```
5 5
1 2 N
GAGAGAGAA
3 3 E
AADAADADDA
```
The first line is the coordinates of the highest point of the yard; we assume the smallest coordinates are (0, 0).

After that instructions are given to the mower in two lines. the first is the initial coordinate of the mower and the second a list of instructions that could tell the go forward, turn left or turn rigth.


