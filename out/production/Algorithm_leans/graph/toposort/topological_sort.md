# Topological Sort
Many real world situations can be modelled as a grp with directed
where some events must occur before others.
- School class prerequisites
- Program dependencies
- Event scheduling
- Assembly instructions
- Etc ...

A `topoligical ordering` is an ordering of the node in directed graph
where for each directed edge from node A to node B,
node A appears before node B in the ordering.

The `topological sort` algorithms can find a topological ordering in *O(V+E)* time! <br>
`NOTE:` Topological orderings are NOT unique.

## Directed Acyclic Graphs (DAG)
Not every graph can have a topological ordering.
A graph which contains a `cycle` cannot have a valid ordering:

The only type of graph which has a valid topological ordering is a *Directed Acyclic Graph (DAG)*.
These are graphs with directed edges and no cycles.

By definition, all rooted trees have a topological ordering since they do not contain any cycles.

## Topological Sort Algorithm
Pick an unvisited node <br>
Beginning  with the selected node, do a *Depth First Search (DFS)*
exploring only unvisited nodes. <br>
On the recursive callback of the *DFS*,
add the current node to the topological ordering in reverse order.


### Sudo code
#### Solution 1 
```shell
# Assumption: graph is sorted as adjacency list
function topSort(graph):

    N = graph.numberOfNodes()
    V = [false, ..., false] # Length N
    ordering = [0, ..., 0]  # Length N
    i = N - 1 # Index for ordering array
    
    for(at = 0; at < N ; at++) {
      if V[at] == false:
          visitedNodes = []
          dfs(at, V, visitedNodes, graph)
          for nodeId in visitedNodes:
              ordering[i] = nodeId
              i = i - 1;
              
      return ordering
    }
    
    
    # Execute Depth First Search (DFS)
    function dfs(at, V, visitedNodes, graph):
        
        V[at] = true;
        
        edges = graph.getEdgesOutFromNode(at)
        for edge in  edges:
            if V[edge.to] == false
                dfs(edge.to, V, vistedNodes, graph)
                
        visitedNode.add(at)     
```
#### Solution 2
```shell
# Assumption: graph is sorted as adjacency list
function topSort(graph):

    N = graph.numberOfNodes()
    V = [false, ..., false] # Length N
    ordering = [0, ..., 0]  # Length N
    i = N - 1 # Index for ordering array
    
    for(at = 0; at < N ; at++) {
      if V[at] == false:
          visitedNodes = []
          dfs(at, V, visitedNodes, graph)
          
      return ordering
    }
    
    
    # Execute Depth First Search (DFS)
    function dfs(at, V, visitedNodes, graph):
        
        V[at] = true;
        
        edges = graph.getEdgesOutFromNode(at)
        for edge in  edges:
            if V[edge.to] == false
                dfs(edge.to, V, vistedNodes, graph)
                
        ordering[i] = at
        return i = i - 1;
```
## Kahn's Algorithm

The intuition behind Kahn's algorithm is to repeatedly remove nodes without any dependencies <br>
from the graph and add them to the topological ordering.

As node without dependencies (and their outgoing edges) are removed from graph, <br>
new nodes without dependencies should become free.

We repeat removing nodes without dependencies from the graph until all node are processed, <br>
or a cycle is discovered.

### Sudo code

```shell
# `g` is a directed acyclic graph represented as an adjacency list.
functiono findToplogicalOrdering(g):
    n = g.size()
    in_degree = [0, 0, ..., 0] # size n
    for (i = 0; i < n; i++):
        for (to in g[i])
            in_degree[to] = in_degree[to] + 1;
            
 # `q` always contains the set nodes with no incoming edges.
 q = ... # empty integer queue structure
 
 for (i = 0; i < n; i++):
    if (in_degree[i] ==  0):
        q.enqueue(i)

index = 0
order = [0, 0, ..., 0] #size n
while (!q.isEmpty()):
    at = q.dequeue()
    order[index++] = at
    for (to in g[at]):
        in_degree[to] = in_degree[to] - 1
        if in_degree[to] == 0:
            q.enqueue[to]
    if index != n:
        return null # Oops, graph contains a cycle 
    return order;
```
