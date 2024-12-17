import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Conversor conversor = new Conversor();

        System.out.println("""
                1 - Real Brasileiro => Rublo russo
                2 - Rublo russo => Real Brasileiro
                3 - Real Brasileiro => Rupia indiana
                4 - Rupia indiana => Real Brasileiro
                5 - Real Brasileiro => Yuan chinês
                6 - Yuan chinês => Real Brasileiro
                7 - Real Brasileiro => Rand sul-africano
                8 - Rand sul-africano => Real Brasileiro
                9 - Sair
                """);

        int opcao = 0;

        while (opcao != 9) {
            System.out.print("Digite uma opção: ");
            opcao = leitura.nextInt();

            if (opcao != 9) {
                System.out.print("Digite o valor que deseja converter: ");
                double valor = leitura.nextDouble();

                String moedaOrigem, moedaDestino;

                switch (opcao) {
                    case 1:
                        moedaOrigem = "BRL";
                        moedaDestino = "RUB";
                        break;
                    case 2:
                        moedaOrigem = "RUB";
                        moedaDestino = "BRL";
                        break;
                    case 3:
                        moedaOrigem = "BRL";
                        moedaDestino = "INR";
                        break;
                    case 4:
                        moedaOrigem = "INR";
                        moedaDestino = "BRL";
                        break;
                    case 5:
                        moedaOrigem = "BRL";
                        moedaDestino = "CNY";
                        break;
                    case 6:
                        moedaOrigem = "CNY";
                        moedaDestino = "BRL";
                        break;
                    case 7:
                        moedaOrigem = "BRL";
                        moedaDestino = "ZAR";
                        break;
                    case 8:
                        moedaOrigem = "ZAR";
                        moedaDestino = "BRL";
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, tente uma opção válida!");
                        continue;
                }

                double resultado = conversor.converterMoeda(valor, moedaOrigem, moedaDestino);
                System.out.printf("Valor convertido: %.2f", resultado);
                System.out.println();
            } else {
                System.out.println("Saindo do sistema!");
            }
        }

        leitura.close();
    }
}
