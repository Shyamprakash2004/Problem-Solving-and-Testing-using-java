import java.util.*;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int k = removeDuplicates(nums);

        System.out.println("k = " + k);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, k)));
    }
}
