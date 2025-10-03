class Solution {
    private static String string;
    public static String longestPalindrome(String s) {
        string = s;
        int longestLen = 0;
        String result = string.substring(0, 1);

        for(int i = 0; i < string.length(); i++){
            if(canOdd(i)){
                int[] arr = oddPalindrome(i);
                int len = arr[1] - arr[0] + 1;
                if(len > longestLen){
                    longestLen = len;
                    result = string.substring(arr[0], arr[1] + 1);
                }
            }

            if(canEven(i)){
                int[] arr = evenPalindrome(i);
                int len = arr[1] - arr[0] + 1;
                if(len > longestLen){
                    longestLen = len;
                    result = string.substring(arr[0], arr[1] + 1);
                }
            }
        }

        return result;
    }
    
    private static boolean canOdd(int idx){
        int left = idx - 1;
        int right = idx + 1;
        if(left > -1 && right < string.length()){
            return string.charAt(left) == string.charAt(right);
        } else{
            return false;
        }
    }

    private static boolean canEven(int idx){
        int left = idx;
        int right = idx + 1;
        if(left > -1 && right < string.length()){
            return string.charAt(left) == string.charAt(right);
        } else{
            return false;
        }
    }


    private static int[] evenPalindrome(int idx){
        int left = idx;
        int right = idx + 1;
        int[] result = new int[2];

        while(left > -1 && right < string.length()){
            if(string.charAt(left) != string.charAt(right)){
                break;
            }
            result[0] = left--;
            result[1] = right++;
        }
        
        return result;
    }

    private static int[] oddPalindrome(int idx){
        int left = idx - 1;
        int right = idx + 1;
        int[] result = new int[2];

        while(left > -1 && right < string.length()){
            if(string.charAt(left) != string.charAt(right)){
                break;
            }
            result[0] = left--;
            result[1] = right++;
        }

        return result;
    }
}