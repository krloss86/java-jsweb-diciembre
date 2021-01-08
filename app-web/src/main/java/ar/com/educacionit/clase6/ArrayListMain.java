package ar.com.educacionit.clase6;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListMain {

	public static void main(String[] args) {
		
		//vector
		int[] vectoInt = new int[3];
		vectoInt[0] = 1;
		vectoInt[1] = 10;
		vectoInt[2] = -5;
		
		//
		System.out.println(Arrays.toString(vectoInt));
		
		//de a uno iterando
		for(int i=0;i<vectoInt.length;i++) {
			int aux = vectoInt[i];
			System.out.println(aux);
		}
		
		for( int aux : vectoInt ) {
			System.out.println(aux);
		}
		
		int ie = 2;
		int[] vectoIntAux = new int[2];
		int j=0;
		for(int i=0;i<vectoInt.length;i++) {
			if(i!=ie) {
				int aux = vectoInt[i];
				vectoIntAux[j] = aux;
			}
			j++;
		}
		vectoInt =vectoIntAux;
		
		//arraylist
		ArrayList<Integer> arrayInteger = new ArrayList<Integer>();
		arrayInteger.add(1);
		arrayInteger.add(10);
		arrayInteger.add(-5);
		
		//recorre 
		for(Integer aux : arrayInteger) {
			System.err.println(aux);
		}
		
		arrayInteger.remove(2);
	}

}
