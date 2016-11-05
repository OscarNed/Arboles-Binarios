package arbolesbinarios;

/**
 *
 * @author OscarNedzelsky   A00513376
 */
public class ArbolesBinarios {

    public static void main(String[] args) {
        BinaryTree arbol = new BinaryTree();
         arbol.insertNode(5, arbol.root);
        arbol.insertNode(4, arbol.root);
        arbol.insertNode(7, arbol.root);
        arbol.insertNode(2, arbol.root);
        arbol.insertNode(6, arbol.root);
        arbol.insertNode(10, arbol.root);
        arbol.insertNode(3, arbol.root);
        arbol.insertNode(9, arbol.root);
        arbol.insertNode(8, arbol.root);
        arbol.insertNode(1, arbol.root);

        arbol.recorrerInOrder(arbol.root, false, false);
        System.out.println("");
        arbol.recorrerPostOrder(arbol.root,  false, false);
        System.out.println(",");
        arbol.recorrerPreOrder(arbol.root,  false, false);
        System.out.println("");
        System.out.println(""+arbol.elements+" "+arbol.Height(arbol.root));
        arbol.eraseNode(8, arbol.root,-1);
        arbol.recorrerInOrder(arbol.root,  false, false);System.out.println("");
        arbol.recorrerPostOrder(arbol.root,  false, false);System.out.println("");
        arbol.recorrerPreOrder(arbol.root,  false, false);System.out.println("");
         System.out.println(""+arbol.elements+" "+arbol.Height(arbol.root));
        arbol.eraseNode(7, arbol.root,-1);
        arbol.recorrerInOrder(arbol.root,  false, false);System.out.println("");
        arbol.recorrerPostOrder(arbol.root,  false, false);System.out.println("");
        arbol.recorrerPreOrder(arbol.root,  false, false);System.out.println("");
        System.out.println(""+arbol.elements+" "+arbol.Height(arbol.root));
         arbol.eraseNode(2, arbol.root,-1);
        arbol.recorrerInOrder(arbol.root,  false, false);System.out.println("");
        arbol.recorrerPostOrder(arbol.root,  false, false);System.out.println("");
        arbol.recorrerPreOrder(arbol.root,  false, false);System.out.println("");
System.out.println(""+arbol.elements+" "+arbol.Height(arbol.root));
    }
    
}
