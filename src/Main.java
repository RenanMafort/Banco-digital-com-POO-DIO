public class Main {
    public static void main(String[] args) {
        Cliente renan = new Cliente();
        renan.setNome("Renan Mafort Sereia");
        renan.setCPF("089.350.456-78");

        Conta cc = new ContaCorrente(renan);
        Conta poupanca = new ContaPoupanca(renan);


        //Conta Corrente;
        cc.depositar(1000);
        cc.sacar(150);
        cc.transferir(300, poupanca);

        //Conta popupanca
        poupanca.depositar(1000);
        poupanca.sacar(150);
        poupanca.transferir(300,cc);




        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

    }
}
