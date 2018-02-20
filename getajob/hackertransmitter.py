#!/bin/python3

import sys


n,k = input().strip().split(' ')
n,k = [int(n),int(k)]
x = [int(x_temp) for x_temp in input().strip().split(' ')]
x.sort()
#print (x[0])
x_len = len(x)
first = 0
res = 1
for i in range(x_len):
    if((x[i] - x[first]) > (int(2) * k)):
        res += 1
        first = i

print (res)