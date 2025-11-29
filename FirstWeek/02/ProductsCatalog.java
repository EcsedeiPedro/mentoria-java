import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private int id;
    private String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "id: " + id + ", nome: " + name;
    }
}

public class ProductsCatalog {
    List<Product> products = new ArrayList<>();
    private int nextId = 1;

    public void insertProducts(String[] productNames) {
        for (String name : productNames) {
            products.add(new Product(nextId++, name.trim()));
        }
    }

    public void removeProductById(int id) {
        products.removeIf(product -> product.getId() == id);
    }

    public void listProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @SuppressWarnings("ConvertToTryWithResources")
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
                        System.out.println("Produto(s) inserido(s) com sucesso.");
                    }
                }
                case 3 -> {
                    System.out.println("\nProdutos cadastrados:");
                    catalog.listProducts();
                    System.out.println("\nDigite o ID do produto para remover:");
                    int productToRemove = scanner.nextInt();
                    scanner.nextLine();
                    catalog.removeProductById(productToRemove);
                    System.out.println("Produto removido com sucesso.");
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