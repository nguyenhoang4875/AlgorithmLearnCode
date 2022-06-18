# Beginner Tree Algorithms
## 1. Leaf node sum 

```shell
#Sum up leaf node values in a tree.
# Call function like: leafSum(root)
function leafSum(node):
    #Handle empty tree case 
    if node == null:
        return 0;
    if isLeaf(node):
        return node.getValue()
    total = 0
    for child in node.getChildNodes():
        total += leafSum(child)
    return total

function isLeaf(node):
    return node.getChildNodes().size() == 0
```

## 2. Tree height
```shell
# The height of a tree is the nuber of 
# edges from the root to the lowest leaf.
function treeHeight(node):
    # Handle empty tree case
    if node == null:
        return -1;
    # Identify leaf node and return zero
    if node.left == null and node.right == null:
        return 0;
    return max(treHeight(node.left), treeHeight(node.right))+1
```
### OR
```shell
# The height of a tree is the nuber of 
# edges from the root to the lowest leaf.
function treeHeight(node):
    # Handle empty tree case
    if node == null:
        return -1;
    return max(treHeight(node.left), treeHeight(node.right))+1
```
