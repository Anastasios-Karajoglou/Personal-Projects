import java.util.ArrayList;
import java.util.Scanner;

class Product {
  String name;
  float price;

  public Product(String name, float price) {
    this.name = name;
    this.price = price;
  }
}

class Cart {
  ArrayList<Product> products;

  public Cart() {
    this.products = new ArrayList<>();
  }
  public void insertProduct(Product product) {
	if (products.size()<5)
	{this.products.add(product);}
  }

  public void updateProduct(Product product, Product newProduct) {
    for (int i = 0; i < this.products.size(); i++) {
      if (this.products.get(i) == product) {
        this.products.set(i, newProduct);
      }
    }
  }

  public void deleteProduct(Product product) {
    this.products.remove(product);
  }

  public Product findProduct(String name) {
    for (Product p : this.products) {
      if (p.name.equals(name)) {
        return p;
      }
    }
    return null;
  }
}

public class Main {
  public static void main(String[] args) {
    Cart cart = new Cart();
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("1. Insert product");
      System.out.println("2. Update product");
      System.out.println("3. Delete product");
      System.out.println("4. Find product");
      System.out.println("5. Exit");

      int choice = sc.nextInt();
      sc.nextLine();

      switch (choice) {
        case 1:
          System.out.print("Enter product name: ");
          String name = sc.nextLine();
          System.out.print("Enter product price: ");
          float price = sc.nextFloat();
          sc.nextLine();
          Product product = new Product(name, price);
          cart.insertProduct(product);
          break;
        case 2:
          System.out.print("Enter product name: ");
          name = sc.nextLine();
          product = cart.findProduct(name);
          if (product != null) {
            System.out.print("Enter new product name: ");
            String newName = sc.nextLine();
            System.out.print("Enter new product price: ");
            float newPrice = sc.nextFloat();
            sc.nextLine();
            Product newProduct = new Product(newName, newPrice);
            cart.updateProduct(product, newProduct);
          } else {
            System.out.println("Product not found");
          }
          break;
        case 3:
          System.out.print("Enter product name: ");
          name = sc.nextLine();
          product = cart.findProduct(name);
          if (product != null) {
            cart.deleteProduct(product);
          } else {
            System.out.println("Product not found");
          }
          break;
		case 4:
          System.out.print("Enter product name: ");
          name = sc.nextLine();
          product = cart.findProduct(name);
          if (product != null) {
            System.out.println("Product found: " + product.name + ", " + product.price);
          } else {
            System.out.println("Product not found");
          }
          break;
        case 5:
          return;
        default:
          System.out.println("Invalid choice");
          break;
      }
    }
  }
}
