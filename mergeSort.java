
public class mergeSort {
    
    public void merge(int arr[], int p, int q, int r){
        int L[] = new int[q - p + 1];
        int R[] = new int[r - q];
        for(int i = 0; i < q - p + 1; i++){
            L[i] = arr[p + i];
        }
        for(int j = 0; j < r - q; j++){
            R[j] = arr[j + q + 1];
        }
        int i = 0;
        int j = 0;
        int k = p;
        while(i < q - p + 1 && j < r -q){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        //copy the rest
        while(i<(q-p+1)){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<r-q){
            arr[k] = R[j];
            j++;
            k++;
        }
        
    }
    public void mergeSort1(int arr[], int p, int r){
        if(p < r){
         int q = (p+r)/2;
         mergeSort1(arr,p,q);
         mergeSort1(arr,q+1, r);
         merge(arr, p, q, r);   
        }
        
    }
    
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
    
    public static void main(String args[]){
        int arr[] = {10, 10, -111, 5, 8, 7};
        int[] result = new int[3];
        
        System.out.println("Given Array");
        System.out.println("Given Array");
        printArray(arr); 
  
        mergeSort ob = new mergeSort();
        maxSubArrayClass subs = new maxSubArrayClass();
        result = subs.findMaxSubArray(arr, 0, arr.length-1);
        ob.mergeSort1(arr, 0, arr.length-1); 
  
        System.out.println("\nSorted array"); 
        printArray(result); 
    }

}
