#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 242_Valid_Anagram.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.06.26
#########################################################################

class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        sDict = {}
        tDict = {}
        for ch in s:
            if ch in sDict:
                sDict[ch] += 1
            else:
                sDict[ch] = 1
        for ch in t:
            if ch in tDict:
                tDict[ch] += 1
            else:
                tDict[ch] = 1

        return sDict == tDict
