

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import aplicativos.Pessoa;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        int MAX_ELEMENTOS = 20;
        int opcao, qtdCadastrados = 0;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {

                // Se não tem mais espaço no vetor, caio fora
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }
                System.out.println("Nome: ");
                String nome = in.nextLine();
                System.out.println("CPF: ");
                String cpf = in.nextLine();
                try{
                    Pessoa piloto = new Pessoa(nome, cpf);
                    pilotos[qtdCadastrados] = piloto;
                    qtdCadastrados++;
                    System.out.println("\nPiloto cadastrado com sucesso.");

                }catch(InputMismatchException e){
                    System.out.println(e.getMessage());

                }
                
                

                voltarMenu(in);
            } else if (opcao == 2) {

                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há piloto cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }
                for (int i = 0; i < qtdCadastrados; i++) {
                    System.out.println(pilotos[i]);

                }

                voltarMenu(in);

            } else if (opcao == 3) {
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há piloto cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }
                System.out.println("Digite o CPF do Piloto: ");
                String cpf2 = in.nextLine();

                for (int i = 0; i < qtdCadastrados; i++) {
                    if (pilotos[i].getCpf().equals(cpf2)) {
                        System.out.println("O CPF que voce procura é ");
                        System.out.println(pilotos[i]);
                        break;
                    }
                    if (!pilotos[i].getCpf().equals(cpf2) && i == qtdCadastrados - 1) {
                        System.out.println("CPF não encontrada");
                    }
                }
                voltarMenu(in);

            } else if (opcao == 4) {
                System.out.println("Atualmente voce usou " + qtdCadastrados
                        + " cadastro, sendo que o total para armazenamento1 é  " + MAX_ELEMENTOS);
                System.out.println("Deseja aumentar o armazenamento de cadastro para: ");
                
                int MAX_ELEMENTOS_NOVO = in.nextInt();
                in.nextLine();

                Pessoa[] pilotosCad = new Pessoa[MAX_ELEMENTOS_NOVO];

                for (int i = 0; i < MAX_ELEMENTOS; i++) {
                    pilotosCad[i] = pilotos[i];
                }

                MAX_ELEMENTOS = MAX_ELEMENTOS_NOVO;

                pilotos = pilotosCad;

                System.out.println("quantidade aumentanda com sucesso para " + MAX_ELEMENTOS);
                voltarMenu(in);

            } else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");

        System.out.flush();
    }
}