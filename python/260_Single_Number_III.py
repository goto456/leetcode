#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 260_Single_Number_III.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.06.30
#########################################################################

class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        tempSet = set()
        for item in nums:
            if item in tempSet:
                tempSet.remove(item)
            else:
                tempSet.add(item)
        return [tempSet.pop(), tempSet.pop()]


