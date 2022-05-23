import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class _3_RemoveDuplicate {
	
	public static void main(String[] args) {
		_3_RemoveDuplicate _3_RemoveDuplicateOb = new _3_RemoveDuplicate();
		
		int[] input = new int[] {4,5,2,3,3,3,1,2,4,1,5,5,5,3,1};
		
		int[] result = _3_RemoveDuplicateOb.removeDuplicates(input);
		
		//System.out.println(result.toString());
		
		
	}
	
	public int[] removeDuplicates(int[] arr){
		Set<Integer> lookup = new HashSet<>();
		
		for(int i:arr) {
			if(lookup.contains(i)) {
				continue; 
			} else {
				lookup.add(i);
			}
		}
		
		int[] result = new int[lookup.size()];
		int i=0;
		for(Iterator<Integer> itr = lookup.iterator();itr.hasNext();) {
			result[i++]=itr.next();
		}
		
		return result;
	}
}
