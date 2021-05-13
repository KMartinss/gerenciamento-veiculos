import java.util.ArrayList;
import java.util.Iterator;
import java.text.DecimalFormat;

// Optamos por estender a classe Veículo
public class GerenciarVeiculos extends Veiculo {

    DecimalFormat df = new DecimalFormat("#,###.00");

    ArrayList<Veiculo> veiculos;

    public GerenciarVeiculos(String modelo, String marca, int ano_fabricacao, double valor_mercado, String placa,
            int numCombustivel) {
        super(valor_mercado, ano_fabricacao, numCombustivel, modelo, marca, placa);
        veiculos = new ArrayList<>();
    }

    public GerenciarVeiculos() {
        veiculos = new ArrayList<>();
    }

    public GerenciarVeiculos(String placa) {
    }

    public void adicionar(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public boolean remover(String placa) {
        boolean retorno = false;

        Iterator<Veiculo> item = veiculos.iterator();
        // Encapsula o array Veiculo
        // HasNext vai percorrer o array

        while (item.hasNext()) {
            Veiculo veiculo = item.next();
            // Next vai verificar se existe um próximo elemento

            if (veiculo.getPlaca().equals(placa)) {
                item.remove();
                System.out.println("\nVeículo removido com sucesso!");
                // Remove vai remover esse elemento do array
                retorno = true;
            }else {
                System.out.println("Veículo não encontrado!");
            }
        }
        return retorno;
    }

    public String listarVeiculos() {
        StringBuilder listaVeiculos = new StringBuilder(); // Constrói tudo numa string só e imprime
        System.out.println("Quantidade de veículos cadastrados: " + veiculos.size());

        for (Veiculo i : veiculos) {
            listaVeiculos.append(super.imprimir(i));
            // Super -> Invoca o construtor da classe Pai, no caso Veiculo
            // Append: Método de impressão do stringbuilder, concatena as strings
        }
        return listaVeiculos.toString();
    }

    public Veiculo buscarPorPlaca(String placa) {
        Veiculo retorno = null;

        // Loop for-each
        for (Veiculo i : veiculos) {
            if (i.getPlaca().equals(placa))
                retorno = i;
        }
        return retorno;
    }

    public void obterValorImposto(String placa) {
        double valorImposto = this.calcularImposto(placa);

        if (valorImposto == -1) {
            System.out.println("\nPlaca informada não localizada\n");
        } else {
            System.out.printf("Valor do imposto do veículo é de: R$ " + df.format(valorImposto) + "\n");
        }
    }

    // Override vai implementar ou sobrescrever um método vindo de outra classe, no
    // caso o método CalcularImposto que vem de Veículo

    @Override
    public double calcularImposto(String placa) {
        Veiculo veiculo = this.buscarPorPlaca(placa);
        setCombustivel(veiculo);

        if (veiculo == null) {

            return -1;
        }
        if ((2021 - veiculo.getAno_fabricacao()) > 20) {
            return 0;
        }
        if (veiculo.combustivel.equals("Gasolina") || veiculo.combustivel.equals("Diesel")
                || veiculo.combustivel.equals("Flex")) {
            return veiculo.getValor_Mercado() * 0.04;
        } else {
            return veiculo.getValor_Mercado() * 0.03;
        }
    }

    // public String listarCombustivel(int numCombustivel) {
    // StringBuilder listaCombustivel = new StringBuilder();

    // for (Veiculo i : veiculos) {
    // numCombustivel = i.numCombustivel;
    // setCombustivel(i);

    // if (i.setCombustivel(i).equals(i.combustivel)) {
    // listaCombustivel.append(super.imprimir(i));
    // }
    // }
    // if (listaCombustivel.length() > 0) {
    // return listaCombustivel.toString();
    // } else {
    // System.out.println("Nada encontrado!\n");
    // }
}