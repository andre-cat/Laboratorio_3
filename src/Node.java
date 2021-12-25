public class Node {

    private Node link; // Nodo siguiente de este nodo.
    private int data;

    public Node() {
        link = null;
        data = 0;
    }

    
    /** 
     * @return int
     */
    public int info() {
        return data;
    }

    
    /** 
     * @param data
     */
    public void info(int data) {
        this.data = data;
    }

    
    /** 
     * @return Node
     */
    public Node link() {
        return link;
    }

    
    /** 
     * @param link
     */
    public void link(Node link) {
        this.link = link;
    }

    public void release() {
        link = null;
    }
}