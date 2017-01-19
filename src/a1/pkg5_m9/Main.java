/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a1.pkg5_m9;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaume
 */
public class Main extends Cuenta {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaforo = new Semaphore(1, true);
        Cuenta cuenta = new Cuenta();
        Calendar calendario = new GregorianCalendar();

        

        final Runnable r = () -> {
            try {
                //Iniciar proceso critico
                semaforo.acquire();
                
                System.out.println("Saldo actual es: " + cuenta.getSaldo());
                float resultado = cuenta.ingressar(300);
                
                System.out.println(Thread.currentThread().getName() + "--"
                        + "--"
                        + resultado + "\n");
                
                cuenta.setSaldo(resultado);
                
                float resultado1 = cuenta.treure(50);
                System.out.println(Thread.currentThread().getName() + "--"
                        + "--"
                        + resultado1 + "\n");
                cuenta.setSaldo(resultado1);
                
                //Se avisa al semaforo para que pueden iniciar otros hilos
                semaforo.release();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        };

        new Thread(r).start();
        new Thread(r).start();
        //new Thread(r).start();

    }

}
