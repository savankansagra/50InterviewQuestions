import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class _2_FindRepeatCharacter {
	public static void main(String[] args) {
		_2_FindRepeatCharacter _2_FindRepeatCharacterOb = new _2_FindRepeatCharacter();
		
		String input="inside code";
		char result = _2_FindRepeatCharacterOb.firstRepeatingCharacter(input);
		System.out.println(result);
	}

	private char firstRepeatingCharacter(String input) {
		//lets create set and add into set and if value is exists in set then return the value
		Set<Character> lookup = new HashSet<>();
		for(char temp:input.toCharArray()) {
			if(lookup.contains(temp)) {
				return temp;
			} else {
				lookup.add(temp);
			}
		}
		return '\0';
	}
}
