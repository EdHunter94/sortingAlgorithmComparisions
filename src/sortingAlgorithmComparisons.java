import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class sortingAlgorithmComparisons
{
	static int ops;
	static int comps;
	static ArrayList<Integer> array = new ArrayList<Integer>();
	static ArrayList<Integer> sortedArray = new ArrayList<Integer>();
	static double start;
	static double end;

	static ArrayList<Integer> c = new ArrayList<Integer>();
	
	public static ArrayList<Integer> buildArray(String path, ArrayList<Integer> array)
	{
		Scanner in = null;
		
		try
		{
			in = new Scanner(new FileReader(path));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		while(in.hasNext())
		{
			array.add(Integer.parseInt(in.next()));
		}
		
		in.close();
		
		return array;
	}
	
	public static void printArray(ArrayList<Integer> arrayToPrint)
	{
		System.out.println(arrayToPrint.toString());
		System.out.println();
		System.out.println();
	}
	
	public static ArrayList<Integer> insertionSort(ArrayList<Integer> array)
	{
		int n = array.size();
		
		for(int i = 1; i < n; i++)
		{
			int val = array.get(i);
			ops++;
			int j = i-1;
			ops++;
			while(j >= 0 && val < array.get(j))
			{
				ops++;
				comps++;
				array.set(j+1, array.get(j));
				ops++;
				j--;
				ops++;
			}
			array.set(j+1, val);
			ops++;
		}
		
		return array;
	}
	
	public static ArrayList<Integer> mergeSort(ArrayList<Integer> array, int i, int j)
	{
		
		
		if(i >= j)
		{
			return array;
		}
		
		int m = (i + j)/2;
		ops++;
		
		mergeSort(array, i, m);
		mergeSort(array, m+1, j);
		
		return merge(array, i, m, j);
	}
	
	public static ArrayList<Integer> merge(ArrayList<Integer> array, int i, int m, int j)
	{
		int p = i;
		ops++;
		int q = m+1;
		ops++;
		int r = i;
		ops++;
		
		while(p <= m && q <= j)
		{
			ops += 2;
			if(array.get(p) <= array.get(q))
			{
				comps++;
				c.add(array.get(p));
				ops++;
				p++;
				ops++;
			}
			else
			{
				c.add(r, array.get(q));
				ops++;
				q++;
				ops++;
			}
			r++;
			ops++;
		}
		while(p <= m)
		{
			ops++;
			c.add(r, array.get(p));
			ops++;
			p++;
			ops++;
			r++;
			ops++;
		}
		while(q <= j)
		{
			ops++;
			c.add(r, array.get(q));
			ops++;
			q++;
			ops++;
			r++;
			ops++;
		}
		for(r = i; r <= j; r++)
		{
			array.set(r, c.get(r));
			ops++;
		}
		
		return array;
	}
	
	public static ArrayList<Integer> quickSort(ArrayList<Integer> a, int i, int j)
	{
		if(i < j)
		{
			int p = partition(a, i, j);
			ops++;
			quickSort(a, i, p-1);
			quickSort(a, p+1, j);
		}
		return a;
	}
	
	public static int partition(ArrayList<Integer> a, int i, int j)
	{
		int val = a.get(i);
		ops++;
		int h = i;
		ops++;
		for(int k = i; k <= j; k++)
		{
			if(a.get(k) < val)
			{
				comps++;
				h++;
				ops++;
				swap(a, h, k);
			}
		}
		swap(a, i, h);
		return h;
	}
	
	public static void swap(ArrayList<Integer> a, int h, int k)
	{
		int temp = a.get(h);
		ops++;
		a.set(h, a.get(k));
		ops++;
		a.set(k, temp);
		ops++;
	}
	
	public static void runInsertionSortTests()
	{
		ops = 0;
		comps = 0;
		array = buildArray("src/data/10_Random.txt", array);
		start = System.currentTimeMillis();
		sortedArray = insertionSort(array);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 10 random numbers by insertion sort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/10_Reverse.txt", array);
		start = System.currentTimeMillis();
		sortedArray = insertionSort(array);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 10 reversed numbers by insertion sort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/10_Sorted.txt", array);
		start = System.currentTimeMillis();
		sortedArray = insertionSort(array);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 10 sorted numbers by insertion sort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/100_Random.txt", array);
		start = System.currentTimeMillis();
		sortedArray = insertionSort(array);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 100 random numbers by insertion sort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/100_Reverse.txt", array);
		start = System.currentTimeMillis();
		sortedArray = insertionSort(array);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 100 reversed numbers by insertion sort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/100_Sorted.txt", array);
		start = System.currentTimeMillis();
		sortedArray = insertionSort(array);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 100 sorted numbers by insertion sort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/1000_Random.txt", array);
		start = System.currentTimeMillis();
		sortedArray = insertionSort(array);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 1000 random numbers by insertion sort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/1000_Reverse.txt", array);
		start = System.currentTimeMillis();
		sortedArray = insertionSort(array);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 1000 reversed numbers by insertion sort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/1000_Sorted.txt", array);
		start = System.currentTimeMillis();
		sortedArray = insertionSort(array);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 1000 sorted numbers by insertion sort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
	}
	
	public static void runMergeSortTests()
	{
		
		array.clear();
		c.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/10_Random.txt", array);
		start = System.currentTimeMillis();
		sortedArray = mergeSort(array, 0, array.size() - 1);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 10 random numbers by merge sort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		c.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/10_Reverse.txt", array);
		start = System.currentTimeMillis();
		sortedArray = mergeSort(array, 0, array.size() - 1);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 10 reversed numbers by merge sort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		c.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/10_Sorted.txt", array);
		start = System.currentTimeMillis();
		sortedArray = mergeSort(array, 0, array.size() - 1);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 10 sorted numbers by merge sort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		c.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/100_random.txt", array);
		start = System.currentTimeMillis();
		sortedArray = mergeSort(array, 0, array.size() - 1);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 100 random numbers by merge sort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		c.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/100_Reverse.txt", array);
		start = System.currentTimeMillis();
		sortedArray = mergeSort(array, 0, array.size() - 1);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 100 reversed numbers by merge sort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		c.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/100_Sorted.txt", array);
		start = System.currentTimeMillis();
		sortedArray = mergeSort(array, 0, array.size() - 1);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 100 sorted numbers by merge sort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		c.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/1000_Random.txt", array);
		start = System.currentTimeMillis();
		sortedArray = mergeSort(array, 0, array.size() - 1);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 1000 random numbers by merge sort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		c.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/1000_Reverse.txt", array);
		start = System.currentTimeMillis();
		sortedArray = mergeSort(array, 0, array.size() - 1);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 1000 reversed numbers by merge sort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		c.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/1000_Sorted.txt", array);
		start = System.currentTimeMillis();
		sortedArray = mergeSort(array, 0, array.size() - 1);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 1000 sorted numbers by merge sort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
	}
	
	public static void runQuickSortTests()
	{
		
		array.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/10_Random.txt", array);
		start = System.currentTimeMillis();
		sortedArray = quickSort(array, 0, array.size() -1);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 10 random numbers by quicksort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/10_Reverse.txt", array);
		start = System.currentTimeMillis();
		sortedArray = quickSort(array, 0, array.size() -1);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 10 reversed numbers by quicksort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/10_Sorted.txt", array);
		start = System.currentTimeMillis();
		sortedArray = quickSort(array, 0, array.size() -1);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 10 sorted numbers by quicksort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/100_Random.txt", array);
		start = System.currentTimeMillis();
		sortedArray = quickSort(array, 0, array.size() -1);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 100 random numbers by quicksort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/100_Reverse.txt", array);
		start = System.currentTimeMillis();
		sortedArray = quickSort(array, 0, array.size() -1);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 100 reversed numbers by quicksort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/100_Sorted.txt", array);
		start = System.currentTimeMillis();
		sortedArray = quickSort(array, 0, array.size() -1);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 100 sorted numbers by quicksort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/1000_Random.txt", array);
		start = System.currentTimeMillis();
		sortedArray = quickSort(array, 0, array.size() -1);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 1000 random numbers by quicksort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/1000_Reverse.txt", array);
		start = System.currentTimeMillis();
		sortedArray = quickSort(array, 0, array.size() -1);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 1000 reversed numbers by quicksort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
		
		array.clear();
		ops = 0;
		comps = 0;
		array = buildArray("src/data/1000_Sorted.txt", array);
		start = System.currentTimeMillis();
		sortedArray = quickSort(array, 0, array.size() -1);
		end = System.currentTimeMillis() - start;
		System.out.println("Sorted array from 1000 sorted numbers by quicksort in " + end + " seconds with " + ops +" operations and " + comps + " comparisions: ");
		printArray(sortedArray);
	}
	
	public static void main(String[] args)
	{
		runInsertionSortTests();
		runMergeSortTests();
		runQuickSortTests();
	}
}
