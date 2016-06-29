#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 338_Counting_Bits.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.05.08
#########################################################################

class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        result = [0]
        for i in range(1, num + 1):
            if i % 2 == 0:
                result.append(result[i >> 1])
            else:
                result.append(result[i >> 1] + 1)
        return result



