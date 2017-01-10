#!/usr/bin/env python
# -*- coding:utf-8 -*-
#########################################################################
# File Name: 4_Median_of_Two_Sorted_Arrays.py
# Author: Wang Biwen
# mail: wangbiwen88@126.com
# Created Time: 2016.04.14
#########################################################################

class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        len1 = len(nums1)
        len2 = len(nums2)
        
        mid1 = len1 / 2
        mid2 = len2 / 2
        mid = min(mid1, mid2)

        if len1 == 1:
            if len2 % 2 == 0:
                if nums1[0] >= nums2[mid2]:
                    return nums2[mid2]
                elif nums1[0] <= nums2[mid2-1]:
                    return nums2[mid2-1]
                else:
                    return nums1[0]
            else:
                if nums1[0] >= nums2[mid2+1]:
                    return float(nums2[mid2] + nums2[mid2+1]) / 2
                elif nums1[0] <= nums2[mid2-1]:
                    return float(nums2[mid2] + nums2[mid2-1]) / 2
                else:
                    return float(nums1[0] + nums2[mid2]) / 2
        if len2 == 1:
            if len2 % 2 == 0:
                if nums2[0] >= nums1[mid1]:
                    return nums1[mid1]
                elif nums2[0] <= nums1[mid1-1]:
                    return nums1[mid1-1]
                else:
                    return nums2[0]
            else:
                if nums2[0] >= nums1[mid1+1]:
                    return float(nums1[mid1] + nums1[mid1+1]) / 2
                elif nums2[0] <= nums1[mid1-1]:
                    return float(nums1[mid1] + nums1[mid1-1]) / 2
                else:
                    return float(nums2[0] + nums1[mid1]) / 2
        if nums1[mid1] == nums2[mid2]:
            return nums1[mid1]
        elif nums1[mid1] > nums2[mid2]:
            return self.findMedianSortedArrays(nums1[:mid], nums2[mid:])
        else:
            return self.findMedianSortedArrays(nums1[mid:], nums2[:mid])





if __name__ == '__main__':
    nums1 = [2,3]
    nums2 = [5,6,7,8,9]
    solution = Solution()
    print solution.findMedianSortedArrays(nums1, nums2)
