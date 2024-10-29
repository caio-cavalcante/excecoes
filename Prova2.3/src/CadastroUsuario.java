import java.util.*;

public class CadastroUsuario {
    public static void main(String[] args) throws IdadeInvalidaException, SalarioInvalidoException {
        Scanner scanner = new Scanner(System.in);

        try {
            Funcionario funcionario = new Funcionario();

            System.out.println("Digite o nome do funcionário: ");
            String nome = scanner.nextLine();

            System.out.println("Digite a idade do funcionário: ");
            int idade = scanner.nextInt();

            System.out.println("Digite o salário do funcionário: ");
            double salario = scanner.nextDouble();

            funcionario.setNome(nome);
            funcionario.setIdade(idade);
            funcionario.setSalario(salario);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
