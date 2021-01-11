/** 
** Software Technology 152
** Class to hold various static sort methods.
*/
import java.util.*;
import java.io.*;

class Sorts
{
    // bubble sort
    public static void bubbleSort(int[] A)
    {

        int pass = 0;
        int ii;
        int temp;
        boolean sorted;
        do
        {
            sorted = true;
            for (ii = 0;ii < ((A.length-1 - pass) - 1); ii++)
            {
                if (A[ii] > A[ii+1])
                {
                    temp = A[ii];
                    A[ii] = A[ii+1];
                    A[ii+1] = temp;
                    sorted = false;
                }
            }
            pass++;
        }while (!sorted);
    }//bubbleSort()

    // selection sort
    public static void selectionSort(int[] A)
    {
        int nn, minIdx, jj, temp;
        for (nn = 0; nn < (A.length-1); nn++)
        {
            minIdx = nn;
            for (jj = nn+1; jj < (A.length-1); jj++)
            {
                if (A[jj] < A[minIdx])
                {
                    minIdx = jj;
                }
            }
            temp = A[minIdx];
            A[minIdx] = A[nn];
            A[nn] = temp;
        }   
    }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] A)
    {
        int nn, ii, temp;
        for (nn = 1; nn < A.length-1; nn++)
        {
            ii = nn;
            temp = A[ii];
            while ((ii > 0) && (A[ii-1] > temp))
            {
                A[ii] = A[ii-1];
                ii = ii -1;
            }
            A[ii] = temp;
        }
    
    }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
        mergeSortRecurse(A, 0, A.length -1);  
    }//mergeSort()

    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
        int midIdx;
        if (leftIdx < rightIdx)
        {
            midIdx = (leftIdx + rightIdx)/2;

            mergeSortRecurse(A, leftIdx, midIdx);
            mergeSortRecurse(A, midIdx+1, rightIdx);

            merge(A, leftIdx, midIdx, rightIdx);
        }
        
    }//mergeSortRecurse()
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
        int [] tempArr;
        int ii, jj, kk;
        tempArr = new int [rightIdx - leftIdx + 1];
        ii = leftIdx;
        jj = midIdx + 1;
        kk = 0;

        while ((ii<= midIdx) && (jj <= rightIdx))
        {
            if (A[ii] <= A[jj])
            {
                tempArr[kk] = A[ii];
                ii++;
            }
            else
            {
                tempArr[kk] = A[jj];
                jj++;
            }
        kk++;
        }
        for (ii = ii; ii <= midIdx; ii++)
        {
            tempArr[kk] = A[ii];
            kk++;
        }
        for (jj = jj; jj <= rightIdx; jj++)
        {
            tempArr[kk] = A[jj];
            kk++;
        }
        for (kk = leftIdx; kk <= rightIdx; kk++)
        {
            A[kk] = tempArr[kk - leftIdx];
        }
    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
        quickSortRecurse(A, 0, A.length -1);  
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
        int pivotIdx, newPivotIdx;
        if (rightIdx > leftIdx)
        {
            pivotIdx = (leftIdx + rightIdx) / 2;
            newPivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);
            
            quickSortRecurse(A, leftIdx, newPivotIdx-1);
            quickSortRecurse(A, newPivotIdx + 1, rightIdx);
        }
    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
        int pivotVal;
        int currIdx, temp, ii, newPivotIdx;
        
        pivotVal = A[pivotIdx];
        A[pivotIdx] = A[rightIdx];
        A[rightIdx] = pivotVal;

        currIdx = leftIdx;

        for (ii = leftIdx; ii <= (rightIdx- 1); ii++)
        {
            if (A[ii] < pivotVal)
            {
                temp = A[ii];
                A[ii] = A[currIdx];
                A[currIdx] = temp;
                currIdx++;
            }
        }
        newPivotIdx = currIdx;
        A[rightIdx] = A[newPivotIdx];
        A[newPivotIdx] = pivotVal;

		return newPivotIdx;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning

    /*******************************************
    * Obtained from https://www.geeksforgeeks.org/shellsort/
    * *******************************************/

    //ShellSort
    public static void shellSort(int[] arr)
    {
        int n = arr.length;
        //reduce the gap size
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            //gapped insertion sort for gap size
            // already in gap order adding one more element
            // until array is gap sorted
            for(int i = gap; i < n; i +=1)
            {
                //add [i] to the elements that have been gapped
                //sirted save a[i] in tem and make a hole at pos i
                int temp = arr[i];
                //shift elements until the correct location
                //for a[i] is found
                int j;
                for(j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                {
                    arr[j] = arr[j- gap];
                }
                //put temp in its correct location(temp is orgonal a[i]
                arr[j] = temp;
            }
        }
    }

    /*******************************************
    * Obtained from https://www.javacodex.com/Sorting/Counting-Sort
    * and 
    * Obtained from https://www.geeksforgeeks.org/Counting-Sort/
    * *******************************************/
    
    public static void countingSort(int[] arr)
    {
        int n = arr.length;
        int output[] = new int[n];
        int min = arr[0];
        int max = arr[0];
        
        for(int i = 1; i < n; i++)
        {
            if (arr[i] < min)
            {
                min = arr[i];
            }
            else if (arr[i] > max)
            {
                max = arr[i];
            }
        }

        int[] counts = new int[max - min + 1];
        //store count of each int
        for (int i = 0; i < n; i++)
        {
            counts[arr[i] - min]++;
        }
        for (int i = 1; i < counts.length; i++)
        {
            counts[i] += counts[i-1];
        }
        for (int i = n - 1; i >=0; i--)
        {
            output[counts[arr[i] - min] - 1] = arr[i];
            counts[arr[i] - min]--;
        }
        //copys the sorted array so the current array is sorted
        for (int i = 0; i < n; i++)
        {
            arr[i] = output[i];
        }
    }


    /*******************************************
    * Obtained from https://www.geeksforgeeks.org/radix-sort/
    * *******************************************/
    //Radix LSD Sort
    public static void radixSort(int[] arr)
    {
        int n = arr.length;
        int m = getMax(arr, n);//finds max number of digits
        for (int exp = 1; m/exp >0; exp *=10)//does counting sort for each digit
        {
            countSort(arr, n, exp);
        }
    }
    
    //returns max value
    static int getMax(int[] arr, int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
        {
            if (arr[i] > mx)
            {
                mx = arr[i];
            }
        }
        return mx;
    }

    //sorts according to exp given
    public static void countSort(int[] arr, int n, int exp)
    {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
        //stores count of occurances in count[]
        for (i = 0; i < n; i++)
        {
            count[ (arr[i]/exp)%10]++;
        }
        //makes count i contain actual pos of output
        for (i = 1; i < 10; i++)
        {
            count[i] += count[i - 1];
        }
        //build output
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }
        //copys sorted array and makes it current
        for (i = 0; i < n; i++)
        {
            arr[i] = output[i];
        }
    }

}//end Sorts calss
