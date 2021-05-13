import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InterruptedException {

        // Instanciando classe GerenciarVeiculos
        GerenciarVeiculos gerenciador = new GerenciarVeiculos();

        // Declarando váriavel que virá a ser o argumento do switch case
        int opcao = 0, ano_fabricacao, numCombustivel;
        String placa, modelo, marca;
        double valor_mercado;

        do { // Enquanto a opção for diferente de 7 (encerrar), o programa irá rodar tudo que
             // está
             // contido dentro da chave
            Scanner input = new Scanner(System.in); // Scanner para entrada de dados
            System.out.println("\n=============\nSelecione uma opção!");
            Thread.sleep(1000); // Timing de intervalo de 1 segundo
            System.out.println("\n[1] - Buscar veículo por placa");
            System.out.println("[2] - Adicionar veículo");
            System.out.println("[3] - Remover veículo");
            System.out.println("[4] - Listar por tipo de combustível");
            System.out.println("[5] - Listar todos");
            System.out.println("[6] - Obter valor do imposto pelo número da placa");
            System.out.println("[7] - Sair\n");
            System.out.println("Sua opção: ");
            opcao = input.nextInt();

            // Menu de entrada para o usuário com alocação da variável opção e logo abaixo o
            // switch case com cada opção

            // [1] - Buscar veículo por placa
            // [2] - Adicionar veículo
            // [3] - Remover veículo
            // [4] - Listar por tipo de combustível
            // [5] - Listar todos
            // [6] - Obter valor do imposto pelo número da placa
            // [7] - Sair

            switch (opcao) {

                case 1:
                    // [1] - Busca veículo por placa
                    System.out.println("\nDigite a placa do veículo a ser pesquisado: ");
                    placa = input.next();
                    Veiculo buscaVeiculo = gerenciador.buscarPorPlaca(placa);

                    if (buscaVeiculo != null) {
                        Object veiculoFiltrado;
                        veiculoFiltrado = gerenciador.imprimir(buscaVeiculo);
                        System.out.println(veiculoFiltrado);
                    } else {
                        System.out.println("\nPlaca informada não localizada");
                    }
                    break;

                // terminado
                case 2:
                    // [2] - Adicionar veículo
                    System.out.println("Qual o modelo do seu veículo? ");
                    modelo = input.next();

                    System.out.println("Qual a marca do seu do veículo? ");
                    marca = input.next();

                    System.out.println("Qual o ano de fabricação do veiculo? ");
                    ano_fabricacao = input.nextInt();

                    System.out.println("Qual o valor de mercado do seu veículo?");
                    valor_mercado = input.nextDouble();

                    System.out.println("Qual a placa do seu veículo? ");
                    placa = input.next();

                    System.out.println(
                            "Selecione o combustível que voce utiliza! \n[1] - Gasolina | [2] - Diesel | [3] - Flex | [4] - GNV | [5] - Álcool: ");
                    numCombustivel = input.nextInt();

                    System.out.println("\n\nSeu veículo foi registrado com sucesso!");
                    Thread.sleep(1000);

                    System.out.println("\n\nCarregando menu inicial...");
                    Thread.sleep(1500);

                    gerenciador.adicionar(
                            new GerenciarVeiculos(modelo, marca, ano_fabricacao, valor_mercado, placa, numCombustivel));

                    break;

                case 3:
                    // [3] - Remove veículo pela placa
                    System.out.println(gerenciador.listarVeiculos());
                    System.out.println("\nDigite a placa do veículo a ser removido: ");
                    placa = input.next();
                    gerenciador.remover(placa);
                    break;

                case 4:
                    // [4] - Listar por tipo de combustível - (x)
                    System.out.println(
                            "\nDigite o tipo de combustível!\n\n[1] - Gasolina | [2] - Diesel | [3] - Flex | [4] - GNV | [5] - Álcool: ");
                    numCombustivel = input.nextInt();
                    //System.out.println(gerenciador.listarCombustivel(numCombustivel));
                    break;

                case 5:
                    // [5] - Listar veículos
                    System.out.println(gerenciador.listarVeiculos());
                    break;

                case 6:
                    // [6] - Obter valor do imposto pelo número da placa
                    System.out.println("\nDigite a placa do veículo que deseja calcular: ");
                    placa = input.next();
                    gerenciador.obterValorImposto(placa);
                    break;

                case 7:
                    // [7] - Sair
                    System.out.println("\nEncerrando...");
                    Thread.sleep(1500);
                    System.exit(0);
                    break;

                // Tratamento de erro/ opção inválida
                default:
                    System.out.println("\nEscolha uma opção válida: ");
                    break;
            }

            // Opção 7 é responsável por encerrar o programa.
        } while (opcao != 7);
    }
}
