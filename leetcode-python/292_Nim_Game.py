#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 292_Nim_Game.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.06.21
#########################################################################

class Solution(object):
    def canWinNim(self, n):
        """
        :type n: int
        :rtype: bool
        """
        return n % 4 > 0
