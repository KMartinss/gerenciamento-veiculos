import java.util.ArrayList;
import java.util.Iterator;

public class GerenciarVeiculos extends Veiculo {

    ArrayList<Veiculo> veiculos;

    String error = "-1";

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

        while (item.hasNext()) {
            Veiculo veiculo = item.next();

            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                item.remove();

                retorno = true;
            }
        }

        return retorno;
    }

    public String listarVeiculos() {
        StringBuilder listaVeiculos = new StringBuilder(); // constroi tudo numa string so e imprime

        System.out.println("Quantidade de veículos cadastrados: " + veiculos.size());

        for (Veiculo v : veiculos) {
            listaVeiculos.append(super.imprimir(v));
        }

        return listaVeiculos.toString();

    }

    public Veiculo buscarPorPlaca(String placa) {
        Veiculo retorno = null;

        for (Veiculo v : veiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                retorno = v;
            }
        }
        return retorno;
    }

    public void obterValorImposto(String placa) {
        double valorImposto = this.calcularImposto(placa);

        if (valorImposto == -1) {
            System.out.println("\nPlaca informada não localizada\n");
        } else {
            System.out.printf("Valor do imposto do veículo é de: R$ " + valorImposto + "\n");
        }
    }

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

    public String listarCombustivel(int numCombustivel) {
        StringBuilder listaCombustivel = new StringBuilder();

        for (Veiculo veiculo : veiculos) {
            numCombustivel = veiculo.numCombustivel;
            setCombustivel(veiculo);

            if (veiculo.setCombustivel(veiculo).equals(veiculo.combustivel)) {
                listaCombustivel.append(super.imprimir(veiculo));
            }
        }
        return listaCombustivel.length() > 0 ? listaCombustivel.toString() : "Nada encontrado!\n";
    }
}
