package carrinhoCompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
    List<Produtos> listItems;

    public CarrinhoCompras() {
        this.listItems = new ArrayList<>();
    }

    public void addItem(String name, double price, int quantity) {
        listItems.add(new Produtos(name, price, quantity));
    }

    public void removeItem(String name) {
        List<Produtos> itemRemoved = new ArrayList<>();
        if (!listItems.isEmpty()) {
            listItems.forEach(p -> {
                if (p.getName().equalsIgnoreCase(name))
                    itemRemoved.add(p);
            });
            listItems.removeAll(itemRemoved);
        } else {
            System.out.println("Lista Vazia");
        }
    }
    public int quantityProduct(){
        return listItems.size();
    }

    public double calculateTotal(){
        double total = 0d;
        if(!listItems.isEmpty()){
            total = listItems.stream()
                    .mapToDouble(p -> p.getPrice() * p.getQuantity())
                    .sum();
        }
        return total;
    }

    public void displayItem(){
        if(!listItems.isEmpty()){
            listItems.forEach(v -> {
                System.out.println(v.getName()+", R$"+v.getPrice()+", "+v.getQuantity());
            });
        }
    }

    public static void main(String[] args) {
        CarrinhoCompras compras = new CarrinhoCompras();
        compras.addItem("Leite", 6.5, 3);
        compras.addItem("Arroz", 12.3, 2);
        double total = compras.calculateTotal();
        System.out.printf("Total das compras: %.2f\n", total);
        compras.displayItem();
    }
}
