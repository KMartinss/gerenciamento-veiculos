import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
            Scanner input = new Scanner(System.in);
            GerenciarVeiculos list = new GerenciarVeiculos();
    

            System.out.println("Selecione uma opção\n [1] - Consultar veículo\n [2] - Adicionar veículo\n Sua opção: ");
            int opcao = input.nextInt();

            switch (opcao) {

            case 1:
                System.out.println("Limpo");
                break;
            case 2:
                System.out.println("Qual o modelo do seu veículo? ");
                String modelo = input.next();

                System.out.println("Qual a marca do seu do veículo? ");
                String marca = input.next();

                System.out.println("Qual o ano de fabricação do veiculo? ");
                int ano_fabricacao = input.nextInt();

                System.out.println("Qual o valor de mercado do seu veículo? R$ ");
                double valor_mercado = input.nextDouble();

                System.out.println("Qual a placa do seu veículo? ");
                String placa = input.next();

                System.out.println(
                        "Selecione o combustível que voce utiliza! \n[1] - Gasolina | [2] - Diesel | [3] - Flex | [4] - GNV | [5] - Álcoo: ");
                int numCombustivel = input.nextInt();

                Veiculo veiculo = new Veiculo(valor_mercado, ano_fabricacao, numCombustivel, modelo, marca, placa);

                System.out.println("Seu veículo foi registrado com sucesso. Confirme as informações abaixo:\n");

                list.adicionar(veiculo);

                // veiculo.setCombustivel(numCombustivel);
                // veiculo.imprimir(veiculo);
                break;

            default:
                System.out.println("\nEscolha uma opção válida: ");

            }
            input.close();

    }
}
