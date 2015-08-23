package programming.others;

import java.util.HashSet;

public class LRU {
	int lruBuffer[] ;//= new int[max_cache_size];
	int lru[];// = new int[max_cache_size];

	public LRU() {
		int pages[] = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 6, 3, 2, 1, 2, 0 };
		int max_cache_size = 3;
		//int pages[] = {1, 2, 3, 1, 4, 5};
		//int max_cache_size = 4;
		int misses = findMisses(pages, max_cache_size);
		System.out.println();
		System.out.println(misses);
	}

	private int findMisses(int[] pages, int max_cache_size) {
		HashSet<Integer> bucket = new HashSet<Integer>();
		lruBuffer = new int[max_cache_size];
		lru = new int[max_cache_size];

		int miss = 0;
		int initial = 0;

		for (int i = 0; i < pages.length; i++) {
			//System.out.println();
			//System.out.println("insert - " + pages[i]);
			if (bucket.contains(pages[i]) && initial == max_cache_size ) {
				lruBuffer = updateLruBuffer(lruBuffer, pages[i]);
				//printLru();
				//printLruBuffer();
				
			} else if (!bucket.contains(pages[i]) && initial == max_cache_size ) {
				miss++;
				int remove = lruBuffer[0];
				for (int j = 0; j < max_cache_size; j++) {
					if (lru[j] == remove) {
						lru[j] = pages[i];
						bucket.add(pages[i]);
						lruBuffer = insertInBuffer(lruBuffer, pages[i]);
						break;
					}
				}
				bucket.remove(remove);
				//printLru();
				//printLruBuffer();

			} else if (bucket.contains(pages[i]) && initial < max_cache_size) {
				// this case I missed initially which is when cache is not filled completely and
				// element gets repeated
				for (int k = 1; k <= initial; k++) {
					lruBuffer[k - 1] = lruBuffer[k];
				}
				lruBuffer[initial-1] = pages[i];
				printLru();
				printLruBuffer();
			} else if (initial < max_cache_size) {
				miss++;
				lru[initial] = pages[i];
				lruBuffer[initial] = pages[i];
				bucket.add(pages[i]);
				initial++;
				//printLru();
				//printLruBuffer();
			}
		}
		return miss;
	}

	private int[] updateLruBuffer(int[] lruBuffer, int element) {
		int loc = 0;
		for (loc = 0; loc < lruBuffer.length; loc++) {
			if (lruBuffer[loc] == element) {
				break;
			}
		}
		for (int i = loc + 1; i < lruBuffer.length; i++) {
			lruBuffer[i - 1] = lruBuffer[i];
		}
		lruBuffer[lruBuffer.length - 1] = element;
		return lruBuffer;
	}

	private int[] insertInBuffer(int[] lruBuffer, int element) {
		for (int i = 1; i < lruBuffer.length; i++) {
			lruBuffer[i - 1] = lruBuffer[i];
		}
		lruBuffer[lruBuffer.length - 1] = element;
		return lruBuffer;
	}

	public static void main(String args[]) {
		new LRU();
	}
	
	private void printLru() {
		System.out.println();
		for (int i = 0; i < lru.length; i++) {
			System.out.print(lru[i]  + " ");
		}
		
	}
	
	private void printLruBuffer() {
		System.out.println();
		for (int i = 0; i < lruBuffer.length; i++) {
			System.out.print(lruBuffer[i] + " ");
		}
	}
}
