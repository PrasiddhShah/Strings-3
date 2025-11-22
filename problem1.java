// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Approach
First we make a arrays of all the unique words that form to make the english words
they are of three catagory thousand like"Thousand" "Million" "Billion"...
below 20 like One, Two, three...
and ten Ten Twenty Thirty...
we start a for loop where we take taking triplets, so for "543123" we will take the 123 first using "%"
construct that numbers english first using helper function

helper function has 3 parts, or checks first checks if num is below 20 if so directly takes the value and returns it
else if num <100 for that it divides num/10 and again calles the helper funciton on num*10
else if numer is bigger then 100 it return below_20[num/100] + hundred + calls the helper function again with %10 on the number

once all the recursive calls for helper are done result get update with the value of left most tripelt of the num 
then idx is increased and num/1000 so that the triplet can be removed this loops till num >0

let take 123 as example
triplet = num%1000;
triplet = 123
then helper of triplet is called

in helper num is >20 and >100 to last condition is called below_20[123/100] + "Hundred" +helper(123%100)

again helper is called on 23
second condition ten[23/10] + " " +helper(23%10);
again on 3
finally the recurion goes back with
One Hundred Twenty Three
idx = 1
num = 0(num = num/1000)
return result
*/

class Solution {
    String[] thousand = { "", "Thousand", "Million", "Billion" };
    String[] below_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    String[] ten = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        String result = "";
        int idx = 0;
        while (num > 0) {
            int triplet = num % 1000;
            if (triplet != 0) {
                result = helper(triplet).trim() + " " + thousand[idx] + " " + result;
            }
            idx++;
            num = num / 1000;
        }
        return result.trim();
    }

    private String helper(int num) {
        if (num < 20) {
            return below_20[num] + " ";
        } else if (num < 100) {
            return ten[num / 10] + " " + helper(num % 10);
        } else {
            return below_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}