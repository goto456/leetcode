#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 231_Power_of_Two.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.06.28
#########################################################################

class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        return n > 0 and (n & (n-1) == 0)
