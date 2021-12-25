public class Multi {
    // Clase de multilista.

    private MultiNode head;
    private MultiNode tail;
    private int no_ceros; // Or size.
    private int rows;
    private int columns;

    public Multi(int rows, int columns) {
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
        no_ceros++;

        MultiNode multi_node = new MultiNode();
        multi_node.info(data);
        if (this.head == null) {
            this.head = multi_node;
            this.tail = multi_node;
        } else {
            this.tail.next(multi_node);
            this.tail = multi_node;
        }
        this.tail.next(null);

        Node fila = new Node();
        Node columna = new Node();

        fila.info(row);
        columna.info(column);

        multi_node.under(fila);
        fila.link(columna);
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
            MultiNode multi_node = head;
            for (int i = 1; i <= no_ceros; i++) {
                Node node = multi_node.under();
                if (node.info() == row & node.link().info() == column) {
                    info = multi_node.info();
                } else {
                    multi_node = multi_node.next(); // Posicionamiento en la cabeza de la lista siguiente.
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
            MultiNode multi_node = head;
            System.out.println(rows + "×" + columns + ":");
            do {
                System.out.println(multi_node.info() + " -> " + multi_node.under().info() + " -> "
                        + multi_node.under().link().info() + " -> null");
                System.out.println("↓");
                if (multi_node.next() == null) {
                    System.out.println("null\n");
                }
                multi_node = multi_node.next();
            } while (multi_node != null);
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