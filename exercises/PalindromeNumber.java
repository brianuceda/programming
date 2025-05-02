package exercises;

import java.util.List;

public class PalindromeNumber {
    public static void main(String[] args) {
        isPalindrome(52522);
    }

    public static boolean isPalindrome(int x) {

        List<String> list = List.of(String.valueOf(x).split(""));

        for (int i = 0; i < list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                return false;
            }
        }

        return true;
    }
}
