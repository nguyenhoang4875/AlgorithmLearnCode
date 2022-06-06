# Dijkstra's Shorted Path Algorithm
`Dijkstra's algorithm` is a Single Source path (SSPS) algorithms <br>
for graph with `non-negative edge weights`

## What is Dijkstra's algorithms?
Depend on how algorithm is implemented and what data structure are used <br>
the time complexity is typically `O(E*log(V))` which is competitive again other shortest path algorithms.

## Algorithm prerequisites
Once constraint for Dijkstra's algorithm is that the graph mus only contain `non-negative edge weight`. <br>
This constraint is imposed to ensure that once a node has been visited its optimal distance cannot be improved.

This is property is especially important because it enables Dijkstra's algorithm <br>
to act in a greedy manner by always selecting the next most promising node.

## Outline
The goal of this slide deck is for you to understand <br>
how to implement Dijkstra's algorithm and implement it efficiently.
- Lazy Dijkstra's animation
- Lazy Dijkstra's pseudo-code 
- Finding SP + stopping early optimization
- Using index priority queue + decreaseKey to reduce space and increase performance.
- Eager Dijkstra's animation
- Eager Dijkstra's pseudo-code 
- Heap optimization with D-ary heap

## Quick Algorithm Overview
Maintain a `dist` array where the distance to every node is positive infinity. <br>
Mark the distance to the start node `s` to be 0.

Maintain a priority queue (PQ) of key-value pair of (node index, distance) pair <br>
which tell you node to visit next based on sorted min value.

Insert (s, 0) into the PQ and loop while PQ is not empty pulling out <br>
the next most promising  (node index, distance) pair.

Iterate over all edges outwards from the current node and relax each edge <br>
appending new (node index, distance) key-value pair to the PQ for every relaxation.

## Lazy Dijkstra's sudo code
```shell
# Run Dijkstra's algorithms and returns an array that contains
# the shortest distance to every node from the start node s.
# g - adjacency list of weighted graph
# n - the number of the nodes in the graph
# s - the index of the starting node (0 <= s < = n)
function dijkstra(g, n, s):
    vis = [false, false, ..., false] #size n (visited)
    dist = [max, max, ..., max] #size n (distances)
    dist[s] = 0
    pq = empty priority queue
    pq.insert((s,0))
    while pq.size() != 0:
        index, minValue = pq.poll()
        vis[index] = true
        for (edge: g[index]):
            if vis[edge.to]:
                continue 
            newDist= dist[index] + edge.cost
            if newDist < dist[edge.to]:
                dist[edge.to] = newDist
                pq.insert((edge.to, newDist))
    return dist
```
In practice most standard libraries do not support the decrease key operation for PQs.<br>
A way to get around this is to add a new (node index, best distance) pair <br>
every time we update the distance to a node. <br>
As a result, it is possible to have duplicate node indicates in the PQ. <br>
This is not ideal, but inserting a new key-value pair in `O(log(n))` is much faster <br>
than searching for the key in the PQ which takes `O(n)`

## Ignore stale node optimization

```shell
# Run Dijkstra's algorithms and returns an array that contains
# the shortest distance to every node from the start node s.
# g - adjacency list of weighted graph
# n - the number of the nodes in the graph
# s - the index of the starting node (0 <= s < = n)
function dijkstra(g, n, s):
    vis = [false, false, ..., false] #size n (visited)
    dist = [max, max, ..., max] #size n (distances)
    dist[s] = 0
    pq = empty priority queue
    pq.insert((s,0))
    while pq.size() != 0:
        index, minValue = pq.poll()
        vis[index] = true
        if dist[index] < minValue:
            continue
        for (edge: g[index]):
            if vis[edge.to]:
                continue 
            newDist= dist[index] + edge.cost
            if newDist < dist[edge.to]:
                dist[edge.to] = newDist
                pq.insert((edge.to, newDist))
    return dist
```

## Finding the shortest path
```shell
# Run Dijkstra's algorithms and returns an array that contains
# the shortest distance to every node from the start node s.
# g - adjacency list of weighted graph
# n - the number of the nodes in the graph
# s - the index of the starting node (0 <= s < = n)
function dijkstra(g, n, s):
    vis = [false, false, ..., false] #size n (visited)
    dist = [max, max, ..., max] #size n (distances)
    prev = [null, null, ..., null] #size n
    dist[s] = 0
    pq = empty priority queue
    pq.insert((s,0))
    while pq.size() != 0:
        index, minValue = pq.poll()
        vis[index] = true
        if dist[index] < minValue:
            continue
        for (edge: g[index]):
            if vis[edge.to]:
                continue 
            newDist= dist[index] + edge.cost
            if newDist < dist[edge.to]:
                prev[edge.to] = index
                dist[edge.to] = newDist
                pq.insert((edge.to, newDist))
    return (dist, prev)
    
function findShortestPath(g, n, s, e):
    dist, prev = dijkstra(n, n, s)
    path = []
    if (dist[e] == max) return path
    for (at = e; at != null; at = prev[at])
        path.add(at)
    path.reverse()
    return path
```

## Stop early optimization

```shell
# Run Dijkstra's algorithms and returns an array that contains
# the shortest distance to every node from the start node s.
# g - adjacency list of weighted graph
# n - the number of the nodes in the graph
# s - the index of the starting node (0 <= s < = n)
function dijkstra(g, n, s, e):
    vis = [false, false, ..., false] #size n (visited)
    dist = [max, max, ..., max] #size n (distances): max = Integer.maxValue
    dist[s] = 0
    pq = empty priority queue
    pq.insert((s,0))
    while pq.size() != 0:
        index, minValue = pq.poll()
        vis[index] = true
        if dist[index] < minValue:
            continue
        for (edge: g[index]):
            if vis[edge.to]:
                continue 
            newDist= dist[index] + edge.cost
            if newDist < dist[edge.to]:
                dist[edge.to] = newDist
                pq.insert((edge.to, newDist))
        if index == e:
        return dist[e]
    return max
```

## Eager Dijkstra's using an Indexed Priority Queue
Our current lazy implementation of Dijkstra's insert `duplicate key-value pairs`<br>
(keys being the node index and the value being the shortest distance to get to that node) <br>
in our PQ because it's more efficient to insert a new key-value pair in `O(log(n))`<br>
than it is to update an existing key's value in `O(n)`

This approach is inefficient for dense graphs because we end up with <br>
`several stale outdated key-value pairs` in our PQ. The eager version of Dijkstra's <br>
avoids duplicate key-value paris and supports efficient value updates in `O(log(n))` by <br>
using an `Indexed Priority Queue`


### sudo code 

```shell
# Run Dijkstra's algorithms and returns an array that contains
# the shortest distance to every node from the start node s.
# g - adjacency list of weighted graph
# n - the number of the nodes in the graph
# s - the index of the starting node (0 <= s < = n)
function dijkstra(g, n, s):
    vis = [false, false, ..., false] #size n (visited)
    dist = [max, max, ..., max] #size n (distances)
    dist[s] = 0
    ipq = empty indexed priority queue
    ipq.insert((s,0))
    while ipq.size() != 0:
        index, minValue = pq.poll()
        vis[index] = true
        if dist[index] < minValue:
            continue
        for (edge: g[index]):
            if vis[edge.to]:
                continue 
            newDist= dist[index] + edge.cost
            if newDist < dist[edge.to]:
                dist[edge.to] = newDist
                if !ipq.contains(edge.to):
                    ipq.insert(edge.to, newDist)
                else:
                    ipq.decreaseKey(edge.to, newDist)
    return dist
```

