import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Veiculo {
    private String modelo;
    private String marca;
    private int ano_fabricacao;
    private Double valor_mercado;
    public String placa;
    private int numCombustivel;
    private String combustivel;
    private int ano_atual = 2021;
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

    // dificuldade para chamar o método da outra clase
    public double calcularImposto(String placa) {
        GerenciarVeiculos teste = new GerenciarVeiculos(placa);

        Veiculo veiculo = teste.buscarPorPlaca(placa);

        if (veiculo == null) {
            return -1;
        }

        if ((ano_atual - veiculo.getAno_fabricacao()) > 20) {

            return 0;
        }

        if (veiculo.numCombustivel != 1 || veiculo.numCombustivel != 2 || veiculo.numCombustivel != 3) {
            return veiculo.getValor_Mercado() * 0.03;
        } else {
            return veiculo.getValor_Mercado() * 0.04;
        }
    }
    
}