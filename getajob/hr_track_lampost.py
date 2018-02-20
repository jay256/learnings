n,m,k = input().strip().split(' ')
n,m,k = [int(n), int(m), int (k)]
no_of_cells = n * m
filled_cells = 0
Matrix = [[0 for x in range(m)] for y in range (n)]
for i in range (k):
    r,c1,c2 = input().strip().split(' ')
    r,c1,c2 = [int(r), int(c1), int(c2)]
    track_len = c2 - c1 + 1
    for j in range (track_len):
        if(Matrix[r - 1][c1 - 1 + j] == 0):
            Matrix[r - 1][c1 - 1 + j] = 1
            filled_cells += 1
print(no_of_cells - filled_cells)