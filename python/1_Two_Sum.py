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
        for i, element in enumerate(nums):
            lst = dic.get(nums[i], [])
            lst.append(i)
            dic[nums[i]] = lst

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
        index1 = min(dic[nums[i]][0], dic[nums[j]][-1])
        index2 = max(dic[nums[i]][0], dic[nums[j]][-1])
        return [index1, index2]

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
        dic = {} #用来存储原始数组中元素与下标的映射关系，有可能一个元素对应多个下标, 只存最小那个
        for i, element in enumerate(nums):
            if target - element in dic:
                index1 = dic[target - element]
                index2 = i
                return [index1, index2]
            dic[element] = dic.get(element, i)

