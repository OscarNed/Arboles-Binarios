package arbolesbinarios;

/**
 *
 * @author OscarNedzelsky   A00513376
 */

public class BinaryTree <T> {
    NodeTree root;
    int elements;
    
    public BinaryTree(){
        this.root = null;
        this.elements = 0;
    }
    
    public void insertNode(T data, NodeTree root){
        NodeTree node = new NodeTree(data);
        if(eraseTree()){
            this.root = node;
            elements ++;
        } else {
            if ((int) node.data >= (int) root.data){
                if (node.left == null){
                    node.left = node;
                    elements ++;
                } else {
                    insertNode(data, root.left);
                }
            } else {
                if (root.right == null){
                    root.right = node;
                    elements ++;
                } else {
                    insertNode(data, root.right);
                }
            }
        }
        
    }
    
    public boolean roots(NodeTree n, int datan){
        if (n == null){
            return false;
        }
        if (n.right == null && n.left == null){
            return false;
        }
        if (n.left == null){
            return (int) n.right.data != datan;
        }
        if (n.right == null){
            return (int) n.left.data != datan;
        }
        return (int) n.left.data != datan && (int) n.right.data != datan;
    }
    
    public boolean compare(NodeTree n, int datan){
        if (n == null){
            return false;
        }
        return n.data.equals(datan);
    }
    
    public int Height(NodeTree n){
        if(n == null){
            return -1;
        } else {
            return 1 + Math.max(Height(n.left), Height(n.right));
        }
    }
    
    public boolean Leave(NodeTree n){
        if (n == null){
            return false;
        }
        return n.left == null && n.right == null;
    }
    
    public boolean Children(NodeTree n){
        if (n == null){
            return false;
        }
        if (n.left == null && n.right == null){
            return false;
        }
        if (n.left == null && n.right == null){
            return true;
        }
        if (n.right == null && n.left != null){
            return true;
        }
        return n.left != null || n.right != null;
    }
    
    public NodeTree returnSubstitute(NodeTree n){
        if (n.left == null){
            return n.right;
        } else {
            if (n.left.right == null){
                return n.left;
            } else {
                n = n.left.right;
                while (n.right != null){
                    n = n.right;
                }
                return n;
            }
        }
    }
    
    public boolean searchNode(int data, NodeTree root){
        if (root == null){
            return false;
        }
        if ((int) root.data == (data)){
            return true;
        }
        if((int) root.data < data){
            return searchNode(data, root.left);
        }
        if((int) root.data > data){
            return searchNode(data, root.right);
        }
        return searchNode(data, root);
    }
    
    public void recorrerInOrder(NodeTree root, boolean right, boolean left){
        while (right == false && root.right != null){
            recorrerInOrder(root.right, right, false);
            right = true;
        }
        System.out.println("|" + root.data + "| ");
        while (root.left != null && left == false){
            recorrerInOrder(root.left, false, left);
            left = true;
        }
    }
    
    public void recorrerPostOrder(NodeTree root, boolean right, boolean left){
        while (right == false && root.right != null){
            recorrerPostOrder(root.right, right, false);
            right = true;
        }
        while (root.left != null && left == false){
            recorrerPostOrder(root.left, false, left);
            left = true;
        }
        System.out.println("|" + root.data + "| ");
    }
    
    public void recorrerPreOrder(NodeTree root, boolean right, boolean left){
        System.out.println("|" + root.data + "| ");
        while (right == false && root.right != null){
            recorrerPreOrder(root.right, right, false);
        }
        while (root.left != null && left == false){
            recorrerPreOrder(root.left, false, left);
            left = true;
        }
    }
            
    public void eraseNode(int data, NodeTree root, int i){
        if(searchNode(data, root)){
            while(roots(root, data)){
                if(data > (int) root.data){
                    root = root.left;
                } else {
                    if (data < (int) root.data){
                        root = root.right;
                    }
                }
            }
            if (compare(root.left, data)){
                if(Leave(root.left)){
                    root.left = null;
                }
                if (Children(root.left)){
                    NodeTree aux = returnSubstitute(root.left);
                    eraseNode((int) aux.data, root.left, 0);
                    root.left.data = aux.data;
                }
            }
            if(compare(root.right, data)){
                if(Leave(root.right)){
                    root.right = null;
                }
                if (Children(root.right)){
                    NodeTree aux = returnSubstitute(root.right);
                    eraseNode((int) aux.data, root.right, 0);
                    root.right.data = aux.data;
                }
            }
            elements = elements + i;
        } else {
            System.out.println("No se encontró el dato en el árbol");
        }
    }
    
    public boolean eraseTree(){
        return this.root == null;
    }
}