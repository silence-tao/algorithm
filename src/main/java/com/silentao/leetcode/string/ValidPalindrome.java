package com.silentao.leetcode.string;

/**
 * @Description 验证回文串
 * @Author Silence
 * @Date 2020/5/14 7:35
 **/
public class ValidPalindrome {

    /**
     * 125. 验证回文串
     * https://leetcode-cn.com/problems/valid-palindrome/
     * 利用左右指针
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return true;
        }

        // 忽略大小写，所以这里把字符串转为小写字母
        s = s.toLowerCase();

        // 左右指针
        int left = 0, right = len - 1;
        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            if (!isNumberOrLetter(l)) {
                left++;
            } else if (!isNumberOrLetter(r)) {
                right--;
            } else {
                if (l != r) {
                    return false;
                }

                left++;
                right--;
            }
        }


        return true;
    }

    /**
     * 判断字符c是否为数字或者小写字母
     * @param c
     * @return
     */
    private static boolean isNumberOrLetter(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
            return true;
        }

        return false;
    }

    /**
     * 680. 验证回文字符串 Ⅱ
     * https://leetcode-cn.com/problems/valid-palindrome-ii/
     * 利用左右指针，通过一个boolean类型变量记录是否跳过字符
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return true;
        }

        return validPalindrome(s, 0, len - 1, false);
    }

    /**
     * 通过左右指针判断是否为回文串
     * 如果期间左右指针对应的字符不相等，则删除一个字符
     * 继续判断
     * @param s
     * @param left
     * @param right
     * @param isSkip 是否已经删除过字符
     * @return
     */
    private static boolean validPalindrome(String s, int left, int right, boolean isSkip) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;

                continue ;
            }

            if (!isSkip) {
                // 还没有删除字符
                // 这里删除一个字符
                // 可以从左指针中删除一个字符
                // 也可以从右指针中删除一个字符
                return validPalindrome(s, left + 1, right, true) ||
                        validPalindrome(s, left, right - 1, true);
            }

            return false;
        }

        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";

        //                      puufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuc
        // aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga
        // acupupuca
        System.out.println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
