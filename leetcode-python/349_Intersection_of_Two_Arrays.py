#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 349_Intersection_of_Two_Arrays.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.06.26
#########################################################################

class Solution(object):
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        return list(set(nums1) & set(nums2))
