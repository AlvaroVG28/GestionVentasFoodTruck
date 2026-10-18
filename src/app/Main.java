package app;

import java.util.Scanner;

public class Main {

    // 1. PRIMERO: Crear el proyecto (Atributos globales y constantes)
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final double META_VENTAS = 500_000;

    public static void main(String[] args) {
        // 2. SEGUNDO: Declaración de los arreglos
        String[] productos = {"Hamburguesas", "Perros Calientes", "Papas Fritas"};
        String[] turnos = {"Almuerzo", "Tarde", "Noche", "Madrugada"};
        double[][] ventas = new double[productos.length][turnos.length];

        // Llamado a los métodos principales
        registrarVentas(productos, turnos, ventas);
        calcularReportes(productos, ventas);
    }

    private static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    // 3. TERCERO: Método de registrar ventas
    private static void registrarVentas(String[] productos, String[] turnos, double[][] ventas) {
        mostrarMensaje("==========================================================");
        mostrarMensaje("            REGISTRO DE VENTAS POR TURNO                  ");
        mostrarMensaje("==========================================================");

        for (int i = 0; i < productos.length; i++) {
            mostrarMensaje("");
            mostrarMensaje("--- Producto: " + productos[i] + " ---");

            for (int j = 0; j < turnos.length; j++) {
                String mensaje = "Ingrese ventas para Turno [" + turnos[j] + "]: $ ";
                ventas[i][j] = leerDato(mensaje);
            }
        }

        mostrarMensaje("");
        mostrarMensaje(" Registro de ventas completado y validado exitosamente.");
    }
    // 4. CUARTO: Validación (Método para leer y validar el dato)
    private static double leerDato(String mensaje) {
        while (true) {
            System.out.print(mensaje);

            if (!SCANNER.hasNextDouble()) {
                mostrarMensaje("Error: Ingrese un valor númerico valido");
                SCANNER.next();
                continue;
            }

            double venta = SCANNER.nextDouble();
            if (venta < 0) {
                mostrarMensaje("Error: El valor no puede ser negativo. Intente de nuevo");
                continue;
            }
            return venta;
        }
    }
    // 5. QUINTO: Método reporte
    private static void calcularReportes(String[] productos, double[][] ventas) {
        double totalGeneral = 0;

        mostrarMensaje("");
        mostrarMensaje("==========================================================");
        mostrarMensaje("               REPORTE FINANCIERO FINAL                   ");
        mostrarMensaje("==========================================================");
        mostrarMensaje("--- TOTAL RECAUDADO POR PRODUCTO ---");

        for (int i = 0; i < productos.length; i++) {
            double totalProducto = 0;

            for (int j = 0; j < ventas[i].length; j++) {
                totalProducto += ventas[i][j];
            }

            mostrarMensaje("Total " + productos[i] + ": $" + totalProducto);
            totalGeneral += totalProducto;
        }

        mostrarMensaje("----------------------------------------------------------");
        mostrarMensaje("TOTAL GENERAL RECAUDADO POR EL FOOD TRUCK: $" + totalGeneral);
        mostrarMensaje("----------------------------------------------------------");

        if (totalGeneral > META_VENTAS) {
            mostrarMensaje("ESTADO:  Meta de Ventas Alcanzada!");
        } else {
            mostrarMensaje("ESTADO: Meta No Alcanzada.");
        }

        mostrarMensaje("==========================================================");
    }
}
