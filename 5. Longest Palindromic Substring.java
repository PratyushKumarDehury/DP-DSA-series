Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.







class Solution {
    public String longestPalindrome(String s) {

        int start=0;
        int end=0;
        int low,high;
        int n=s.length();
        for(int i = 0; i < n; i++){
            // even length
            low = i;
            high = i+1;
            
            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)){
                if((end-start) < (high-low)){
                    start = low;
                    end = high;
                }
                low--;
                high++;
            }
            
            // Odd length
            
            low = i;
            high = i+2;
            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)){
                if((end-start) < (high-low)){
                    start = low;
                    end = high;
                }
                low--;
                high++;
            }
        }
        return s.substring(start,end+1); 
        
    }
}