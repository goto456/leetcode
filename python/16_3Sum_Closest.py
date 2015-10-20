#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 16_3Sum_Closest.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2015.07.29
#########################################################################

class Solution:
	# @param {integer[]} nums
	# @param {integer} target
	# @return {integer}
	def threeSumClosest(self, nums, target):
		nums.sort()
		for k in range(len(nums)):
			i = k + 1
			j = len(nums) - 1
			tmp = target - nums[k]
			pre = None
			if (nums[i] + nums[j] - tmp) * (pre - tmp) <= 0:
				abs1 = abs(nums[i] + nums[j] - tmp)
				abs2 = abs(pre - tmp)
				if abs1 = min(abs1, abs2):
					resultList.append




solution = Solution()
s = [-1,2,1,-4]
target = 1
result = solution.threeSumClosest(s, target)
print result
