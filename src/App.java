import java.util.Scanner;

public class App {

    /**
     * Método principal donde se seleccionan las representaciones de lista deseadas para la matriz dispersa.
     * @author Andrea Arias.
     * @author Aiker Acosta.
     * @author Nilson Díaz.
     * @author Margareth Suárez.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        int filas = 0, columnas = 0;

        Scanner lector = new Scanner(System.in);

        System.out.println("\n-----LABORATORIO 3-----");

        boolean error;

        do {
            System.out.println();
            error = false;
            try {
                System.out.print("Número de filas de la matriz: ");
                String cadena = lector.next();
                filas = Integer.parseInt(cadena);
            } catch (Exception e) {
                error = true;
                System.out.println("Solamente se ingresan datos numéricos positivos (!).\n");
            }
        } while (error == true | filas < 1);

        do {
            error = false;
            try {
                System.out.print("Número de columnas de la matriz: ");
                String cadena = lector.next();
                columnas = Integer.parseInt(cadena);
            } catch (Exception e) {
                error = true;
                System.out.println("Solamente se ingresan datos numéricos positivos (!).\n");
            }
        } while (error == true | columnas < 1);

        System.out.println();

        int[][] matriz = new int[filas][columnas];

        int ceros, no_ceros;
        int cantidad = 1;
        do {
            ceros = 0;
            no_ceros = 0;

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {

                    do {
                        error = false;
                        try {
                            System.out.print("Digita el número en la posición [" + i + "]" + "[" + j + "]: ");
                            String cadena = lector.next();
                            matriz[i][j] = Integer.parseInt(cadena);
                        } catch (Exception e) {
                            error = true;
                            System.out.print("Solamente se ingresan números enteros (!).\n\n");
                        }
                    } while (error == true);

                    if (matriz[i][j] == 0) {
                        ceros++;
                    } else {
                        if (Integer.toString(matriz[i][j]).length() > cantidad) {
                            cantidad = Integer.toString(matriz[i][j]).length();
                        }
                        no_ceros++;
                    }
                }
            }

            if (no_ceros > ceros | no_ceros >= ceros) {
                System.out.println(
                        "\nLa matriz no es una matriz dispersa (no tiene más ceros que otro número); se llenará otra vez.\n");
            }
        } while (no_ceros > ceros | no_ceros >= ceros);

        System.out.print("\nMatriz " + filas + "×" + columnas + ":\n\n");
        print_matrix(matriz, cantidad);

        boolean respuesta = true;
        while (respuesta == true) {
            System.out.println(
                    "\n¿Cómo desea representar la matriz anterior? 'Como una...':\n1. Lista simplemente enlazada.\n2. Lista doblemente enlazada.\n3. Multilista.\n");

            int opción = 0;

            do {
                error = false;
                try {
                    String cadena = lector.next();
                    opción = Integer.parseInt(cadena);
                } catch (Exception e) {
                    error = true;
                    System.out.println("Solamente se ingresan datos enteros entre 1 y 3 (!).\n");
                }
            } while (error == true | (opción != 1 & opción != 2 & opción != 3));

            System.out.println(); 

            int[][] nueva = new int[1][1];

            switch (opción) {
            case 1:
                Simple simple = new Simple(filas, columnas);
                cantidad = 1;

                for (int i = 0; i < simple.rows(); i++) {
                    for (int j = 0; j < simple.columns(); j++) {
                        if (matriz[i][j] != 0) {
                            simple.add(matriz[i][j], i, j);
                            if (Integer.toString(matriz[i][j]).length() > cantidad) {
                                cantidad = Integer.toString(matriz[i][j]).length();
                            }
                        }
                    }
                }

                System.out.println("- Representación de la matriz como lista simplemente enlazada:");
                System.out.println(
                        "  [Filas_Matriz×Columnas_Matriz]: [Fila_Nodo][Columna_Nodo] Dato_Nodo -> ... -> null\n");
                simple.print();

                System.out.println("- Conversión de la estructura anterior a matriz:\n");
                nueva = simple.matrix();
                break;

            case 2:
                Double doble = new Double(filas, columnas);
                cantidad = 1;

                for (int i = 0; i < doble.rows(); i++) {
                    for (int j = 0; j < doble.columns(); j++) {
                        if (matriz[i][j] != 0) {
                            doble.add(matriz[i][j], i, j);
                            if (Integer.toString(matriz[i][j]).length() > cantidad) {
                                cantidad = Integer.toString(matriz[i][j]).length();
                            }
                        }
                    }
                }

                System.out.println("- Representación de la matriz como lista doblemente enlazada:");
                System.out.println(
                        "  [Filas_Matriz×Columnas_Matriz]: null <- [Fila_Nodo][Columna_Nodo] Dato_Nodo <-> ... -> null\n");
                doble.print();

                System.out.println("- Conversión de la estructura anterior a matriz:\n");
                nueva = doble.matrix();
                break;

            case 3:
                Multi multi = new Multi(filas, columnas);
                cantidad = 1;

                for (int i = 0; i < multi.rows(); i++) {
                    for (int j = 0; j < multi.columns(); j++) {
                        if (matriz[i][j] != 0) {
                            multi.add(matriz[i][j], i, j);
                            if (Integer.toString(matriz[i][j]).length() > cantidad) {
                                cantidad = Integer.toString(matriz[i][j]).length();
                            }
                        }
                    }
                }

                System.out.println("- Representación de la matriz como multilista:");
                System.out.println("  [Filas_Matriz×Columnas_Matriz]:");
                System.out.println("  Dato_Matriz -> Fila_Dato -> Columna_Dato");
                System.out.println("   ↓");
                System.out.println("  ...");
                System.out.println("   ↓");
                System.out.println("  null\n");
                multi.print();

                System.out.println("- Conversión de la estructura anterior a matriz:\n");
                nueva = multi.matrix();
                break;
            }
            print_matrix(nueva, cantidad);

            System.out.println("\n¿Desea elegir otra representación? 'Sí' = 1; 'No' = 0.");

            do {
                error = false;
                try {
                    int número = lector.nextInt();
                    if (número != 0 && número != 1) {
                        error = true;
                        System.out.println("Se ingresan datos enteros entre 0 y 1 (!).\n");
                    } else if (número == 0) {
                        respuesta = false;
                    }
                } catch (Exception e) {
                    error = true;
                    System.out.println("Error: Solamente se ingresan datos enteros entre 0 y 1 (!).\n");
                }
            } while (error == true);
        }
        
        lector.close();

        System.out.println("\nMuchas gracias por usar este programa.");
    }

    /**
     * Método para imprimir matrices N×M
     * @param matrix
     * @param cantidad
     */
    public static void print_matrix(int[][] matrix, int cantidad) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                String espacio = "";
                while (espacio.length() < Math.abs(cantidad - Integer.toString(matrix[i][j]).length())) {
                    espacio += " ";
                }
                System.out.print("[" + espacio + matrix[i][j] + "]");
            }
            System.out.print("\n");
        }
    }
}