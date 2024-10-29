public class Funcionario {
    private String nome;
    private double salario;
    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) throws SalarioInvalidoException {
        if (salario < 1000 || salario > 20000) {
            throw new SalarioInvalidoException("Deve estar entre 1000 e 20000.");
        } else {
            this.salario = salario;
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) throws IdadeInvalidaException {
        if (idade < 18) {
            throw new IdadeInvalidaException("Deve ter 18 anos.");
        } else {
            this.idade = idade;
        }
    }

    static class SalarioInvalidoException extends Exception {
        public SalarioInvalidoException (String mensagem) {
            super(mensagem);
        }
    }

    static class IdadeInvalidaException extends Exception {
        public IdadeInvalidaException (String mensagem) {
            super(mensagem);
        }
    }
}
