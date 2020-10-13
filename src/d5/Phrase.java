/*
 * Cow Phrasebook
==============

Ever the innovator, Farmer John is teaching cows to speak some
phrases in human language. He writes each new phrase the cows learn
in his phrase book, a total of M (1 <= M <= 10,000) so far.

When Farmer John is on a vacation, he can only communicate with his
cows by telephone. Being an active vacationer, FJ visits beaches
and fine restaurants when away from the farm. When he returns, his
answering machine is full of N (1 <= N <= 10,000) messages, many
potentially from the cows.

FJ vacations frugally and thus gets poor telephone service. Many
of the recorded messages cut off before they are complete. Help FJ
determine whether the recorded messages are from the phrasebook by
determining if the message begins a phrase.

You will be given the phrasebook and a set of texts of the recorded
messages. Count the number of recorded messages that are the beginning
(prefix) of a phrase from the phrase book.

Complete phrases are from 1 to 60 characters in length, each of which
is either a letter (upper or lower case), a period (.), comma (,),
question mark (?) or space. There are no leading spaces, trailing
spaces, or double spaces in a phrase. Comparisons are case-sensitive,
and a phrase is in fact, considered to be prefix of itself.

PROBLEM NAME: phrase

INPUT FORMAT:

* Line 1: Two space-separated integers, M and N

* Lines 2..M+1: Phrases from the phrase book, one per line.

* Lines M+2..M+N+1: Phrases spoken by cows, one per line.

SAMPLE INPUT:

3 4
I will not buy this record, it is scratched.
My hovercraft is full of eels.
Do you want to come back to my place? Bouncy, bouncy.
I will not buy this rec
My helicopter is
Do you want to come back
I will not buy this cat.

INPUT DETAILS:

Three input phrases (record, eels, bouncy); four query phrases
(buy, helicopter, come back, cat).

OUTPUT FORMAT:

* Line 1: A single integer that is the count of the number of messages
        that were proper prefixes of the phrasebook.

SAMPLE OUTPUT:

2

OUTPUT DETAILS:

The messages 'I will not buy this rec' and 'Do you want to come back'
are valid prefixes of the phrasebook.
 */
package d5;

import java.util.*;

public class Phrase {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		String[] phrasebook = new String[m];
		sc.nextLine();//to skip the \n
		for (int i=0; i<m; i++){
			phrasebook[i] = sc.nextLine();
		}
		
		int ct = 0;
		for (int i=0; i<n; i++){
			String posPhrase = sc.nextLine();
			for (String phrase:phrasebook){
				if (phrase.startsWith(posPhrase)){
					ct++;
					break;
				}
			}
		}
		System.out.println(ct);
		sc.close();
	}
}
