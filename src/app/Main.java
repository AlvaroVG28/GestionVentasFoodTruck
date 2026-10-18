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
    }