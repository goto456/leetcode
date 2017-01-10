#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.06.28
#########################################################################

class TreeNode(Object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = right

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        ""
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        ""
        if root is None or p is None or q is None:
            return None
        if max(p.val, q.val) >= root.val and min(p.val, q.val) <= root.val:
            return root
        if max(p.val, q.val) < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        if min(p.val, q.val) > root.val:
            return self.lowestCommonAncestor(root.right, p, q)
