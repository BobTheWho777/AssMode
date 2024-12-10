import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Category category = new Category();

        System.out.println("Добавляем товары в категорию. Введите 'exit' для окончания:");

        while (true) {
            System.out.print("Введите название товара: ");
            String name = scanner.nextLine();
            if (name.equals("exit")) break;

            System.out.print("Введите цену товара: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Введите количество товара: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            Product product = Product.createProduct(name, price, quantity);
            category.addProduct(product);
        }

        System.out.println("Список товаров в категории:");
        System.out.println(category.getProductsList());
    }
}
class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        setPrice(price);
        this.quantity = quantity;
    }

    public static Product createProduct(String name, double price, int quantity) {
        return new Product(name, price, quantity);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            System.out.println("Цена введена некорректная.");
            return;
        }
        if (this.price > price) {
            System.out.print("Снижать цену? y/n: ");
            Scanner scanner = new Scanner(System.in);
            String decision = scanner.nextLine();
            if (decision.equals("y")) {
                this.price = price;
            }
        } else {
            this.price = price;
        }
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }
}