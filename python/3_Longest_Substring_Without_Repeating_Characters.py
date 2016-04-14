#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 3_Longest_Substring_Without_Repeating_Characters.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.04.13
#########################################################################

class Solution(object):
    #自己最初的解法
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        max_left = 0
        max_length = 0
        cur_left = 0
        cur_length = 0
        for i in range(len(s)):
            if s[i] in s[cur_left : cur_left + cur_length]:
                index = s[cur_left : cur_left + cur_length].index(s[i]) + cur_left
                cur_length = cur_length + cur_left - index
                cur_left = index + 1
                
            else:
                cur_length += 1
                if cur_length > max_length:
                    max_left = cur_left
                    max_length = cur_length

        return max_length

    #解法二
    def lengthOfLongestSubstring2(self, s):
        """
        :type s: str
        :rtype: int
        """
        left = 0
        max_length = 0
        dic = {} 
        for i in range(len(s)):
            ch = s[i]
            if ch in dic and dic[ch] >= left:
                left = dic[ch] + 1
            dic[ch] = i
            cur_length = i - left + 1
            max_length = max(max_length, cur_length)
        return max_length

if __name__ == '__main__':
    s = 'abba'
    solution = Solution()
    print solution.lengthOfLongestSubstring2(s)




