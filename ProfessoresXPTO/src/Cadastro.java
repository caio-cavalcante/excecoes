import java.util.InputMismatchException;
import java.util.Scanner;

public class Cadastro {
    Scanner scanner = new Scanner(System.in);
    Professor prof = new Professor(5);
    int opcao;

    public void Menu () {
        do {
            System.out.println("Bem vindo ao sistema de cadastro. O que quer fazer?");
            System.out.println("1. Cadastrar professor");
            System.out.println("2. Excluir professor");
            System.out.println("3. Buscar professor");
            System.out.println("4. Sair");

            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Informe um número!");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarProfessor();
                    break;
                case 2:
                    excluirProfessor();
                    break;
                case 3:
                    buscarProfessor();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }

    public void cadastrarProfessor() {
        scanner.nextLine();

        System.out.println("Informe o nome do professor:");
        prof.setNome(scanner.nextLine());

        System.out.println("Informe o cpf do professor:");
        try{
            prof.setCpf(scanner.nextLong());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        System.out.println("Informe a idade do professor:");
        prof.setIdade(scanner.nextInt());

        System.out.println("Informe o sexo do professor (M/F):");
        char sexo = scanner.next().charAt(0);
        prof.setSexo(sexo);

        scanner.nextLine();
        System.out.println("Informe o endereço do professor:");
        prof.setEndereco(scanner.nextLine());
    }

    public void excluirProfessor() {
        System.out.println("Informe o cpf do professor que deseja excluir:");
        try {
            long cpf = scanner.nextLong();
            prof.excluirProfessor(cpf);
            System.out.println("Professor excluído com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void buscarProfessor() {
        System.out.println("Informe o cpf do professor que deseja buscar:");
        try {
            long cpf = scanner.nextLong();
            Professor professor = prof.buscarProfessorPorCpf(cpf);
            if (professor!= null) {
                System.out.println("Professor encontrado:");
                System.out.println(professor);
            } else {
                System.out.println("Professor não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        cadastro.Menu();
    }
}
