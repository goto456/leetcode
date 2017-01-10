#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 203_Remove_Linked_List_Elements.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.06.20
#########################################################################

class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        temp_list = ListNode(0)
        temp_list.next = head
        pre = temp_list
        cur = head
        while cur:
            if cur.val == val:
                pre.next = cur.next
                cur = cur.next
            else:
                pre = cur
                cur = cur.next
        return temp_list.next
