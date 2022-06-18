# Rooting a tree
Sometimes it's useful to root an undirected tree
to add structure to the problem you are trying to solve.

Conceptually this is like "picking upp" the tree by a specific node
and having all the edges point downwards.

You can root a tree using any yof its nodes.

In some situation it's also useful to keep have
a reference to the parent node in order to walk up the tree

Rooting a tree is easily done depth first.


```shell
# TreeNode object structure
class TreeNode
    # Unique integer id to identify this node.
    int id;
    
    # Pointer to parent TreeNode reference. Only the 
    # root node has a null parent TreeNode reference.
    
    # List of pointers to child TreeNodes.
    TreeNode[] children;
```

```shell
# g is the graph/tree represented as an adjacency
# list with undirected edges. If there's an edge between
# (u, v) there's also an edge between (v, u).
# rootId is the id of the node to root the tree from.

function rootTree(g, rootId = 0):
    root = TreeNode(rootId, null, [])
    return buildTree(g, root, null)
    
# Build tree recursively depth first.
function buildTree(g, node, parent):
    for childId in g[node.id]:
        # Avoid adding an edge pointing back to the parent.
        if parent != null and childId == parent.id:
            continue
        child = TreeNode(childId, node, [])
        node.children.add(child)
        buildTree(g, child, node)
    return tree
    


```