/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.Scanner;

/**
 *
 * @author DELL_COREI5
 */
public class Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner objLeer = new Scanner(System.in);
        Cliente objCliente = new Cliente();
        Cuenta[] cuentas = new Cuenta[5];

        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] = new Cuenta();
            int aleatorio = (int) (Math.random() * 9999 + 1000);
            cuentas[i].setNumeroCuenta(aleatorio);
            cuentas[i].setSaldo(1000);
        }

        int opcion;
        double valor, numeroCuenta;
        boolean bandera;

        do {
            System.out.println("\n");
            System.out.println("------Bienvenido al Banco de Hierro de la Isla de Braavos------");
            System.out.println("--------------Acá podrás ahorrar de manera segura--------------");
            System.out.println("\n");
            System.out.println("-----------------------1. Ingresar Cliente---------------------");
            System.out.println("-----------------------2. Consultar cuentas--------------------");
            System.out.println("-----------------------3. Consignar dinero---------------------");
            System.out.println("-----------------------4. Retirar dinero-----------------------");
            System.out.println("-----------------------5. consultar saldo----------------------");
            System.out.println("-----------------------0. Salir--------------------------------");

            System.out.print("\nDigite una opción: ");

            opcion = objLeer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n");
                    System.out.print("Por favor ingrese el nombre del cliente: ");
                    objCliente.setNombre(objLeer.next());
                    System.out.print("Por favor ingrese el apellido del cliente: ");
                    objCliente.setApellido(objLeer.next());
                    System.out.print("Por favor ingrese el número de cédula del cliente: ");
                    objCliente.setCedula(objLeer.next());
                    break;
                case 2:
                    String nombre = objCliente.getNombre();
                    if (nombre == null) {
                        System.out.println("\n");
                        System.out.println("----------------------Advertencia!!!------------------------");
                        System.out.println("No puede consultar cuentas si no existe un cliente asociado");
                        System.out.println("---------------Por favor digite la opción 1----------------");
                        System.out.println("\n");
                    } else {
                        System.out.println("\n");
                        System.out.println("Nombre cliente: " + objCliente.getNombre() + " " + objCliente.getApellido());
                        System.out.println("Identificación: " + objCliente.getCedula());
                        for (int i = 0; i < cuentas.length; i++) {
                            System.out.println("Cuenta " + (i + 1) + " número: " + cuentas[i].getNumeroCuenta());
                        }
                    }
                    break;
                case 3:
                    System.out.println("\n");
                    System.out.print("Por favor ingrese el numero de cuenta al cual desea consignar: ");
                    numeroCuenta = objLeer.nextDouble();
                    bandera = false;
                    for (int i = 0; i < cuentas.length; i++) {
                        if (cuentas[i].getNumeroCuenta() == numeroCuenta) {
                            System.out.print("Por favor ingrese el valor a consignar: ");
                            valor = objLeer.nextDouble();
                            cuentas[i].consignar(valor);
                            bandera = true;
                        }
                    }
                    if (!bandera) {
                        System.out.println("El numero de cuenta ingresado no existe");
                    }
                    break;
                case 4:
                    System.out.println("\n");
                    System.out.print("Por favor ingrese el numero de cuenta al cual desea retirar: ");
                    numeroCuenta = objLeer.nextDouble();
                    bandera = false;
                    for (int i = 0; i < cuentas.length; i++) {
                        if (cuentas[i].getNumeroCuenta() == numeroCuenta) {
                            System.out.print("Por favor ingrese el valor a retirar: ");
                            valor = objLeer.nextDouble();
                            cuentas[i].retirar(valor);
                            bandera = true;
                        }
                    }
                    if (!bandera) {
                        System.out.println("El numero de cuenta ingresado no existe");
                    }
                    break;
                case 5:
                    System.out.println("\n");
                    System.out.print("Por favor ingrese el numero de cuenta que desea consultar: ");
                    numeroCuenta = objLeer.nextDouble();
                    bandera = false;
                    for (int i = 0; i < cuentas.length; i++) {
                        if (cuentas[i].getNumeroCuenta() == numeroCuenta) {
                            System.out.println("Nombre cliente: " + objCliente.getNombre() + " " + objCliente.getApellido());
                            System.out.println("Identificación: " + objCliente.getCedula());
                            System.out.println("El saldo de la cuenta número " + cuentas[i].getNumeroCuenta() + " es " + cuentas[i].getSaldo());
                            bandera = true;
                        }
                    }
                    if (!bandera) {
                        System.out.println("El numero de cuenta ingresado no existe");
                    }
                default:
                    System.out.println("Digite una opción válida");
                    break;
            }

        } while (opcion != 0);

    }

}
