#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 191_Number_of_1_Bits.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.06.28
#########################################################################

class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0
        while n:
            if n % 2 == 1:
                count += 1
            n /= 2
        return count

    def hammingWeight2(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0
        while n:
            n = n & (n - 1)
            count += 1
        return count

    def test(self):
        print self.hammingWeight2(11)

if __name__ == '__main__':
    solution = Solution()
    print solution.test()
