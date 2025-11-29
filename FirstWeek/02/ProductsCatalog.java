import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductsCatalog {
    List<String> products = new ArrayList<>();

    public void insertProducts(String[] products) {
        for (String product : products) {
            this.products.add(product);
        }
    }

    public void removeProducts(String[] products) {
        for (String product : products) {
            this.products.remove(product);
        }
    }

    public void listProducts() {
        for (String product : products) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        ProductsCatalog catalog = new ProductsCatalog();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nCatalogo de Produtos");
            System.out.println("1 - Listar produtos");
            System.out.println("2 - Inserir produtos");
            System.out.println("3 - Remover produtos");
            System.out.println("4 - Sair");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println();
                    catalog.listProducts();
                }
                case 2 -> {
                    System.out.println("\nDigite os produtos para adicionar, separados por vírgula:");
                    String[] productsToAdd = scanner.nextLine().split(",");
                    catalog.insertProducts(productsToAdd);
                    
                    if (catalog.products.isEmpty()) {
                        System.out.println("O catálogo está vazio após a inserção.");
                    } else {
                        System.out.println("Produto(s) inseridos com sucesso.");
                    }
                }
                case 3 -> {
                    System.out.println("\nDigite os produtos para remover, separados por vírgula:");
                    String[] productsToRemove = scanner.nextLine().split(",");
                    catalog.removeProducts(productsToRemove);
                }
                case 4 -> {
                    System.out.println("\nDeseja sair? (s/n)");
                    String exitChoice = scanner.nextLine().toLowerCase();

                    if (exitChoice.equals("s") || exitChoice.equals("sim")) {
                        System.out.println("Saindo do programa.");
                        running = false;
                    }
                }
                default -> {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
        scanner.close();
    }
}