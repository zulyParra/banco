/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author DELL_COREI5
 */
public class Cuenta {
    private int numeroCuenta;
    private double saldo;

    public double getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double consignar(double valor){
        return this.saldo = this.saldo + valor;
    } 
    
    public double retirar(double valor){
        if (this.saldo == 1000) {
            System.out.println("Saldo insuficiente");
        }else{
            this.saldo = this.saldo - valor;
        }
        return this.saldo;
    }
}
