package arbolesbinarios;

/**
 *
 * @author OscarNedzelsky   A00513376
 */

public class NodeTree <T> {
    T data;
    NodeTree left;
    NodeTree right;
    
    public NodeTree(T data){
        this.data = data;
        left = null;
        right = null;
    }
}
