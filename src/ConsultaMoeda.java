import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultaMoeda {

    private int opcaoDoMeu;
    private String paisBase;
    private String paisConverte;


    //Construtor que recebe o valor informado no menu
    public ConsultaMoeda(int menuEscolhido){
        this.opcaoDoMeu = menuEscolhido;
        if (opcaoDoMeu == 1){
            paisBase = "USD";
            paisConverte = "ARS";
        } if (opcaoDoMeu == 2){
            paisBase = "ARS";
            paisConverte = "USD";
        } if (opcaoDoMeu == 3) {
            paisBase = "USD";
            paisConverte = "BRL";
        } if (opcaoDoMeu == 4){
            paisBase = "BRL";
            paisConverte = "USD";
        } if (opcaoDoMeu == 5) {
            paisBase = "USD";
            paisConverte = "COP";
        } if(opcaoDoMeu == 6){
            paisBase = "COP";
            paisConverte = "USD";
        }
    }

    //metodo que retorna os valores informados conforme a opção do usuário
    public String getPaisBase() {
        return paisBase;
    }
    public String getPaisConverte() {
        return paisConverte;
    }

    //construtor que recebe o valor de países para para busca na API e o valor a ser convertido,
    public ConsultaMoeda(String retonraPaisB, String retonraPaisC, Double valorAConverter) {
        String endereco = "https://v6.exchangerate-api.com/v6/20e75d45eab5302092dca7e8/latest/" + retonraPaisB;

        //solicitação de dados para o servidor
        HttpClient client = HttpClient.newHttpClient();
        //como a requisição é feita, builder é um padrão para objetos complexos
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        try {
            //agora é preciso criar a resposta HttpResponse
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            //criação de uma variável com retorno da API para usar em sequencia
            String retornoJson = response.body();

            //instaciar o Gson
            Gson gson = new Gson();

            // Convertendo a string JSON em um objeto JsonObject
            JsonObject jsonObject = gson.fromJson(retornoJson, JsonObject.class);

            // Obtendo o objeto "rates" que contém o câmbio
            JsonObject ratesObject = jsonObject.getAsJsonObject("conversion_rates");

            // Obtendo a cotação da moeda para paisConverte de dentro de conversion_rates (específicidade da API)
            JsonElement valorConvertido = ratesObject.get(retonraPaisC);

            //calcular o valor convertido
            double NovoValor = valorAConverter * Double.parseDouble(String.valueOf(valorConvertido));

            //exibir o resultado
            System.out.println("O valor de " + valorAConverter + "["+ retonraPaisB +"]" + " corresponde ao valor final de =>>> " + NovoValor +" " + "["+retonraPaisC+"]");
            System.out.println("------------------------------------------------------------------------ \n");

        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação!");
        }

    }
}


