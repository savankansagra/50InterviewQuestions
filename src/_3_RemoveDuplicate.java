import java.util.ArrayList;
import java.util.List;

public class _3_RemoveDuplicate {
	
	public static void main(String[] args) {
		_3_RemoveDuplicate _3_RemoveDuplicateOb = new _3_RemoveDuplicate();
		
		int[] input = new int[] {4,5,2,3,3,3,1,2,4,1,5,5,5,3,1};
		
		int[] result = _3_RemoveDuplicateOb.removeDuplicates(input);
		
		System.out.println(result.toString());
		
		
	}
	
	public int[] removeDuplicates(int[] arr){
		List<Integer> lookup = new ArrayList<Integer>();
		
		for(int i:arr) {
			if(lookup.contains(i)) {
				continue; 
			} else {
				lookup.add(i);
			}
		}
		
		int[] result = new int[lookup.size()];
		for(int i=0;i<lookup.size();i++) {
			result[i] = lookup.get(i);
		}
		
		return result;
	}
}
