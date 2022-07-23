import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class _13_longestPalindrome_string {
	public static void main(String[] args) {
		/* case 1 */
//		String inputString = "abbaabb";
		/* case 2 */
		String inputString = "abdccdceeebebc";
		
		// excepted answer => 7
		int result = longestPalindrome(inputString);
		System.out.println(result);
		
	}	
	
	public static int longestPalindrome(String str){
        //do the count of all words and store it in map datastructure
		Map<Character, Integer> counts = new HashMap<>();		
		for(char i : str.toCharArray()) {
			if(counts.containsKey(i)) {
				counts.put(i, counts.get(i)+1);
			} else {
				counts.put(i, 1);
			}
		}
		
		int totalLength=0;
		int countOfOdd = 0;
		//sort the map according to the value of arrays.
		for(Entry<Character, Integer> entry:counts.entrySet()) {
			//count is even
			if(entry.getValue() % 2 == 0) {
				totalLength += entry.getValue();
			} else {
				countOfOdd++;
				totalLength += entry.getValue() - 1;
			}
		}
		//if it has only one odd then add one more character to it.
		if(countOfOdd >= 1) {
			totalLength++;
		}
					
		return totalLength;
    }
}
