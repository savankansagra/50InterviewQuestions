import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class _14_get_substring_index_test {

	_14_get_substring_index obj = new _14_get_substring_index();
	
	@Test
	void test() {
		//fail("Not yet implemented");
	}

	@Test
	void test1() {
		String str1 = "abcdabcdr";
		String str2 = "bcdr";
		int testResult = obj.substrIndex(str1, str2);
		assertEquals(5, testResult);
	}
	
	@Test
	void test2() {
		String str1 = "abcdabcd";
		String str2 = "bcdg";
		int testResult = obj.substrIndex(str1, str2);
		assertEquals(-1, testResult);
	}
}
