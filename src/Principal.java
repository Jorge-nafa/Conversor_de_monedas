import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner teclado=new Scanner(System.in);
        int opcion=0;
        String moneda;
        Conversor conversor=new Conversor();
        String menu= """
                
                ****************************************
                1) Dolar -------------> Peso argentino
                2) Peso argentino ----> Dolar 
                3) Dolar -------------> Peso colombiano
                4) Peso colombiano ---> Dolar 
                5) Dolar -------------> Real brasileño
                6) Real brasileño ----> Dolar 
                7) Dolar--------------> Otra moneda
                8) Otra moneda--------> Dolar 
                9) SALIR
                ***************************************
                
                """;

        while (true){
            System.out.println(menu);
            System.out.println("Elije una opcion:");
            try {
                opcion=teclado.nextInt();
            }catch (Exception e){
                System.out.println("Caracter no valido");
                teclado.next();
            }

            switch (opcion) {
                case 1:
                    conversor.VenderDolar("ARS");
                    break;
                case 2:
                    conversor.ComprarDolar("ARS");
                    break;
                case 3:
                    conversor.VenderDolar("COP");
                    break;
                case 4:
                    conversor.ComprarDolar("COP");
                    break;
                case 5:
                    conversor.VenderDolar("BRL");
                    break;
                case 6:
                    conversor.ComprarDolar("BRL");
                    break;
                case 7:
                    System.out.println("Cual moneda desea comprar:");
                    moneda=teclado.next();
                    conversor.VenderDolar(moneda);
                    break;
                case 8:
                    System.out.println("Cual moneda desea vender:");
                    moneda=teclado.next();
                    conversor.ComprarDolar(moneda);
                    break;
                case 9:
                    System.out.println("------------------------Vuelve pronto------------------------");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
            if (opcion==9) break;
        }
        System.out.println(conversor.getHistorialConversiones());
    }
}
