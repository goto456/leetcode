#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 283_Move_Zeroes.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.06.23
#########################################################################

class Solution(object):
    def moveZeroes(self, nums):
        """
        最初解法
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        length = len(nums)
        i = 0
        j = 0
        while i < length:
            if nums[i] != 0:
                nums[j] = nums[i]
                j += 1
            i += 1
        while j < length:
            nums[j] = 0
            j += 1
        return nums

    def moveZeroes2(self, nums):
        """
        优化解法
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        j = 0
        for i in range(len(nums)):
            if nums[i]:
                nums[j], nums[i] = nums[i], nums[j]
                j += 1
if __name__ == '__main__':
    l = [0, 1, 0, 3, 12]
    print l
    solution = Solution()
    solution.moveZeroes2(l)
    print l


