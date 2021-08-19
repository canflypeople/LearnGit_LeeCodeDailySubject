package com.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class MD5EncryptUtil {

  private MD5EncryptUtil() {
  }

  private final static char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

  private static String toHex(byte[] bytes) {
    StringBuilder ret = new StringBuilder(bytes.length * 2);
    for (int i = 0; i < bytes.length; i++) {
      ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
      ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
    }
    return ret.toString();
  }

  public static String encrypt(String password) {
    String passwordMd5 = null;
    try {
      MessageDigest md5 = MessageDigest.getInstance("MD5");
      byte[] bytes = md5.digest(password.getBytes("utf-8"));
      passwordMd5 = toHex(bytes);
    } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
    }
    return passwordMd5;
  }

  public int maximumPopulation(int[][] logs) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int[] log : logs) {
      for (int i = log[0]; i <= log[1]; i++) {
        map.put(i, map.getOrDefault(i, 0) + 1);
      }
    }
    int count = 0, ans = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() > count) {
        count = entry.getValue();
        ans = entry.getKey();
      } else if (entry.getValue() == count) {
        ans = Math.min(ans, entry.getKey());
      }
    }
    return ans;

  }


  /**
   * i <= j 且 nums1[i] <= nums2[j] ，则称之为 有效 下标对，该下标对的 距离 为 j - i​​ 。​​
   * @param nums1
   * @param nums2
   * @return
   */
  public static int maxDistance(int[] nums1, int[] nums2) {
    // 一个不变， 另一个二分查找
    int ans = 0;
    int len1 = nums1.length, len2 = nums2.length;
    for (int i = 0; i < len1; i++) {
      int left = 0, right = len2 - 1;
      int len = 0;
      while (left < right) {
        int mid = (right - left) / 2 + left;
        if (nums1[i] <= nums2[mid]) {
          if (mid - left > 0) {
            len = mid - i;
          }
          left = mid + 1;
        } else if (nums1[i] > nums2[mid]) {
          right = mid - 1;
        }
      }
      ans = Math.max(ans, len);
    }
    return ans;
  }

  public static void main(String[] args) {
    maxDistance(new int[]{9820,8937,7936,4855,4830,4122,2327,1342,1167,815,414}, new int[]{9889,9817,9800,9777,9670,9646,9304,8977,8974,8802,8626,8622,8456});
    System.out.println(encrypt("ezpp@AIspeech"));
  }

}
