import java.util.Arrays;
import java.util.HashMap;

public class _1_PairSumuptoK {
	
	//Time complexity will be O(n2)
	public boolean findPair(int[] arr, int k){
		boolean flag = false;
        for(int i=0;i<arr.length;i++) {
        	for(int j=i+1;j<arr.length;j++) {
        		if(arr[i]+arr[j] == k) {
        			flag = true;
        		}
        	}
        }
        return flag;
    }
	
	
	// Time complexity will be O(nlog)
	public boolean findPairFast(int[] arr, int k) {
		boolean flag = false;
		//sort the arr
		Arrays.sort(arr);
		
		//initialize left and right index
		int left=0;
		int right=arr.length-1;
		while(left<right) {
			if(arr[left]+arr[right]==k) {
				flag = true;
				break;
			} else if(arr[left]+arr[right] < k) {
				left++;
			} else {
				right--;
			}
		}
		return flag;
	}
	
	
	//find super fast solution using hashmap.
	// Time complexity will be O(n)
	public boolean findPairSuperFast(int[] arr, int k) {
		boolean flag = false;
		HashMap<Integer, Boolean> lookup = new HashMap<Integer, Boolean>();
		
		for(int i=0;i<arr.length;i++) {
			if(lookup.containsKey(k-arr[i])) {
				flag = true;
				break;
			} else {
				lookup.put(arr[i], true);
			}
		}
		
		return flag;
	}
	
	
	public static void main(String[] args) {
		_1_PairSumuptoK _1_PairSumuptoKOb = new _1_PairSumuptoK();
		
		int arr[]=new int[] {4,5,1,-3,6};
		int k=11;
		
		System.out.println(_1_PairSumuptoKOb.findPair(arr, k));
		System.out.println(_1_PairSumuptoKOb.findPairFast(arr, k));
		System.out.println(_1_PairSumuptoKOb.findPairSuperFast(arr, k));
	}
}
