#!/bin/python3

import sys

def subarraySum(arr):
    max_so_far = min(arr)
    max_ending_here = 0
    countneg = 0 
    for x in range (len(arr)):
        if arr[x] < 0:
            countneg += 1
        max_ending_here += arr[x]
        if max_ending_here < 0:
            max_ending_here = 0
        if max_so_far < max_ending_here:
            max_so_far = max_ending_here
    if countneg == len(arr):
        return max(arr)
    return max_so_far

def subsequenceSum(arr):
    sum = 0
    for x in range (len(arr)):
        tmp = sum + arr[x]
        if sum < tmp:
            sum = tmp
    return sum

def maxSubarray(arr):
    return subarraySum(arr),subsequenceSum(arr)
    
if __name__ == "__main__":
    t = int(input().strip())
    for a0 in range(t):
        n = int(input().strip())
        arr = list(map(int, input().strip().split(' ')))
        result = maxSubarray(arr)
        print (" ".join(map(str, result)))
