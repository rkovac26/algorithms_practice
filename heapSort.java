
public class heapSort {
    
    
    public void maxHeapify(int[] A, int i, int heapSize){
        int largest = i;
        int l = leftChild(i);
        int r = rightChild(i);
        if (l < heapSize && A[l] > A[largest]){
            largest = l;
        }
        if (r < heapSize && A[r] > A[largest]){
            largest = r;
        }
        if(largest != i){
            int temp = 0;
            temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            maxHeapify(A, largest, heapSize);
        }
        
    }
    
    public void buildMaxHeap(int[] A, int heapSize){
        
        for(int i = heapSize/2 - 1; i>=0; i--){
            maxHeapify(A,i, heapSize);
        }
    }
    public void heapSorting(int[] A){
        int heapSize = A.length;
        buildMaxHeap(A,heapSize);
        for(int i = heapSize-1; i>=0; i--){
            int temp = 0;   //move current root to the end
            temp = A[i];
            A[i] = A[0];
            A[0] = temp;
            maxHeapify(A,0, i); //repair shortened heap
        }
    }
    
    public int leftChild(int i){
        return 2*i+1;
    }
    
    public int rightChild(int i){
        return 2*i+2;
    }
    
    public int partentNode(int i){
        return (i-1)/2;
    }

}
