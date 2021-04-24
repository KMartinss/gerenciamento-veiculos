import java.util.ArrayList;

public class GerenciarVeiculos extends Veiculo {
    
    ArrayList<Veiculo> veiculos;

    public GerenciarVeiculos (String modelo, String marca, int ano_fabricacao, double valor_mercado, String placa, int numCombustivel) {
        super(valor_mercado, ano_fabricacao, numCombustivel, modelo, marca, placa);
        veiculos = new ArrayList<>();
    }

    public GerenciarVeiculos() {
        veiculos = new ArrayList<>();
    }

    public void adicionar(Veiculo veiculo) {
        this.veiculos.add(veiculo);

        }
    
    public Veiculo buscarPorPlaca(String placa) { //buscador de placa

        Veiculo retorno = null;

        for (Veiculo buscaPlaca : veiculos) {
            if (buscaPlaca.getPlaca().equalsIgnoreCase(placa)) {
                retorno = buscaPlaca;
            }
        }

        return retorno;

    }

    public String listarVeiculos() {
        StringBuilder listaVeiculos = new StringBuilder(); //constroi tudo numa string so e imprime

        System.out.println("Quantidade de veículos cadastrados: " + veiculos.size());

        for (Veiculo v : veiculos) {
            listaVeiculos.append(super.imprimir(v));
        }

        return listaVeiculos.toString();
    }

    
    }


