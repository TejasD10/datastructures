package leetcode22;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        var prefixValue = 1;

        /*
        Calculate the prefix values for e.g.
        input = [1,2,3,4]
        Prefix multiplication array would [1, 1, 2, 6]
         */
        result[0] = prefixValue; // Setting the first prefix to 1
        for (int i = 1; i < nums.length; i++) {
            result[i] = prefixValue * nums[i - 1];
            prefixValue = result[i];
        }
        /*
         Calculating the postfix value which will be the output
         for e.g.
         input = [1,2,3,4]
          Prefix multiplication array would [1, 1, 2, 6]
          Postfix would be = [24 ,12 ,4 ,1]
          The result would be to multiply the prefix and postfix in place
         */
        var postFixValue = 1;
        // Setting the last value to product of prefix and postfix
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * postFixValue;
            postFixValue *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        new ProductExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4});
    }
}
