public class Aluno {
    private String nome;
    private int matricula;
    private String endereco;
    public Aluno[] alunoList;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) throws MatriculaException {
        if (this.alunoList[2] != null) {
            for (Aluno aluno : alunoList) {
                if (aluno.getMatricula() == matricula) {
                    throw new MatriculaException("Matrícula já cadastrada.");
                } else {
                    this.matricula = matricula;
                }
            }
        } else {
            this.matricula = matricula;
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    static class MatriculaException extends Exception {
        public MatriculaException(String message) {
            super(message);
        }
    }
}
