import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.util.Locale;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;

    protected Cliente cliente;


    public Conta(Cliente cliente) {

        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;

    }

    @Override
    public void sacar(double valor) {
        if (saldo <= 0) {
            throw new RuntimeException("--------- O saldo é insuficiente para saque ---------".toUpperCase());
//            this.saldo += valor;
//            System.out.println("Saldo insuficiente para saque");
        }

        this.saldo -= valor;


    }

    @Override
    public void depositar(double valor) {

        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (saldo <= 0) {
            throw new RuntimeException("O saldo é insuficiente para transferir".toUpperCase());
        }
        this.sacar(valor);
        contaDestino.depositar(valor);

    }


    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {

        return saldo;
    }

    protected void imprimirInfosComuns() {

        System.out.println(String.format("Titular: %s", this.cliente.getNome().toUpperCase()));
        System.out.println(String.format("CPF: %s", this.cliente.getCPF()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("saldo: %.2f", this.saldo));

    }


}
