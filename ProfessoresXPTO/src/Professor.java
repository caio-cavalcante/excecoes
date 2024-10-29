public class Professor {
    private String nome;
    private int idade;
    private char sexo;
    private long cpf;
    private long rg;
    private String endereco;
    public Professor[] professorList;

    public Professor(int max) {
        professorList = new Professor[max];
        professorList[0] = this;
    }

    public void incluirProfessor(Professor professor) throws MaxProfsException {
        for (int i = 0; i < professorList.length; i++) {
            if (professorList[i] == null) {
                professorList[i] = professor;
                return;
            }
        }
        throw new MaxProfsException("Já existem " + professorList.length + " professores cadastrados.");
    }

    static class MaxProfsException extends Exception {
        public MaxProfsException(String message) {
            super(message);
        }
    }

    public void excluirProfessor(long cpf) throws CpfExisteException {
        for (int i = 0; i < professorList.length; i++) {
            if (professorList[i]!= null && professorList[i].getCpf() == cpf) {
                professorList[i] = null;
                return;
            }
        }
        throw new CpfExisteException("Professor com CPF " + cpf + " não encontrado.");
    }

    public Professor buscarProfessorPorCpf(long cpf) throws CpfExisteException {
        for (Professor professor : professorList) {
            if (professor!= null && professor.getCpf() == cpf) {
                return professor;
            }
        }
        throw new CpfExisteException("Professor com CPF " + cpf + " não encontrado.");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) throws CpfExisteException {
        for (Professor professor : professorList) {
            if (professor!= null && professor.cpf == cpf) {
                throw new CpfExisteException("Já existe um professor com o CPF " + cpf + ".");
            }
        }
        this.cpf = cpf;
    }

    static class CpfExisteException extends Exception {
        public CpfExisteException(String message) {
            super(message);
        }
    }

    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}