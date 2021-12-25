public class Double {
    // Clase de lista doblemente enlazada no circular.

    private Node2 head;
    private Node2 tail;
    private int no_ceros; // Or size.
    private int rows;
    private int columns;

    public Double(int rows, int columns) {
        head = null;
        tail = null;
        no_ceros = 0;
        this.rows = rows;
        this.columns = columns;
    }

    /**
     * @return int
     */
    public int no_ceros() {
        return no_ceros;
    }

    /**
     * @return int
     */
    public int ceros() {
        return ((rows * columns) - no_ceros);
    }

    /**
     * @return int
     */
    public int rows() {
        return rows;
    }

    /**
     * @param rows
     */
    public void rows(int rows) {
        this.rows = rows;
    }

    /**
     * @return int
     */
    public int columns() {
        return columns;
    }

    /**
     * @param columns
     */
    public void columns(int columns) {
        this.columns = columns;
    }

    /**
     * @param data
     * @param row
     * @param column
     */
    // add: add_after_all
    public void add(int data, int row, int column) {
        if (row < 0 | column < 0 | row >= rows | column >= columns) {
            System.out.print("Índice fuera del tamaño.\n");
        } else {
            Node2 node = new Node2(row, column);
            node.info(data);
            if (head == null) {
                head = node;
                tail = node;
                head.left(null);
            } else {
                node.left(tail);
                tail.right(node);
                tail = node;
            }
            tail.right(null);
            no_ceros++;
        }
    }

    /**
     * @param row
     * @param column
     * @return int
     */
    public int info(int row, int column) {
        int info = 0;
        if (row < 0 | column < 0 | row >= rows | column >= columns) {
            System.out.print("índice fuera del tamaño.\n");
        } else {
            Node2 node = head;
            for (int i = 1; i <= no_ceros; i++) {
                if (node.row() == row & node.column() == column) {
                    info = node.info();
                } else {
                    node = node.right();
                }
            }
        }
        return info;
    }

    /**
    * Método para imprimir una representación de flechas de la estructura actual.
    */
    public void print() {
        if (head != null) {
            Node2 node = head;
            System.out.print(rows + "×" + columns + ": null <- ");
            do {
                System.out.print("[" + node.row() + "]" + "[" + node.column() + "] " + node.info());
                if (node.right() != null) {
                    System.out.print(" <-> ");
                } else {
                    System.out.println(" -> null\n");
                }
                node = node.right();
            } while (node != null);
        } else {
            System.out.print("Esta estructura está vacía porque todos los valores de la matriz son iguales a 0.\n\n");
        }
    }

    /**
     * @return int[][]
     */
    public int[][] matrix() {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = info(i, j);
            }
        }
        return matrix;
    }
}
