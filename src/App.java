import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        GerenciarVeiculos list = new GerenciarVeiculos();

        int opcao = 0;
        String placa;

        do {
            Scanner input = new Scanner(System.in);
            System.out.println("\n=============\nSelecione uma opção!\n[1] - Buscar veículo por placa");
            System.out.println("[2] - Adicionar veículo");
            System.out.println("[3] - Remover veículo");
            System.out.println("[4] - Listar por tipo de combustível");
            System.out.println("[5] - Listar todos");
            System.out.println("[6] - Obter valor do imposto pelo número da placa");
            System.out.println("[7] - Sair\n");
            System.out.println("Sua opção: ");
            opcao = input.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("\nDigite a placa do veículo a ser pesquisado: ");
                    placa = input.next();
                    Veiculo buscaVeiculo = list.buscarPorPlaca(placa);
                    Object veiculoFiltrado = buscaVeiculo != null ? list.imprimir(buscaVeiculo)
                            : "\nPlaca informada não localizada";
                    System.out.println(veiculoFiltrado);
                    break;

                // terminado
                case 2:
                    System.out.println("Qual o modelo do seu veículo? ");
                    String modelo = input.next();

                    System.out.println("Qual a marca do seu do veículo? ");
                    String marca = input.next();

                    System.out.println("Qual o ano de fabricação do veiculo? ");
                    int ano_fabricacao = input.nextInt();

                    System.out.println("Qual o valor de mercado do seu veículo?");
                    double valor_mercado = input.nextDouble();

                    System.out.println("Qual a placa do seu veículo? ");
                    placa = input.next();

                    System.out.println(
                            "Selecione o combustível que voce utiliza! \n[1] - Gasolina | [2] - Diesel | [3] - Flex | [4] - GNV | [5] - Álcool: ");
                    int numCombustivel = input.nextInt();

                    System.out.println("\n\nSeu veículo foi registrado com sucesso.\nCarregando menu inicial...");

                    list.adicionar(
                            new GerenciarVeiculos(modelo, marca, ano_fabricacao, valor_mercado, placa, numCombustivel));

                    list.adicionar(new GerenciarVeiculos("fusca", "fusca", 2002, 12000, "abc", 1));

                    break;

                case 3:
                    // remover veiculo - TERMINADO
                    System.out.println(list.listarVeiculos());
                    System.out.println("\nDigite a placa do veículo a ser removido: ");
                    placa = input.next();
                    list.remover(placa);
                    break;

                case 4:
                    System.out.println(
                            "\nDigite o tipo de combustível!\n\n[1] - Gasolina | [2] - Diesel | [3] - Flex | [4] - GNV | [5] - Álcool: ");
                    numCombustivel = input.nextInt();
                    System.out.println(list.listarCombustivel(numCombustivel));
                    break;
                case 5:
                    // Lista veiculos aqui - TERMINADO
                    System.out.println(list.listarVeiculos());
                    break;

                case 6:
                    System.out.println("\nDigite a placa do veículo que deseja calcular: ");
                    placa = input.next();
                    list.obterValorImposto(placa);
                    break;
                case 7:
                    System.out.println("\nEncerrando...");

                    System.exit(0);
                    break;

                default:
                    System.out.println("\nEscolha uma opção válida: ");
                    break;
            }

            // input.close vai ficar dando erro, se eu fecho ele aqui dentro da erro no do
            // while

        } while (opcao != 7);

    }

}
