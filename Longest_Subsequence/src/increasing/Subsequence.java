package increasing;

import java.util.*;

public class Subsequence 
{
    public static List<Integer> longest(int[] nums) 
    {
        if (nums == null || nums.length == 0) 
        {
            return new ArrayList<>();
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLength = 1;
        int endIndex = 0;

        for (int i = 1; i < n; i++) 
        {
            for (int j = 0; j < i; j++) 
            {
                if (nums[i] > nums[j] && dp[i] <= dp[j]) 
                {
                    dp[i] = dp[j] + 1;
                    if (dp[i] > maxLength) 
                    {
                        maxLength = dp[i];
                        endIndex = i;
                    }
                }
            }
        }

        List<Integer> longestSubsequence = new ArrayList<>();
        longestSubsequence.add(nums[endIndex]);
        int currentLength = maxLength - 1;

        for (int i = endIndex - 1; i >= 0; i--) 
        {
            if (nums[i] < nums[endIndex] && dp[i] == currentLength) 
            {
                longestSubsequence.add(nums[i]);
                currentLength--;
            }
        }

        // Reverse the list to get the correct order
        List<Integer> reversed = new ArrayList<>();
        for (int i = longestSubsequence.size() - 1; i >= 0; i--) 
        {
            reversed.add(longestSubsequence.get(i));
        }

        return reversed;
    }

    public static void main(String[] args) 
    {
        @SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scan.nextInt();

        int[] numbers = new int[n];
        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) 
        {
            numbers[i] = scan.nextInt();
        }

        List<Integer> longestSubsequence = longest(numbers);

        System.out.println("Longest Increasing Subsequence: " + longestSubsequence);
    }
}
