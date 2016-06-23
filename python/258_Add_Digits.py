#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 258_Add_Digits.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.06.21
#########################################################################

class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        while num >= 10:
            temp = 0
            while num:
                temp += num % 10
                num /= 10
            num = temp
        return num

if __name__ == '__main__':
    solution = Solution()
    print solution.addDigits(1234567)





