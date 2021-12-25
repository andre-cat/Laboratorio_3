public class Node1 {
    // Nodo con un solo puntero.

    private int data;
    private int row;
    private int column;
    private Node1 next; // Nodo siguiente de este nodo.

    public Node1(int row, int column) {
        data = 0;
        this.row = row;
        this.column = column;
        next = null;
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
     * @return int
     */
    public int row() {
        return row;
    }

    
    /** 
     * @param row
     */
    public void row(int row) {
        this.row = row;
    }

    
    /** 
     * @return int
     */
    public int column() {
        return column;
    }

    
    /** 
     * @param column
     */
    public void column(int column) {
        this.column = column;
    }

    
    /** 
     * @return Node1
     */
    public Node1 next() {
        return next;
    }

    
    /** 
     * @param next
     */
    public void next(Node1 next) {
        this.next = next;
    }

    public void release() {
        next = null;
    }
}