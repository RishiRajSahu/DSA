package ds.heap;


public class MaxHeap
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] ia = { -1, 1, 10, 5, 3, 4, 7, 6, 9, 8 };
		buildHeap(ia, ia.length);
		
	}
	
	public static void buildHeap(int a[], int length) {
	    for(int i = length/2; i > 0; i--) {
	        heapify(a, i);
    	    for(int v : a) {
    	        System.out.print(v + " ");
    	    }
    	        System.out.println( );
	    }
	}
	
	public static void heapify(int a[], int i) {
	    int j = 2*i; int item = a[i];
	    while(j < a.length) {
	        if(j + 1 < a.length && a[j] < a[j+1]) {
	            j = j+1;
	        }
	        if(item > a[j])
	            break;
	        a[j/2] = a[j];
	        j = 2*j;
	    }
	    a[j/2] = item;
	    return ;
	}
}
