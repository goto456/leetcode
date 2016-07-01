#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 350_Intersection_of_Two_Arrays_II.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.06.26
#########################################################################

class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        countDict = {}
        ans = []
        for item in nums1:
            countDict[item] = countDict.get(item, 0) + 1
        for item in nums2:
            if countDict.get(item, 0) != 0:
                ans.append(item)
                countDict[item] -= 1
        return ans


    def intersect2(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        nums1 = sorted(nums1)
        nums2 = sorted(nums2)
        i = 0
        j = 0
        ans = []
        while i < len(nums1) and j < len(nums2):
            if nums1[i] == nums2[j]:
                ans.append(nums1[i])
                i += 1
                j += 1
            elif nums1[i] > nums2[j]:
                j +=  1
            else:
                i += 1
        return ans




