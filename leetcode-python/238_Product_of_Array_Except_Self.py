#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 238_Product_of_Array_Except_Self.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.07.01
#########################################################################

class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtyep: List[int]
        """
        ans1 = [1] * len(nums)
        for i in range(1, len(nums)):
            ans1[i] = ans1[i - 1] * nums[i - 1]
        ans2 = [1] * len(nums)
        for i in range(len(nums) - 2, -1, -1):
            ans2[i] = ans2[i + 1] * nums[i + 1]
        ans = []
        for i in range(len(nums)):
            ans.append(ans1[i] * ans2[i])
        return ans
            

