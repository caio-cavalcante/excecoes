import java.util.Scanner;

public class Cadastro {
    public static void main(String[] args) throws Aluno.MatriculaException {
        //throws Aluno.MatriculaException não é necessário com try-catch
        Scanner scanner = new Scanner(System.in);
        Aluno aluno1 = new Aluno();
        Aluno aluno2 = new Aluno();
        Aluno aluno3 = new Aluno();
        Aluno[] alunoList = {aluno1, aluno2, aluno3};

        System.out.print("Digite os 3 nomes: ");
        aluno1.setNome(scanner.nextLine());
        aluno2.setNome(scanner.nextLine());
        aluno3.setNome(scanner.nextLine());

        System.out.print("Digite a matricula: ");

        try {
            aluno1.setMatricula(scanner.nextInt());
            aluno2.setMatricula(scanner.nextInt());
            aluno3.setMatricula(scanner.nextInt());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
