#!/usr/bin/env python
# coding=utf-8


#
#主要思想是将three sum转化成two sum问题，先将整个数组进行排序，然后用3个指针，一个用来遍历所有元素，另外两个类似于two sum中的，从两端向中间查找。
#
class Solution:
	# @param {integer[]} nums
	# @return {integer[][]} 
	def threeSum(self, nums):
		nums.sort() #先排序
		result = []
		searchSet = set() #用来去除重复的结果
		for k in range(len(nums)):
			i = k + 1
			j = len(nums) - 1
			target = -nums[k] #开始转化成two sum问题
			while(i < j): #i,j分别指向首尾，分别向中间查找
				if nums[i] + nums[j] == target:
					tmp = ''.join([str(nums[k]), str(nums[i]), str(nums[j])])
					if tmp not in searchSet: #用于去重
						searchSet.add(tmp)
						result.append([nums[k], nums[i], nums[j]])
					i += 1
					j -= 1
				if nums[i] + nums[j] < target:
					i += 1
				if nums[i] + nums[j] > target:
					j -= 1
		return result


