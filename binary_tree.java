
public class binary_tree {
    
    protected node root;
    
    binary_tree(node root){
        this.root = root;
    }
    
    public void inorderTreeWalk(node x){
        if(x != null){
            inorderTreeWalk(x.left);
            System.out.println(x.toString());
            inorderTreeWalk(x.right);
        }
    }
    
    public node treeSearch(node x, int key){
        if(key == x.key){
            return x;
        }
        if(key < x.left.key){
            treeSearch(x.left, key);
        } else {
            treeSearch(x.right, key);
        }
        return null;
    }
    
    public void treeInsertion(node x){
        node y = null;          //temporary parent
        node z = this.root;     //temporary root
        while(z != null){
            y = z;
            if(x.key < z.key ){
                z = z.left;
            } else {
                z = z.right;
            }
        }
        x.parent = y;
        if(y == null){
            this.root = x;
        } else if(x.key < y.key){
            y.left = x;
        } else {
            y.right = x;
        }
        
    }
    
    public void treeDeletion(node x){
        if(x.left == null){
            transplant(x, x.right);
        } else if(x.right == null){
            transplant(x,x.left);
        } else {
            node y = treeMin(x.right);   //successor of x
            if(y.parent != x){
                transplant(y, y.right);
                y.right = x.right;
                y.right.parent = y;
            }
            transplant(x,y);    //if y is x's right child
            y.left = x.left;
            y.left.parent = y;
        }
    }
    
    public void transplant(node u, node v){
        if(u.parent == null){
            this.root = v;
        } else if(u == u.parent.left){
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        if(v != null) {
            v.parent = u.parent;
        }
    }
    
    public node treeSuccesor(node x){
        if(x.right != null){
            return treeMin(x.right);
        }
        node y = x.parent;
        while(y != null && x == y.right){
            x = y;
            y = y.parent;
        }
        return y;
    }
    
    public node treePredecessor(node x){
        if(x.left != null){
            return treeMax(x.left);
        }
        node y = x.parent;
        while(y != null && x == y.left){
            x = y;
            y = y.parent;
        }
        return y;
    }
    
    
    public node treeMin(node x){
        if(x.left == null){
            treeMin(x.left);
        }
        return x;
    }
    
    public node treeMax(node x){
        if(x.left == null){
            treeMax(x.left);
        }
        return x;
    }

}
