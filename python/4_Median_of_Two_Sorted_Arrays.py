#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 4_Median_of_Two_Sorted_Arrays.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.04.14
#########################################################################

class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        lst1 = list(nums1)
        lst2 = list(nums2)
        for i in 



        if lst1:
            lst1.extend(lst2)
        else:
            lst1 = lst2
        lst1.sort()
        index = len(lst1) / 2
        return lst1[index]

if __name__ == '__main__':
    nums1 = [2,3]
    nums2 = []
    solution = Solution()
    print solution.findMedianSortedArrays(nums1, nums2)
