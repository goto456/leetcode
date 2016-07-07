#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 217_Contains_Duplicate.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.06.26
#########################################################################

class Solution(object):
    def containsDuplicate(self, nums):
        """
        最初解法 O(nlogn)
        :type nums: List[int]
        :rtype: bool
        """
        nums.sort()
        pre = None
        for item in nums:
            if item == pre:
                return True
            pre = item
        return False

    def containsDuplicate(self, nums):
        """
        用set来解
        :type nums: List[int]
        :rtype: bool
        """
        return len(set(nums)) != len(nums)
