import java.util.Scanner;
import java.text.DecimalFormat;

public abstract class Veiculo {
    private String modelo;
    private String marca;
    private int ano_fabricacao;
    private Double valor_mercado;
    private String placa;
    private int numCombustivel;
    private String combustivel;
    private int ano_atual = 2021;
    private int idade_veiculo;
    private double imposto;
    private DecimalFormat df = new DecimalFormat("#,###.00");

    Scanner input = new Scanner(System.in);

    public Veiculo(double valor_mercado, int ano_fabricacao, int numCombustivel, String modelo, String marca,
            String placa) {
        this.valor_mercado = valor_mercado;
        this.ano_fabricacao = ano_fabricacao;
        this.numCombustivel = numCombustivel;
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
    }

    public Veiculo() {

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

    public String getModelo() {
        return this.modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public int getAno_fabricacao() {
        return this.ano_fabricacao;
    }

    public double getValor_Mercado() {
        return this.valor_mercado;
    }

    public String getPlaca() {
        return this.placa;
    }

    public String getCombustivel() {
        return this.combustivel;
    }

    public String setCombustivel(Veiculo veiculo) {
        if (veiculo.numCombustivel == 1) {
            veiculo.combustivel = "Gasolina";
        } else if (veiculo.numCombustivel == 2) {
            veiculo.combustivel = "Diesel";
        } else if (veiculo.numCombustivel == 3) {
            veiculo.combustivel = "Flex";
        } else if (veiculo.numCombustivel == 4) {
            veiculo.combustivel = "GNV";
        } else if (veiculo.numCombustivel == 5) {
            veiculo.combustivel = "Álcool";
        }

        return combustivel;
    }

    public String imprimir(Veiculo veiculo) {
        setCombustivel(veiculo);

        return "\nID: " + veiculo + "\nMODELO: " + veiculo.modelo + "\nMARCA: " + veiculo.marca
                + "\nANO DE FABRICAÇÃO: " + veiculo.ano_fabricacao + "\nVALOR DE MERCADO: R$"
                + df.format(veiculo.valor_mercado) + "\nPLACA: " + veiculo.placa + "\nTIPO DE COMBUSTÍVEL: "
                + veiculo.combustivel;
    }
}
