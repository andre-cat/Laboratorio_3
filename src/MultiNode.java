public class MultiNode {

    private MultiNode next; // Nodo siguiente de este nodo (cabeza de sublista siguiente).
    private Node under; // Nodo conectado a la cabeza de la sublista actual.
    private int data;

    public MultiNode() {
        next = null;
        under = null;
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
     * @return MultiNode
     */
    public MultiNode next() {
        return next;
    }

    
    /** 
     * @param next
     */
    public void next(MultiNode next) {
        this.next = next;
    }

    
    /** 
     * @return Node
     */
    public Node under() {
        return under;
    }

    
    /** 
     * @param under
     */
    public void under(Node under) {
        this.under = under;
    }

    public void release() {
        next = null;
        under = null;
    }
}
