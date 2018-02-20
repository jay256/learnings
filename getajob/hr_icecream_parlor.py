def binary_search(seq, t):
    min = 0
    max = len(seq) - 1
    while True:
        if max < min:
            return -1
        m = (min + max) // 2
        if seq[m] < t:
            min = m + 1
        elif seq[m] > t:
            max = m - 1
        else:
            return m + 1
        
def resolve_case(icecream_list, m, n):
    diff = 0
    fist_index = 0
    for i in range(n // 2):
        diff = m - icecream_list[i]
        second_index = binary_search(icecream_list, diff)
        if(second_index != -1):
            print(i+1, second_index + 1)
            return

t = input().strip()
t = int(t)
for i in range(t):
    m = input().strip()
    m = int(m)
    n = input().strip()
    n = int(n)
    icecream_list = [int(x) for x in input().strip().split(' ')]
    icecream_list.sort()
    resolve_case(icecream_list,m,n)