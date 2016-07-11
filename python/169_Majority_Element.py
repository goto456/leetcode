#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 169_Majority_Element.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.06.26
#########################################################################

class Solution(object):
    def majorityElement(self, nums):
        """
        最初解法 O(nlogn)
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        maxCount = 0
        maxElement = None
        curCount = 0
        for item in nums:
            if item == maxElement:
                maxCount += 1
            else:
                curCount += 1
                if curCount > maxCount:
                    maxCount = curCount
                    maxElement = item
        return maxElement

    def majorityElement2(self, nums):
        """
        最优解法 O(n)
        :type nums: List[int]
        :rtype: int
        """
        count = 0
        curElement = None
        for item in nums:
            if count == 0:
                curElement = item
                count += 1
            else:
                if item == curElement:
                    count += 1
                else:
                    count -= 1
        return curElement

