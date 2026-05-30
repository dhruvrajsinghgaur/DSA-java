package Patterns.TwoPointer;

public class LC_125 {

    // TC: O(n).
    // SC: O(1).
    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;

        while (left < right){

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;

            left++;
            right--;
        }
        return true;
    }

    // TC: O(n).
    // SC: O(n).
    public boolean isPalindrome1(String s) {
        StringBuilder forwardStr = new StringBuilder();
        StringBuilder backwardStr = new StringBuilder();
        for(int i = 0; i < s.length();i++ ){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(s.length() - 1 - i);
            boolean addAllowed1 = true;
            boolean addAllowed2 = true;
            if (ch1 < 97 || ch1 > 122){
                if (ch1 >= 65 && ch1 <= 90) ch1 = (char) (ch1 + 32);
                else if(ch1 >= 48 && ch1 <= 57){}
                else addAllowed1 = false;
            }
            if (ch2 < 97 || ch2 > 122){
                if (ch2 >= 65 && ch2 <= 90) ch2 = (char) (ch2 + 32);
                else if(ch2 >= 48 && ch2 <= 57){}
                else addAllowed2 = false;
            }

            if (addAllowed1) forwardStr.append(ch1);
            if (addAllowed2) backwardStr.append(ch2);
        }
        return forwardStr.toString().equals(backwardStr.toString()) ? true : false;
    }
}
