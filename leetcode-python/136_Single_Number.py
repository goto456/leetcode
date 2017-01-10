#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 136_Single_Number.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.06.28
#########################################################################

class Solution(object):
    def singleNumber(self, nums):
        """
        最初解法
        :type nums: List[int]
        :rtype: int
        """
        myset = set()
        for item in nums:
            if item in myset:
                myset.remove(item)
            else:
                myset.add(item)
        return myset.pop()

    def singleNumber2(self, nums):
        """
        与或运算解法
        :type nums: List[int]
        :rtype: int
        """
        result = 0
        for item in nums:
            result ^= item
        return result
