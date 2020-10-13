/*
 * Transformations
===============

A square pattern of size N x N (1 <= N <= 10) black and white
square tiles is transformed into another square pattern. Write 
a program that will recognize the minimum transformation that 
has been applied to the original pattern given the following 
list of possible transformations:

#1: 90 Degree Rotation: The pattern was rotated clockwise 90 degrees.

#2: 180 Degree Rotation: The pattern was rotated clockwise 180 degrees.

#3: 270 Degree Rotation: The pattern was rotated clockwise 270 degrees.

#4: Reflection: The pattern was reflected horizontally (turned into 
a mirror image of itself by reflecting around a vertical line in the 
middle of the image).

#5: Combination: The pattern was reflected horizontally and then 
subjected to one of the rotations (#1-#3).

#6: No Change: The original pattern was not changed.

#7: Invalid Transformation: The new pattern was not obtained by any 
of the above methods.

In the case that more than one transform could have been used, choose 
the one with the minimum number above.

PROGRAM NAME: transform

INPUT FORMAT:

* Line 1: A single integer, N

* Line 2..N+1: N lines of N characters (each either '@' or '-'); 
this is the square before transformation

* Line N+2..2*N+1: N lines of N characters (each either '@' or '-'); 
this is the square after transformation

SAMPLE INPUT:

3
@-@
---
@@-
@-@
@--
--@

OUTPUT FORMAT:

A single line containing the the number from 1 through 7 (described above) 
that categorizes the transformation required to change from the 'before' 
representation to the 'after' representation.

SAMPLE OUTPUT:

1
 */
package d14;
import java.io.*;

public class Transform {
	
	static char[][] orig;
	static char[][] res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		orig = new char[N][N];
		for (int r=0; r<N; r++){
			String line = br.readLine();
			for (int c=0; c<N; c++){
				orig[r][c] = line.charAt(c);
			}
		}
		res = new char[N][N];
		for (int r=0; r<N; r++){
			String line = br.readLine();
			for (int c=0; c<N; c++){
				res[r][c] = line.charAt(c);
			}
		}
		boolean found = false;
		
		//90 CW
		char[][] origC = clone(orig);
		rotate90(origC);
		if (matEquals(origC,res)&&!found){//90 CW
			System.out.println(1);
			found = true;
		}
		
		rotate90(origC);	
		if(matEquals(origC,res)&&!found){//180 CW
			System.out.println(2);
			found = true;	
		}
		
		rotate90(origC);	
		if(matEquals(origC,res)&&!found){//270 CW
			System.out.println(3);
			found = true;
		}
		
		origC = clone(orig);
		reflectHor(origC);
		if(matEquals(origC,res)&&!found){//reflect across vert axis
			System.out.println(4);
			found = true;
		}
		
		rotate90(origC);
		if(matEquals(origC,res)&&!found){//4 and 1
			System.out.println(5);
			found = true;
		}
		
		rotate90(origC);
		if(matEquals(origC,res)&&!found){//4 and 2
			System.out.println(5);
			found = true;
		}

		rotate90(origC);
		if(matEquals(origC,res)&&!found){//4 and 3
			System.out.println(5);
			found = true;
		}
		
		origC = clone(orig);
		if(matEquals(origC,res)&&!found){
			System.out.println(6);
			found = true;
		}
		if (!found){
			System.out.println(7);
		}		
		br.close();
	}
	public static char[][] clone(char[][] mat){
		char[][] cloned = new char[mat.length][mat[0].length];
		for(int i=0; i<mat.length; i++){
			  for(int j=0; j<mat[i].length; j++){
			    cloned[i][j]=mat[i][j];
			  }
		}
		return cloned;
	}
	public static void reflectHor(char[][] mat){
		for (int i = 0; i < mat.length; i++) {
		    for (int j = 0; j < mat[i].length / 2; j++) {
		    	char temp = mat[i][j];
		    	mat[i][j] = mat[i][mat.length - 1 - j];
		    	mat[i][mat.length - 1 -j] = temp;
		    }
		}
	}
	public static void rotate90(char[][] mat){
		int N = mat.length;
	    for (int i = 0; i < N / 2; i++){ 
	        for (int j = i; j < N - i - 1; j++) { 
	            char temp = mat[i][j]; 
	            mat[i][j] = mat[N - 1 - j][i]; 
	            mat[N - 1 - j][i] = mat[N - 1 - i][N - 1 - j]; 
	            mat[N - 1 - i][N - 1 - j] = mat[j][N - 1 - i]; 
	            mat[j][N - 1 - i] = temp; 
	        } 
	    } 
	}
	public static boolean matEquals(char[][] mat1, char[][] mat2){
		for (int r=0; r<mat1.length; r++){
			for (int c=0; c<mat1[0].length; c++){
				if (mat1[r][c]!=mat2[r][c]){
					return false;
				}
			}
		}
		return true;
	}
}
