/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a1.pkg5_m9;

/**
 *
 * @author Jaume
 */
public class Cuenta {

    protected float saldo;

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

  

    public float llegirSaldo() {
        return this.saldo=this.getSaldo();

    }

    public float ingressar(float diners) {

        return this.saldo = this.saldo + diners;
    }

    public float treure(float diners) {
        return this.saldo = this.saldo - diners;
    }
}
