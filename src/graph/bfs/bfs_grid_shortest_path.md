# Breath First Search Shortest Path on a Grid
## Direction Vectors
This makes it very easy to access neighbouring cells from the current row-column position:
### Sudo code:
```
# Define the direction vectors for 
# north, south, east and west
dr = [-1, +1,  0,  0]
dc = [ 0,  0, +1, -1]

for(int i =0; i< 4; i++):
    rr = r + dr[i];
    cc = c + dc[i];
    
    # Skip invalid cells. Assume R and 
    # C for the number of row and coluns
    if rr < 0 or cc < 0: contiune
    if rr >= R or cc >= C: continue
    #(rr, cc) is a neighbouring cells of (r, c)
    
```

## Shortest Path on a Grid
### Sudo code:
```
# Gloabl/class scope varibales
R, C = ... # R = number of rows, C = number of columns
m = ...    # Input character matrix of size R x C
sr, sc = ... # `S` symbol row and column values
rq, cq = ... # Empty Row Queue (RQ) and Column Queue (CQ)

# Variables used to track the number of steps taken.
move_count = 0
nodes_left_in_layer = 1
nodes_in_next_layer = 0

# Variable used to track whether the `E` character
# ever gets reached during the BFS
reached_end = false

# R x C matrix of false values used to track whether
# the node at position (i, j) has been visited.
visited = ...

# North, south, east, west direction vectors.
dr = [-1, +1,  0,  0]
dc = [ 0,  0, +1, -1]

```





