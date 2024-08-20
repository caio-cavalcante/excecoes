public class ContaCorrente {
    float limite;
    float saldo;
    float valorLimite;

    public ContaCorrente(float saldo, float valorLimite) {
        if (saldo < 0 || valorLimite < 0) {
            throw new IllegalArgumentException("Saldo e limite não podem ser negativos.");
        }
        this.saldo = saldo;
        this.valorLimite = valorLimite;
        this.limite = valorLimite;
    }

    public void sacar(float valor){
        if (valor < 0) {
            throw new IllegalArgumentException("O saque não pode ser negativo.");
        }
        if (valor > saldo + limite) {
            throw new IllegalArgumentException("Saldo e limite insuficientes.");
        }
        saldo -= valor;
        if (saldo < 0) {
            limite += saldo;
            saldo = 0;
        }
    }

    public void depositar(float valor){
        if (valor < 0) {
            throw new IllegalArgumentException("O depósito não pode ser negativo.");
        }
        saldo += valor;
        if (saldo > 0 && limite < valorLimite) {
            limite += saldo;
            saldo = 0;
        }
    }

    public void setValorLimite(float valor){
        if (valor < 0) {
            throw new IllegalArgumentException("O limite não pode ser negativo.");
        }
        valorLimite = valor;
        if (valor < limite) {
            limite = valor;
        }
    }

    public float getSaldo() {return saldo;}

    public float getLimite() {return limite;}

    public float getValorLimite() {return valorLimite;}

    @Override
    public String toString() {
        return String.format("Saldo: %.2f, Limite: %.2f, Valor Limite: %.2f", saldo, limite, valorLimite);
    }

    public static void main(String[] args) {
        try {
            ContaCorrente conta = new ContaCorrente(500.0f, 200.0f);

            System.out.println(conta);

            conta.sacar(600.0f);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            ContaCorrente conta = new ContaCorrente(500.0f, 200.0f);

            conta.depositar(-100.0f);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            ContaCorrente conta = new ContaCorrente(500.0f, 200.0f);

            conta.setValorLimite(-50.0f);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}