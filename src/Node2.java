public class Node2 {
    // Nodo con dos punteros.

    private int data;
    private int row;
    private int column;
    private Node2 left; // Nodo a la izquierda de este nodo.
    private Node2 right; // Nodo a la derecha de este nodo.

    public Node2(int row, int column) {
        data = 0;
        this.row = row;
        this.column = column;
        left = null;
        right = null;
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
     * @return Node2
     */
    public Node2 right() {
        return right;
    }

    
    /** 
     * @param right
     */
    public void right(Node2 right) {
        this.right = right;
    }

    
    /** 
     * @return Node2
     */
    public Node2 left() {
        return left;
    }

    
    /** 
     * @param left
     */
    public void left(Node2 left) {
        this.left = left;
    }

    public void release() {
        right = null;
        left = null;
    }
}