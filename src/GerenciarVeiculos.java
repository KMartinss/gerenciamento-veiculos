import java.util.ArrayList;

public class GerenciarVeiculos {
    ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

    public void adicionar(Veiculo veiculo) {
        veiculos.add(new Veiculo(veiculo.valor_mercado, veiculo.ano_fabricacao, veiculo.numCombustivel, veiculo.modelo,
                veiculo.marca, veiculo.placa));

        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println(veiculos.get(i));
        }
    }
}
