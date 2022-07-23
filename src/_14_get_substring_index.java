
public class _14_get_substring_index {
	public static void main(String[] args) {
		/* Case 1 */
		String str1 = "insideaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String str2 = "sideaaaaaaaaaaaaaaaaaa";
		// Expected result is "2"
		int result = new _14_get_substring_index().substrIndex(str1, str2);
		System.out.println(result);
	}
	
    public int substrIndex(String str1, String str2){
    	int str1Index=0;
    	int str2Index=0;
    	
    	int resultIndex = -1;
    	while(str1Index < str1.length()) {
    		if(str1.charAt(str1Index)==str2.charAt(str2Index)) {
    			resultIndex = checkTheMatch(str1, str1Index, str2, str2Index);
    			if(resultIndex != -1) {
    				break;
    			}
    		}
    		str1Index++;
    	}
    	
    	return resultIndex;
    	
    }

	private int checkTheMatch(String str1, int str1Index, String str2, int str2Index) {
		boolean flag = false;
		int matchedIndex = -1;
		int tryingtoMatchIndex = str1Index;
		
		while(str1.charAt(str1Index) == str2.charAt(str2Index)) {
			if(str2Index == str2.length()-1) {
				flag = true;
				break;
			} else if(str1Index < str1.length()-1 && str2Index < str2.length()-1) {
				str1Index++;
				str2Index++;
			}	
		}
		
		if(flag) {
			matchedIndex = tryingtoMatchIndex;
		}
		
		return matchedIndex;
	}
}
