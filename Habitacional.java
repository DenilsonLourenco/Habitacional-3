import java.util.ArrayList;
import java.util.Scanner;

public class Habitacional {

  public static void main(String[] args) {
    ArrayList<Renda> listaRendas = new ArrayList<>();
    int RendaResoluveis = 0;
    int RendaNaoResoluveis = 0;
    Scanner scanner = new Scanner(System.in);
    int opcao;

    //Menu
    do {
      System.out.println("----MENU----");
      System.out.println("1 - Registrar Renda");
      System.out.println("2 - Consultar Renda");
      System.out.println("3 - Atualizar Renda");
      System.out.println("4 - Ver Lista de  Renda");
      System.out.println("5 - Remover Renda");
      System.out.println("sair Renda");
      System.out.println("Escolha uma opção: ");

      opcao = scanner.nextInt();
      switch (opcao) {
        case 1:
          System.out.println("Digite o Valor da Renda: ");
          double valorRenda = scanner.nextDouble();
          System.out.println("A renda é resoluvel ? (S/N): ");
          String resoluvel = scanner.next();
          Renda renda;
          if (resoluvel.equalsIgnoreCase("S")) {
            renda = new RendaNaoResoluvel(valorRenda);
            RendaResoluveis++;
          } else {
            renda = new RendaNaoResoluvel(valorRenda);
            RendaNaoResoluveis++;
          }
          listaRendas.add(renda);
          System.out.println("Renda registrada com sucesso!");
          break;
        ///////
        case 2:
          System.out.println("Digite o Indice da renda a ser consultada:");
          int indiceConsulta = scanner.nextInt();
          if (indiceConsulta >= 0 && indiceConsulta < listaRendas.size()) {
            Renda rendaConsulta = listaRendas.get(indiceConsulta);
            System.out.println("Valor da Renda: " + rendaConsulta.getValor());
            System.out.println(
              "Renda Resoluvel: " + rendaConsulta.isResoluvel()
            );
          } else {
            System.out.println("Indice Invalido!");
          }
          break;
        case 3:
          System.out.println("Digite o Indice da Renda a ser atualizada: ");
          int indiceAtualizacao = scanner.nextInt();
          if (
            indiceAtualizacao >= 0 && indiceAtualizacao < listaRendas.size()
          ) {
            System.out.println("Digite o novo valor da Renda: ");
            double novoValor = scanner.nextDouble();
            Renda rendaAtualizada = listaRendas.get(indiceAtualizacao);
            rendaAtualizada.valor = novoValor;
            System.out.println("Renda Atualizada com Sucesso!");
          } else {
            System.out.println("Indice invalido!");
          }
          break;
        case 4:
          System.out.println("------LISTA DE RENDAS-----");
          for (int i = 0; i < listaRendas.size(); i++) {
            Renda rendaListagem = listaRendas.get(i);
            System.out.println("Indice: " + i);
            System.out.println("Valor da Renda: " + rendaListagem.getValor());
            System.out.println(
              "Renda Resoluvel: " + rendaListagem.isResoluvel()
            );
            System.out.println("-------------------------------");
          }
          break;
        case 5:
          System.out.println("Digite o Indice da Renda a ser removida:  ");
          int indiceRemocao = scanner.nextInt();
          if (indiceRemocao >= 0 && indiceRemocao < listaRendas.size()) {
            Renda rendaRemovida = listaRendas.remove(indiceRemocao);
            if (rendaRemovida.isResoluvel()) {
              RendaResoluveis--;
              System.out.println("Renda Removida com sucesso");
            } else {
              RendaNaoResoluveis--;
            }
          } else {
            System.out.println("Indice Invalido!");
          }
          break;
        case 0:
          System.out.println("Opção Invalida!");
          break;
      }
      System.out.println(
        "Numero de rendas resoluveis registradas: " + RendaResoluveis
      );
      System.out.println(
        "Numero de rendas não resoluveis registradas: " + RendaNaoResoluveis
      );
    } while (opcao != 0);

    scanner.close();
  }
}
