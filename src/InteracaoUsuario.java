import java.util.Scanner;

public class InteracaoUsuario {

    public InteracaoUsuario(int opcao){

        //leitura do valor informado pelo usuário para comparar as cotações
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o valor que deseja converter: ");
        double valorAConverter = leitura.nextDouble();

        //passagem do valor escolhido no menu para o construtor ConsultaMoeda
        ConsultaMoeda consultaObjeto = new ConsultaMoeda(opcao);

        //obtenção dos países que será feita conversão entre moedas
        String retonraPaisB = consultaObjeto.getPaisBase();
        String retonraPaisC = consultaObjeto.getPaisConverte();

        //passagem do país retornado para o construtor da API
        ConsultaMoeda BuscaValor = new ConsultaMoeda(retonraPaisB, retonraPaisC, valorAConverter);
    }



}
