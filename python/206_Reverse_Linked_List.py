#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 206_Reverse_Linked_List.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.06.27
#########################################################################

class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        非递归
        :type head: ListNode
        :rtype: ListNode
        """
        tempList = ListNode(0)
        cur = head
        while cur:
            p = cur
            cur = cur.next
            p.next = tempList.next
            tempList.next = p
        return tempList.next

    def reverseList2(self, head):
        """
        递归
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None or head.next is None:
            return head
        p = head.next
        q = self.reverseList2(p)
        head.next = None
        p.next = head
        return q
