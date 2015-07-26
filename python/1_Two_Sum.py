#!/usr/bin/env python
# coding=utf-8


#==================================================================
#解法一：
#这是我最初的解法思想，类似于快排的原理，就是两个指针从首尾分别向中间移动查找。需要先进行排序。
#
class Solution:
	#@param {integer[]} nums
	#@param {integer} target
	#@return {integer[]} 
	def twoSum(self, nums, target):
		dic = {} #用来存储原始数组中元素与下标的映射关系，有可能一个元素对应多个下标
		for i in range(len(nums)):
			if dic.has_key(nums[i]):
				dic[nums[i]].append(i)
			else:
				dic[nums[i]] = []
				dic[nums[i]].append(i)

		nums.sort() #对数组进行排序
		i = 0
		j = len(nums) - 1
		while(i < j): #分别从首尾向中间遍历进行查找
			if nums[i] + nums[j] == target:
				break
			if nums[i] + nums[j] < target:
				i += 1
			if nums[i] + nums[j] > target:
				j -= 1

		#根据新的下标找到对应的原始下标，即所求。
		if dic[nums[i]][0] < dic[nums[j]][-1]:
			index1 = dic[nums[i]][0]
			index2 = dic[nums[j]][-1]
		else:
			index1 = dic[nums[j]][-1]
			index2 = dic[nums[i]][0]
		result = [index1 + 1, index2 + 1]
		return result


#==================================================================================
#解法二：
#这是看到网上其他大牛的解法之后，形成的另一种解法。代码及其简单，分享给大家
#该思想是逐渐建立一个hash表，然后在其中查找。A+B=C,变换成A=C-B，这是一个思想的转变。
#
class Solution:
	#@param {integer[]} nums
	#@param {integer} target
	#@return {integer[]} 
	def twoSum(self, nums, target):
		dic = {} #用来存储原始数组中元素与下标的映射关系，有可能一个元素对应多个下标
		for i in range(len(nums)):
			if dic.has_key(target - nums[i]): #在字典中查找，一旦找到，即成功。
				index1 = dic[target - nums[i]][0]
				index2 = i
				result = [index1 + 1, index2 + 1]
				return result
			#下面与网上的版本不同，网上的虽然能提交通过，但是有错误。
			if dic.has_key(nums[i]):
				dic[nums[i]].append(i)
			else:
				dic[nums[i]] = []
				dic[nums[i]].append(i)


