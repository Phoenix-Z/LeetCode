package maxSumOfSubArrayTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import maxSumOfSubArray.Solution1;
import maxSumOfSubArray.Solution2;
import maxSumOfSubArray.Solution3;
import maxSumOfSubArray.Solution4;

public class TestMaxSumOfSubArray {

	private int[] nums = {-2, 11, -4, 13, -5};
	
	@Test
	public void testSolution1() {
		assertEquals(20, Solution1.maxSubSum(nums));
	}

	@Test
	public void testSolution2() {
		assertEquals(20, Solution2.maxSubSum(nums));
	}

	@Test
	public void testSolution3() {
		assertEquals(20, Solution3.maxSubSum(nums));
	}

	@Test
	public void testSolution4() {
		assertEquals(20, Solution4.maxSubSum(nums));
	}
}
