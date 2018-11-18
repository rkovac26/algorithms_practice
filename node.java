
public class node {
    
    protected int key;
    protected node parent;
    protected node left;
    protected node right;
    
    node(int key){
        this.key = key;
        this.parent = null;
        this.left = null;
        this.right = null;
    }
    
    node(int key, node parent, node left, node right){
        this.key = key;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
    
    public String toString(){
        return "Node key: " + Integer.toString(this.key);
    }
    



}
