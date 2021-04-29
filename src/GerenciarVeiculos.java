import java.util.ArrayList;
import java.util.Iterator;

public class GerenciarVeiculos extends Veiculo {

    ArrayList<Veiculo> veiculos;

    public GerenciarVeiculos(String modelo, String marca, int ano_fabricacao, double valor_mercado, String placa,
            int numCombustivel) {
        super(valor_mercado, ano_fabricacao, numCombustivel, modelo, marca, placa);
        veiculos = new ArrayList<>();
    }

    public GerenciarVeiculos() {
        veiculos = new ArrayList<>();
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

    public Veiculo buscarPorPlaca(String placa) {

        Veiculo retorno = null;

        for (Veiculo v : veiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                retorno = v;
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

}
