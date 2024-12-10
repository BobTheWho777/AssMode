import java.util.*;

class Category {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        for (Product p : products) {
            if (p.getName().equals(product.getName())) {
                p.addQuantity(product.getQuantity());
                if (product.getPrice() > p.getPrice()) {
                    p.setPrice(product.getPrice());
                }
                return;
            }
        }
        products.add(product);
    }

    public String getProductsList() {
        StringBuilder list = new StringBuilder();
        for (Product product : products) {
            list.append(product.getName()).append(", ")
                    .append(product.getPrice()).append(" руб. Остаток: ")
                    .append(product.getQuantity()).append(" шт.\n");
        }
        return list.toString();
    }
}


