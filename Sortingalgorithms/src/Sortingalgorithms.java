import java.io.*;
import java.util.ArrayList;

public class Sortingalgorithms {

	public static void main(String[] args) {
	
		//int a[] = {6,5,3,1,8,7,2,4};
		//int a[] = {4,3,2,10,12,1,5,6};
		int a[] = {29, 72, 98, 13, 87, 66, 52, 51, 36};
		int i = 0, j = 0,  n = 0, temp = 0;
		
		System.out.println("The original array is - ");
		for (i = 0; i <a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
		/* BUBBLE SORT
		for(n = a.length; n >= 1; n--)
		{
			for(i = 0; i < n-1; i++)
			{
				if(	a[i] > a[i+1])
				{
					temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
			
		}*/
		
		/* SELECTION SORT 
		for(n = 1; n < a.length; n++)
		{
			for(j = 0; j < n; j++)
			{
				if(a[j] > a[n])
				{
					temp = a[n];
					for(i = n; i > j; i--)
					{
						a[i] = a[i-1];
					}
					a[i] = temp;
					break;
				}
			}
		}*/
		
		int min = 0, pos = 0;
		for(i = 0; i < a.length; i++)
		{
			min = a[i];
			for(j = i+1; j < a.length; j++)
			{
				if(min > a[j])
				{
					min = a[j];
					pos = j;
				}
			}
			
			if(a[i] > min)
			{
				temp = a[i];
				a[i] = a[pos];
				a[pos] = temp;
			}
		}
		System.out.println("\nThe sorted array is - ");
		for (i = 0; i <a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
