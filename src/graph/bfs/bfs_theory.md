# Breath First Search
## BFS overview 
The Breadth First Search (BFS) is another fundamental search algorithm used to explore nodes and 
edge of a graph. It runs with a time complexity `O(V+E)` and is often used as a building block in other algorithms.

The BFS algorithm is particularly useful for one thing: finding the shorted path on unweighted graph

##Sudo code:
```shell
# Global/class scope variables
n = number of nodes in the graph
g = adjacency list representing unweighted graph

# s = start node, e = end node, and 0 <= e, s < n

function bsf(s,e):
    # Do a BFS starting at node s
    prev = solve(s)
    
    #Return constructed path from s -> e
    return reconstructedPath(s, e, prev)
    

fuction solved(s):
    q = queue data structure with enqueue and dequeue
    q.enqueue(s)
    
    visited = [false, false ..., false] #size n
    visited[s] = ture;
    
    prev = [null, ..., null] #size n
    while !q.isEmpty():
        ndoe = q.dequeue()
        neighbours = g.get(node)
        
        for(next: neighbours):
            if !visited[next]:
                q.enqueue(next)
                visited[next] = true
                prev[next] = node
     return prev


function reconstrucPath(s, e, prew):
    # Reconstruct path going backwards from e
    path = []
    for(at = e; at != null; at = prev[at]):
        path.add(at)
    
    path.reverse()
    
    # If s and e are connected return the path
    if path[0] = s:
        return path
    return []
```