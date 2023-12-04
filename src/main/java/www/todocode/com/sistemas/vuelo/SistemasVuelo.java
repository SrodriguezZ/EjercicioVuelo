package www.todocode.com.sistemas.vuelo;

import java.util.Scanner;

public class SistemasVuelo {

    public static void main(String[] args) {
        //Ingreso por teclado
        Scanner teclado = new Scanner(System.in);
        var bandera = false;
        int destino = 0, horario = 0, asientos, pesoMaleta=0;
        String resp, mulHora, respMaleta;
        //asiento 100 
        //Matrices
        int vuelos[][] = new int[2][3];
        for (int f = 0; f < 2; f++) {
            for (int c = 0; c < 3; c++) {
                //Ingreso para nivel adminitrativo de vuelo para los asientos de los vuelos
                System.out.println("Ingrese  el  numero de asientos disponible de los vuelos " + "de la: " + f + "-" + c);
                vuelos[f][c] = teclado.nextInt();
            }
        }
        //Logica de Usuario
        while (bandera != true) {
            boolean multa = false;
            while (!multa) {
                System.out.println("Desea comprar Vuelo SI:S - Cualqier otra letra, :Cancelacion del vuelo(Hora no establecida 20%multa)");
                mulHora = teclado.next();
                if (mulHora.equalsIgnoreCase("S")) {
                    multa = true;

                } else {

                    System.out.println("Cancelacion de vuelo  ok");
                    multa = true;

                }
                //Figura de mi vuelo
                System.out.println("Desea ver el asientos de los vuelos disponible: S:si, No cualquier leta");
                resp = teclado.next();
                if (resp.equalsIgnoreCase("S")) {
                    dibujarVuelo(vuelos);

                }

                boolean seguridad = false;
                while (seguridad != true) {
                    System.out.println("-----Bienvenido Vuelos Seguros------");
                    System.out.println("0-Ecuador");
                    System.out.println("1-Colombia");
                    System.out.println("Ingrese el destino de vuelo:");
                    destino = teclado.nextInt();
                    System.out.println("Ingrese el horario de vuelo");
                    System.out.println("0- Mañana");
                    System.out.println("1 - Medio Dia");
                    System.out.println("2 - Noche");
                    horario = teclado.nextInt();
                    if (destino >= 0 && destino <= 1) {
                        if (horario >= 0 && horario <= 2) {
                            seguridad = true;
                        } else {
                            System.out.println("Numero de Horario no es valido, vuelva intentarlo");
                        }
                    } else {
                        System.out.println("Numero de Destino no es valido, vuelva intentar.");
                    }
                }
                //Menu

                System.out.println("Ingrese la cantidad de asientosa que desea: ");
                asientos = teclado.nextInt();
                if (destino >= 0 && destino <= 1) {
                    if (horario >= 0 && horario <= 3) {
                        if (vuelos[destino][horario] >= asientos) {
                            System.out.println("Compra exitosa");
                            vuelos[destino][horario] -= asientos;
                            //Validacion de maleta y capacidad
                            boolean maleta = false;
                            while(!maleta){
                                System.out.println("Viaja con equipaje: SI:s o No:Cualquier otra letra");
                                respMaleta = teclado.next();
                                if(respMaleta.equalsIgnoreCase("S")){
                                    System.out.println("Ingrese el peso de la maleta 0kg hasta 20 kg: ");
                                    pesoMaleta = teclado.nextInt();
                                    if(pesoMaleta >=0 && pesoMaleta <=20){
                                        System.out.println("Maleta ingrada con exito");
                                        maleta = true;
                                    }else{
                                        System.out.println("Peso excedido, revise maleta. Peso maximo 20KG");
                                    }
                                }
                            }
                        } else {
                            System.out.println("Asientos agotados, favor vuelva intentar en otro horario:");
                        }

                    } else {
                        System.out.println("Horario incorrecto, vuelva intentarlo ");
                    }
                } else {
                    System.out.println("Numero de destino incorrecto, vuelva intentarlo: ");
                }
                System.out.println("Desea Salir S: si, Cualquier otra letra NO");
                resp = teclado.next();
                if (resp.equalsIgnoreCase("S")) {
                    bandera = true;
                }

            }

        }

    }   
//Metodo que nos ayuda a visualizar los vuelos
    static void dibujarVuelo(int vuelos[][]) {
        for (int f = 0; f < 2; f++) {
            System.out.print(f + " - :");
            for (int c = 0; c < 3; c++) {
                System.out.print(" [" + vuelos[f][c] + "] ");
            }
            System.out.println();
        }
    }
}
