import java.util.HashMap;
import java.util.Map;

public class _4_findDuplicate {
	public static void main(String[] args) {
		_4_findDuplicate _4_findDuplicateOb = new _4_findDuplicate();
		
		int[] input = new int[] {4, 2, 4, 3, 1};
		
		System.out.println(_4_findDuplicateOb.findDuplicate(input));
		System.out.println(_4_findDuplicateOb.findDuplicateTotoiseAndHare(input));
		
	}
	
	public int findDuplicate(int[] arr){
		//create a hashmap and put the value
		//if value is already exist in hash map then add into the result array.
		
		Map<Integer, Boolean> lookuped = new HashMap<>();
		int result=0;
		
		for(int i:arr) {
			if(lookuped.containsKey(Integer.valueOf(i))) {
				result=i;
				break;
			} else {
				lookuped.put(Integer.valueOf(i), true);
			}
		}
		
		return result;
    }
	
	public int findDuplicateTotoiseAndHare(int[] arr) {
		int tortoise = arr[0];
		int hare = arr[arr[0]];
		while(tortoise != hare) {
			tortoise = arr[tortoise];
			hare = arr[arr[hare]];
		}
		tortoise = 0;
		while(tortoise != hare) {
			tortoise = arr[tortoise];
			hare = arr[hare];
		}
		return tortoise;
	}
}
