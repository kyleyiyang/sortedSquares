class Solution {
    public int[] sortedSquares(int[] A) {
        for (int i=0;i<A.length;i++) {
            A[i] = A[i]*A[i];
        }
        mergeSort(A,0,A.length-1);
        return A;
    }
    public static void mergeSort(int[] arr, int p, int q) {
        
         if (p<q) {
             int n = (int)Math.floor((q+p)/2);
             mergeSort(arr, p, n);
             mergeSort(arr, n+1, q);
             merge(arr,p,n,q);
         }
     }
     public static void merge(int[] arr, int p, int n, int q) {
         Integer myInf = Integer.MAX_VALUE;
         int l_size = (n-p+1);
         int[] l=new int[l_size+1];
         l[l_size] = myInf;
         for (int i=0;i<l_size;i++) {
             l[i] = arr[i+p];
         }
         int r_size = q-n;
         int[] r=new int[r_size+1];
         r[r_size] = myInf;
         for (int i=0;i<r_size;i++) {
             r[i] = arr[n+i+1];
         }
         int j=0;
         int i=0;
         for (int m=0; m<q-p+1; m++) {
             if (l[i]<=r[j]) {
                 arr[m+p] = l[i];
                 i++;
             } else {
                 arr[m+p] = r[j];
                 j++;
             }
         }
     }
}
