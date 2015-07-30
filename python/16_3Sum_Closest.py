#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 16_3Sum_Closest.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2015.07.29
#########################################################################

class Solution:
	# @param {integer[]} nums
	# @param {integer} target
	# @return {integer}
	def threeSumClosest(self, nums, target):
		nums.sort()
