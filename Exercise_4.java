//Space time : O(NlogN)
class MergeSort
{ 
    // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
    void merge(int arr[], int l, int m, int r) 
    {  
       //Your code here
        int t1 = m-l+1;
        int t2 = r-m;

        int[] a1 = new int[t1];
        int[] a2 = new int[t2];

        for(int i=0;i<t1;i++)
            a1[i]=arr[l+i];

        for(int i=0;i<t2;i++)
            a2[i]=arr[m+1+i];

        int i=0;
        int j=0;
        int k=l;

        while (i < t1 && j < t2) {
            if (a1[i] <= a2[j]) {
                arr[k] = a1[i];
                i++;
            }
            else {
                arr[k] = a2[j];
                j++;
            }
            k++;
        }
        while (i < t1) {
            arr[k] = a1[i];
            i++;
            k++;
        }
        while (j < t2) {
            arr[k] = a2[j];
            j++;
            k++;
        }

    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(int arr[], int l, int r) 
    { 
	//Write your code here
        if(l<r) {
            int mid = l + (r - l) / 2;

            sort(arr, l, mid);
            sort(arr, mid + 1, r);

            //Call mergeSort from here
            merge(arr, l, mid, r);
        }
    } 
  
    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
  
    // Driver method 
    public static void main(String args[]) 
    { 
        int arr[] = {12, 11, 13, 5, 6, 7}; 
  
        System.out.println("Given Array"); 
        printArray(arr); 
  
        MergeSort ob = new MergeSort(); 
        ob.sort(arr, 0, arr.length-1); 
  
        System.out.println("\nSorted array"); 
        printArray(arr); 
    } 
} 