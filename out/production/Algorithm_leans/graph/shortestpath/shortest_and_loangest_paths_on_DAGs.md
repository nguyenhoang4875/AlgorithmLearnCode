# Shortest and longest paths on DAGs
Recall that a *Directed Acyclic Graph (DAG)* is a graph with directed edges and no cycles. <br>
By definition this mean all *tree* are automatically DAGs since they do not contain cycles.

## SSPS on DAG
The *Single Source Shortest Path (SSSP)* problem can be solved efficiently on DAGs in `O(V+E)` time. <br>
This is due to the fact that the nodes can be ordered in a `topological ordering` via topological sort <br>
and processed sequentially.

## Longest path on DAG
On general graph this problem is `NP-Hard`, but on a DAG this problem isi solvable is `O(V+E)`

The trick is to multiply all edge values by `-1` then find the shorted path <br>
and then multiply the edge values by `-1` again

