/**
 * (1ms)
 * Created by Phoenix-Z on 2017/6/27.
 */
public class SingleElementInASortedArray {

    public static int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[][] nums = {{1}, {1, 1, 2}, {1, 2, 2}, {1, 1, 2, 3, 3, 4, 4, 8, 8}, {3, 3, 7, 7, 10, 11, 11}};
        for (int[] num : nums) {
            System.out.println(singleNonDuplicate(num));
        }
    }

}
