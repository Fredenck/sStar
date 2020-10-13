/*
 * Maze Solver
===========

In a given maze, your goal is to find a path from 'S' to 'F'. You 
can move only up, down, left and right directions. The path cannot 
pass through a position that is visited before.

You need to write a function/method that returns the path as a 
string.

For C++ users, the function is defined as follows:

string solve();

For Java users, the method is defined as follows:

String solve();

You can use additional functions/methods if you need.

PROBLEM NAME: maze

INPUT FORMAT:

* Line 1: Has two integers; the rows 3 <= N <= 100, and the 
columns 3 <= M <= 100 of the maze.

* Line 2..N+1: The maze composed of '#' and '.'. '#' means a wall 
where as '.' is empty spot. 'S' indicates the starting position 
and 'F' is the ending position.

SAMPLE INPUT:

5 7
#######
#F#...#
#.#.#.#
#...#S#
#######

OUTPUT FORMAT:

There is no output on screen but your function/method solve()
must return the path from 'S' to 'F' as a string. The path is 
composed of characters 'U' (up), 'D' (down), 'L' (left), 'R' 
(right). 

SAMPLE OUTPUT:

Nothing on screen but the returned path should be "UULLDDLLUU"
for this example.

CODE SUBMISSION GUIDELINES:

Be careful with the required structure when submitting. In C++, 
your code is normally similar to the following format:

#include <iostream>
#include ...
 :  :  :
using namespace std;

// === submit the code below  ===

// if you need more functions or global variables
string maze[1000];

anotherfunction()
{
    :  :  :
}

myrecursivefunction(...)
{
    :  :  :
}

// main function required by the problem
string solve ()
{
  // reading the input from file
   :  :  :
  // call your recursive function
  myrecursivefunction(...)
   :  :  :
  // you need to return the path you found
  return path;
}
// === submit the code above ===

int main()
{
  cout << solve() << endl;
}
You can write and test your code in your compiler as above but 
when submitting, you just need to submit the part after "using 
namespace std;" and above the main function.

In Java, your code will be similar to the one below:

import java.util.*;
import java.lang.*;
  :  :  :

class maze
{

  // === submit the code below  ===

  // if you need more methods or global variables
  String maze[]=new String[1000];

  anothermethod()
  {
      :  :  :
  }

  myrecursivemethod(...)
  {
      :  :  :
  }

  // main method required by the problem
  String solve ()
  {
    // reading the input
     :  :  :
    // call your recursive method
    myrecursivemethod(...)
     :  :  :
    // you need to return the path you found
    return path;
  }
  // === submit the code above ===

  public static void main (String[] args)
  {
    System.out.println(solve());
  }
}
You just need to submit the code portion after the class 
definition and before the main method.

 */
package d12;

import java.io.*;
import java.util.*;

public class Maze {
	
	static int R;
	static int C;
	static String str = "";
	static String[] maze = new String[1000];
	static int[][] used;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int sr = 0, sc = 0;
		for (int r=0; r<R; r++){
			maze[r] = br.readLine();
			for (int c=0; c<C; c++){
				if (maze[r].charAt(c)=='S'){
					sr = r;
					sc = c;
				}
			}
		}
		used = new int[R][C];
		path(maze,sr,sc);
		
		System.out.println(str);
//		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
	public static void path(String[] maze, int r, int c){
		int[] rDirections = {1, 0,-1, 0};
		int[] cDirections = {0, 1, 0,-1};
		char[] engDir = {'D', 'R', 'U', 'L'};
		used[r][c] = 1;
		
		for (int i=0; i<4; i++){
			//out of range
			if (r+rDirections[i]<0 || r+rDirections[i]>maze.length-1 || c+cDirections[i]<0 || c+cDirections[i]>maze[0].length()-1){
				 return;
			}
			//fin
			if (maze[r+rDirections[i]].charAt(c+cDirections[i])=='F'){
				str += engDir[i];
				return;
			}
			//next direction is wall
			if (maze[r+rDirections[i]].charAt(c+cDirections[i])=='#'){
				continue;
			}
			//do not go to past
			if (used[r+rDirections[i]][c+cDirections[i]]==1){
				continue;
			}
			str += engDir[i];
			path(maze,r+rDirections[i], c+cDirections[i]);			
		}
	}
}
