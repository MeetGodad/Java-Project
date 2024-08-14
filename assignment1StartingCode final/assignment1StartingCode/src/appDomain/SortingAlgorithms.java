package appDomain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ShapeManager.java
 *
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.1 Class Description: This class contents different types of sorting algorithm
 */
public class SortingAlgorithms {
   /*The following method is the bubbleSort Algorithm,Its time complexity is O(n^2)*/
	public static class BubbleSort {
	    public static void sort(shapes.Shape[] arr, Comparator<shapes.Shape> comparator) {
	        int n = arr.length;
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = 0; j < n - 1 - i; j++) {
	                if (comparator.compare(arr[j], arr[j + 1]) < 0) {
	                    swap(arr, j, j + 1);
	                }
	            }
	        }
	    }

	    private static void swap(shapes.Shape[] arr, int i, int j) {
	        shapes.Shape temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }
	}

	/*	
	 * */
	
	   /*The following method is the SelectionSort Algorithm,Its time complexity is O(n^2)*/
	public static class SelectionSort {

        public static <T extends Comparable<T>> void sort(T[] arr) {
            sort(arr, null);
        }

        public static <T> void sort(T[] arr, Comparator<T> comparator) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                int maxIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (comparator == null) {
                        if (greater(arr[j], arr[maxIndex])) {
                            maxIndex = j;
                        }
                    } else {
                        if (comparator.compare(arr[j], arr[maxIndex]) >= 0) {
                            maxIndex = j;
                        }
                    }
                }
                if (maxIndex != i) {
                    swap(arr, i, maxIndex);
                }
            }
        }

        private static <T> boolean greater(T a, T b) {
            return ((Comparable<T>) a).compareTo(b) >= 0;
        }

        private static <T> void swap(T[] arr, int i, int j) {
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
	 /*The following method is the InsertionSort Algorithm,Its time complexity is O(n^2)*/

	public static class InsertionSort {

        public static <T extends Comparable<T>> void sort(T[] arr) {
            sort(arr, null);
        }

        public static <T> void sort(T[] arr, Comparator<T> comparator) {
            int n = arr.length;
            for (int i = 1; i < n; i++) {
                T key = arr[i];
                int j = i - 1;
                while (j >= 0 && (comparator == null ? greater(arr[j], key) : comparator.compare(arr[j], key) < 0)) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }

        private static <T> boolean greater(T a, T b) {
            return ((Comparable<T>) a).compareTo(b) > 0;
        }
    }


	
	//The following method is the mergeSort Algorithm.Its time complexity is O(n log n)
	public static class MergeSort {

        public static <T extends Comparable<T>> void sort(T[] arr) {
            sort(arr, null);
        }

        public static <T> void sort(T[] arr, Comparator<T> comparator) {
            if (arr == null || arr.length <= 1) {
                return;
            }
            sort(arr, 0, arr.length - 1, comparator);
        }

        private static <T> void sort(T[] arr, int left, int right, Comparator<T> comparator) {
            if (left < right) {
                int middle = (left + right) / 2;
                sort(arr, left, middle, comparator);
                sort(arr, middle + 1, right, comparator);
                merge(arr, left, middle, right, comparator);
            }
        }

        private static <T> void merge(T[] arr, int left, int middle, int right, Comparator<T> comparator) {
            int n1 = middle - left + 1;
            int n2 = right - middle;

            T[] temp = (T[]) new Object[right - left + 1];

            int i = 0, j = 0;
            int k = left;

            while (i < n1 && j < n2) {
                if (comparator == null) {
                    if (greater(arr[left + i], arr[middle + 1 + j])) {
                        temp[k - left] = arr[left + i];
                        i++;
                    } else {
                        temp[k - left] = arr[middle + 1 + j];
                        j++;
                    }
                } else {
                    if (comparator.compare(arr[left + i], arr[middle + 1 + j]) >= 0) {
                        temp[k - left] = arr[left + i];
                        i++;
                    } else {
                        temp[k - left] = arr[middle + 1 + j];
                        j++;
                    }
                }
                k++;
            }

            while (i < n1) {
                temp[k - left] = arr[left + i];
                i++;
                k++;
            }

            while (j < n2) {
                temp[k - left] = arr[middle + 1 + j];
                j++;
                k++;
            }

            System.arraycopy(temp, 0, arr, left, temp.length);
        }

        private static <T> boolean greater(T a, T b) {
            return ((Comparable<T>) a).compareTo(b) >= 0;
        }
    }


	//The following method is the QuickSort Algorithm. Its time complexity is O(n log n) 
	public static class QuickSort {

	    public static <T extends Comparable<T>> void sort(T[] arr) {
	        sort(arr, 0, arr.length - 1);
	    }

	    public static  <T> void sort(T[] arr, Comparator<T> comparator) {
	        sort(arr, 0, arr.length - 1, comparator);
	    }

	    private static <T extends Comparable<T>> void sort(T[] arr, int low, int high) {
	        if (low < high) {
	            int pi = partition(arr, low, high);
	            sort(arr, low, pi - 1);
	            sort(arr, pi + 1, high);
	        }
	    }

	    private static <T> void sort(T[] arr, int low, int high, Comparator<T> comparator) {
	        if (low < high) {
	            int pi = partition(arr, low, high, comparator);
	            sort(arr, low, pi - 1, comparator);
	            sort(arr, pi + 1, high, comparator);
	        }
	    }

	    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
	        T pivot = arr[high];
	        int i = low - 1;
	        for (int j = low; j < high; j++) {
	            if (arr[j].compareTo(pivot) > 0) {
	                i++;
	                swap(arr, i, j);
	            }
	        }
	        swap(arr, i + 1, high);
	        return i + 1;
	    }

	    private static <T> int partition(T[] arr, int low, int high, Comparator<T> comparator) {
	        T pivot = arr[high];
	        int i = low - 1;
	        for (int j = low; j < high; j++) {
	            if (comparator.compare(arr[j], pivot) > 0) {
	                i++;
	                swap(arr, i, j);
	            }
	        }
	        swap(arr, i + 1, high);
	        return i + 1;
	    }

	    private static <T> void swap(T[] arr, int i, int j) {
	        T temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }
		}
	
	//The following method is the HeapSort Algorithm.Its time complexity is O(n log n) 
	public static class HeapSort {

	    public static <T> void sort(T[] arr, Comparator<T> comparator) {
	        int n = arr.length;

	        // Build max heap
	        for (int i = n / 2 - 1; i >= 0; i--) {
	            heapify(arr, n, i, comparator);
	        }

	        // Extract elements from the heap one by one
	        for (int i = n - 1; i > 0; i--) {
	            // Swap the root (maximum element) with the last element
	            T temp = arr[0];
	            arr[0] = arr[i];
	            arr[i] = temp;

	           
	            heapify(arr, i, 0, comparator);
	        }
	    }

	    private static <T> void heapify(T[] arr, int n, int i, Comparator<T> comparator) {
	        int largest = i;
	        int left = 2 * i + 1;
	        int right = 2 * i + 2;

	        // Compare with left child
	        if (left < n && comparator.compare(arr[left], arr[largest]) < 0) {
	            largest = left;
	        }

	        // Compare with right child
	        if (right < n && comparator.compare(arr[right], arr[largest]) < 0) {
	            largest = right;
	        }

	        
	        if (largest != i) {
	            T temp = arr[i];
	            arr[i] = arr[largest];
	            arr[largest] = temp;

	            heapify(arr, n, largest, comparator);
	        }
	    }
	}
}
