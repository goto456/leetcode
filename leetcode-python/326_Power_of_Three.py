#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 326_Power_of_Three.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.06.28
#########################################################################
import math
class Solution(object):
    def isPowerOfThree(self, n):
        """
        递归
        :type n: int
        :rtype: bool
        """
        if n == 1:
            return True
        if n == 0:
            return False
        if n % 3 == 0:
            return self.isPowerOfThree(n / 3)
        return False

    def isPowerOfThree2(self, n):
        """
        循环
        :type n: int
        :rtype: bool
        """
        while n and (n % 3 == 0):
            n /= 3
        return n == 1

    def isPowerOfThree3(self, n):
        """
        log
        :type n: int
        :rtype: bool
        """
        return 3 ** math.log(n, 3) == n
