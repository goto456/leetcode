#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 104_Maximum_Depth_of_Binary_Tree.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.06.23
#########################################################################

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root == None:
            return 0
        return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1
