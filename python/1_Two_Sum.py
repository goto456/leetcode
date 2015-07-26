#!/usr/bin/env python
# coding=utf-8

class Solution:
	#@param {integer[]} nums
	#@param {integer} target
	#@return {integer[]} 
	def twoSum(self, nums, target):
		dic = {}
		for i in range(len(nums)):
			if dic.has_key(nums[i]):
				dic[nums[i]].append(i)
			else:
				dic[nums[i]] = []
				dic[nums[i]].append(i)

		nums.sort()
		i = 0
		j = len(nums) - 1
		while(i < j):
			if nums[i] + nums[j] == target:
				break
			if nums[i] + nums[j] < target:
				i += 1
			if nums[i] + nums[j] > target:
				j -= 1

		if dic[nums[i]][0] < dic[nums[j]][-1]:
			index1 = dic[nums[i]][0]
			index2 = dic[nums[j]][-1]
		else:
			index1 = dic[nums[j]][-1]
			index2 = dic[nums[i]][0]
		result = [index1 + 1, index2 + 1]
		return result














