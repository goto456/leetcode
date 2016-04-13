#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 2_add_two_numbers.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.04.12
#########################################################################

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if l1 == None:
            return l2
        if l2 == None:
            return l1
        result = l1 #用现有的空间来存储结果
        cur = result
        tmp_sum = 0
        while True:
            if l1 != None:
                tmp_sum += l1.val
                l1 = l1.next
            if l2 != None:
                tmp_sum += l2.val
                l2 = l2.next
            cur.val = tmp_sum % 10
            tmp_sum /= 10
            if l1 == None:
                if l2 == None:
                    break
                else:
                    cur.next = l2
            cur = cur.next
        if tmp_sum != 0:
            cur.next = ListNode(tmp_sum) #最多只用了一个存储空间
        return result
