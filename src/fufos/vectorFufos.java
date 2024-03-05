package fufos;
import java.util.Scanner;

public class vectorFufos {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese el tamaño del array:");
        int size = leer.nextInt();
        int[] column = new int[size];

        System.out.println("Ingrese los elementos del array (en el rango de 0 a 250):");
        for (int i = 0; i < size; i++) {
            int num = leer.nextInt();
            if (num < 0 || num > 250) {
                System.out.println("Error: El número debe estar en el rango de 0 a 250. Inténtelo de nuevo.");
                i--;
            } else {
                column[i] = num;
            }
        }

        System.out.println("Ingrese la posición inicial (en el rango de 0 a 250):");
        int solicitud = leer.nextInt();
        if (solicitud < 0 || solicitud > 250) {
            System.out.println("Error: La posición inicial debe estar en el rango de 0 a 250.");
            return;
        }

        int[] fufo = new int[size];
        int sumaTiempo = 0; 

        System.out.println("TABLA CON DATOS");
        System.out.println("Posición\tValor\tDiferencia con solicitud");
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                fufo[i] = Math.abs(column[i] - solicitud);
            } else {
                fufo[i] = Math.abs(column[i] - column[i - 1]);
            }
            sumaTiempo += fufo[i]; 
            System.out.println(i + "\t\t" + column[i] + "\t\t" + fufo[i]);
        }

        double promedio = (double) sumaTiempo / (size + 1); 
        System.out.println("El total del tiempo es: " + sumaTiempo);
        System.out.println("El promedio del tiempo es: " + promedio);
    }
}
