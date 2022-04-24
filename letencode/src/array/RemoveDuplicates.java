package array;

import java.util.ArrayList;
import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.*;

/***
 * Solution to this problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return 1;

        int res_index = 1;
        for (int n = 1; n < nums.length; n++) {
            if (nums[n] != nums[res_index-1]) {
                nums[res_index++]=nums[n];
            }
        }

        return res_index;
    }

    @Test
    public void testSolution() {
        RemoveDuplicates solution = new RemoveDuplicates();
        int[] nums = new int[]{1,1,2,2,2,5,5,8,8,8,8,9};
        int[] expectedNums = new int[]{1,2,5,8,9};
        System.out.print("Input: ");
        printArray(nums.length, nums);

        int k = solution.removeDuplicates(nums);

        System.out.print("\nResult: ");
        printArray(k, nums);
        Assertions.assertEquals(k, expectedNums.length);
        for (int i = 0; i < k; i++)
            Assertions.assertEquals(nums[i], expectedNums[i]);
    }

    public void printArray(int length, int[] result) {
        System.out.print("[");
        for (int n=0; n < length; n++ ) {
            System.out.print(result[n]);
            if (n +1 < length)
                System.out.print(",");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        RemoveDuplicates solution = new RemoveDuplicates();
        int[] sample = new int[]{1,1,2};
        int k = solution.removeDuplicates(sample);
        solution.printArray(k, sample);
    }
}
