#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 171_Excel_Sheet_Column_Number.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.06.26
#########################################################################

class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        result = 0
        for i in range(len(s)):
            #result += (ord(s[-i-1]) - ord('A') + 1) * (26 ** i)
            result = result * 26 + ord(s[i]) - ord('A') + 1
        return result

if __name__ == '__main__':
    solution = Solution()
    print solution.titleToNumber('ABC')
