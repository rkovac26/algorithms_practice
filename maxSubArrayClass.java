
public class maxSubArrayClass {
    
    public int[] findMaxCrossingSubArray(int[] arr, int low,int mid,int high){
        int[] result = new int[3];
        int leftSum = -100000;
        int sum = 0;
        int maxLeft = 0;
        int rightSum = -10000;
        int maxRight = 0;
        for(int i = mid; i>=low; i--){
            sum += arr[i];
            if(sum > leftSum){
                leftSum = sum;
                maxLeft = i;
            }
        }
        sum = 0;
        for(int i = mid + 1; i <= high ; i++){
            sum += arr[i];
            if(sum > rightSum){
                rightSum = sum;
                maxRight = i;
            }
        }
        result[0] = maxLeft;
        result[1] = maxRight;
        result[2] = leftSum + rightSum;
        return result;
        
    }
    
    public int[] findMaxSubArray(int[] arr, int low,int high){
        int[] result = new int[3];
        if(low == high){
            result[0] = low;
            result[1] = high;
            result[2] = arr[low];
            return result;
        } else {
            int mid = (low + high)/2;
            int[] leftResult = new int[3];
            leftResult = findMaxSubArray( arr, low, mid);
            int[] rightResult = new int[3];
            rightResult = findMaxSubArray( arr, mid + 1, high);
            int[] midResult = new int[3];
            midResult = findMaxCrossingSubArray(arr, low, mid, high);
            if(leftResult[2]>=rightResult[2] && leftResult[2] >=midResult[2]){
                return leftResult;
            } else if(rightResult[2]>=leftResult[2] && rightResult[2] >=midResult[2]){
                return leftResult;
                
            } else {
                return midResult;
            }
            
            
        }
        
    }

}
