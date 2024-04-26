import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        String menu =("************************************************************************* \n" +
                "Seja bem-vindo/a ao Conversor de Moedas" +
                "\n\n" +
                "1) Dólar =>> Peso argentino\n" +
                "2) Peso argentino =>> Dólar\n" +
                "3) Dólar =>> Real brasileiro\n" +
                "4) Real brasileiro =>> Dólar\n" +
                "5) Dólar =>> Peso colombiano\n" +
                "6) Peso colombiano =>> Dólar \n" +
                "7) Sair \n" +
                "************************************************************************* \n");

        Scanner leitura = new Scanner(System.in);
        int opcao;

        do {
            System.out.println(menu);

            opcao = leitura.nextInt();

            switch (opcao){
                case 1, 2, 3, 4, 5, 6 :
                    InteracaoUsuario interage = new InteracaoUsuario(opcao);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Selecione uma opção válida:");
            }
        } while (opcao != 7);
    }
}
