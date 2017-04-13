package stackTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import stack.ReversePolish;

public class TestReversePolish {

	private ReversePolish test = new ReversePolish();
	
	@Test
	public void test1() {
		assertEquals(25, test.calculate("5 + 6 + 7 * 2"));
	}

	@Test
	public void test2() {
		assertEquals(13, test.calculate("5 + (13 - 9) * 2"));
	}
	
	@Test
	public void test3() {
		assertEquals(220, test.calculate("123 + 2 * 11 + (7 * 2 + 11) * 3"));
	}
	
	@Test
	public void test4() {
		assertEquals(14, test.calculate("5 + ((1 + 2) * 4) - 3"));
	}
}
