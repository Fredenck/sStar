/*
 * Robot World
===========

Farmer John's storage is a very tall 
but narrow room that only one haybale can fit with respect to the width and 
the length. So the haybales can only be stored by stacking them starting 
from the floor. Initially the storage is empty and there are
haybales numbered starting from 1 in the warehouse. 

FJ has a robot equipped with one arm that can hold one haybale.
He controls the robot with two commands: ADD and REMOVE. 
With ADD command, the robot takes the next haybale in the warehouse and 
puts it on top of the haybales in the storage. When it receives REMOVE
command it takes the haybale on the top in the storage and carries it
to the barn. At the end of the week, FJ wants to learn the status of 
the storage in terms of the list of the haybales. 
Your program will help FJ to find out the list of the haybales.

For example, given the sequence of FJ's commands throughout the week,
the list of the haybales in the storage will be as follow:

Command		Storage
=======		=======
ADD		1
ADD		1 2
ADD		1 2 3
ADD		1 2 3 4
REMOVE		1 2 3
ADD		1 2 3 5
ADD		1 2 3 5 6
REMOVE		1 2 3 5
REMOVE		1 2 3 
REMOVE		1 2
ADD		1 2 7
ADD		1 2 7 8
REMOVE		1 2 7
REMOVE		1 2
REMOVE		1
REMOVE		
ADD		9
ADD		9 10
REMOVE		9
ADD		9 11

Finally, the haybales numbered 9 and 11 will remain in the storage.

PROBLEM NAME: robo

INPUT FORMAT:

* Line 1: A single integer: N <= 1,000,000, the number FJ's commands

* Lines 2..N+1: The sequence of FJ's commands

SAMPLE INPUT:

20
ADD
ADD
ADD
ADD
REMOVE
ADD
ADD
REMOVE
REMOVE 
REMOVE
ADD
ADD
REMOVE
REMOVE
REMOVE
REMOVE
ADD
ADD
REMOVE
ADD

OUTPUT FORMAT:

* Line 1: M, the number of haybales remained in the storage

* Lines 2..M+1: The list of haybales starting from bottom to top.

SAMPLE OUTPUT:

2
9
11
 */
package d6;

import java.util.*;

public class Robo {
	
	public static void main(String[] args) {
//		long startTime = System.nanoTime();
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		int totCom = sc.nextInt();
		int[] commands = new int[1000005];//1s and 0s, 1 for add, 0 for remove
		
		for (int i=0; i<totCom; i++){
			String cmd = sc.next();
			if (cmd.equals("ADD")){
				commands[i] = 1;
			}else if (cmd.equals("REMOVE")){
				commands[i] =  0;
			}
		}
		
		int haybale = 1;
		int ct = 0;
		while(ct<totCom){
			if (commands[ct] == 1){
				stack.add(haybale);
				haybale++;
			}else if (commands[ct] == 0){
				stack.pop();
			}
//			System.out.println(commands[ct]);
			ct++;
		}
		
		System.out.println(stack.size());
		for (int i=0; i<stack.size(); i++){
			System.out.println(stack.get(i));
		}
//		System.out.println("Took "+(System.nanoTime() - startTime) + " ns");
		sc.close();
	}
}