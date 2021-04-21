import java.util.Scanner;
import java.text.DecimalFormat;

public class Veiculo {
    String modelo;
    String marca;
    int ano_fabricacao;
    double valor_mercado;
    String placa;
    int numCombustivel;
    String combustivel;
    int ano_atual = 2021;
    int idade_veiculo;
    double imposto;
    DecimalFormat df = new DecimalFormat("#,###.00");

    Scanner input = new Scanner(System.in);

    public Veiculo(double valor_mercado, int ano_fabricacao, int numCombustivel, String modelo, String marca, String placa) {
        this.valor_mercado = valor_mercado;
        this.ano_fabricacao = ano_fabricacao;
        this.numCombustivel = numCombustivel;
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
    }

    public double calcularImposto(double valor, int ano, int numCombustivel) {

        this.valor_mercado = valor;
        this.ano_fabricacao = ano;
        this.numCombustivel = numCombustivel;

        idade_veiculo = ano_atual - ano_fabricacao;

        if (idade_veiculo >= 20) {
            imposto = 0;
            System.out.println("\nSeu carro é isento de imposto!");
        }

        switch (numCombustivel) {
        case 1:
            imposto = valor_mercado * 0.04;
            System.out.println("\nO valor do seu imposto é de: R$" + df.format(imposto));
            break;
        case 2:
            imposto = valor_mercado * 0.04;
            System.out.println("\nO valor do seu imposto é de: R$" + df.format(imposto));
            break;
        case 3:
            imposto = valor_mercado * 0.04;
            System.out.println("\nO valor do seu imposto é de: R$" + df.format(imposto));
            break;
        case 4:
            imposto = valor_mercado * 0.03;
            System.out.println("\nO valor do seu imposto é de: R$" + df.format(imposto));
            break;
        case 5:
            imposto = valor_mercado * 0.03;
            System.out.println("\nO valor do seu imposto é de: R$" + df.format(imposto));
            break;
        default:
            System.out.println("\nEscolha uma opção válida: ");
        }
        return imposto;
    }

    public void setCombustivel(int numCombustivel) {
        if (numCombustivel == 1) {
            combustivel = "Gasolina";
        } else if(numCombustivel == 2){
            combustivel = "Diesel";
        } else if(numCombustivel == 3){
            combustivel = "Flex";
        }  else if(numCombustivel == 4){
            combustivel = "GNV";
        }  else if(numCombustivel == 5){
            combustivel = "Álcool";
        }
    }

    public void imprimir(Veiculo veiculo) {
        System.out.println("ID: " + veiculo);
        System.out.println("MODELO: " + veiculo.modelo);
        System.out.println("MARCA: " + veiculo.marca);
        System.out.println("ANO DE FABRICAÇÃO: " + veiculo.ano_fabricacao);
        System.out.println("VALOR DE MERCADO " + veiculo.valor_mercado);
        System.out.println("PLACA: " + veiculo.placa);
        System.out.println("TIPO DE COMBUSTÍVEL: " + veiculo.combustivel);
    }

   
}
