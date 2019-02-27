package fr.esiea;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProductTest {
    
@Test 
public void getUntit_Product_Test() {

    Product rice_bag = new Product("rice_bag", ProductUnit.Kilo);
  	Product rice_bag_bis = rice_bag;
    Product eggs1 = new Product("eggs", ProductUnit.Each);
    Product eggs2 = new Product("eggs", ProductUnit.Each);
    Product potato_each = new Product("potato", ProductUnit.Each);
    Product potato_kilo = new Product("potato", ProductUnit.Kilo);
    ReceiptItem receiptItem_rice_bag = new ReceiptItem(rice_bag, 4, 5, 20);

    // test of getName()
    assertThat(rice_bag.getName()).isEqualTo("rice_bag");

    // test of getUnit()
    assertThat(rice_bag.getUnit()).isEqualTo(ProductUnit.Kilo);

    // test of equals()
    assertThat(rice_bag.equals(rice_bag_bis)).isEqualTo(true);
    assertThat(rice_bag.equals(receiptItem_rice_bag)).isEqualTo(false);
    assertThat(rice_bag.equals(null)).isEqualTo(false);
    assertThat(eggs1.equals(potato_each)).isEqualTo(false);
    assertThat(potato_each.equals(potato_kilo)).isEqualTo(false);
    assertThat(eggs1.equals(eggs2)).isEqualTo(true);

    // test of hashCode()
    assertThat(eggs1.hashCode()).isEqualTo(eggs2.hashCode());
    assertThat(eggs1.hashCode()).isNotEqualTo(rice_bag.hashCode()); 
}

}


// Test des 10% de remise sur le rix sachant que le prix normal est de 2.49€ par sachet 
@Test
    public void TestTenPercentDiscount() {

        SupermarketCatalog catalog = new FakeCatalog();
        Product rice = new Product("Rice",ProductUnit.Each);
        catalog.addProduct(rice, 2.49);

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(rice);

        Teller teller = new Teller(catalog);
        teller.addSpecialOffer(SpecialOfferType.TenPercentDiscount, rice,10.0);

        Receipt receipt = teller.checksOutArticlesFrom(cart);

        double expectedTotalPrice =  2.49 - ((2.49*10)/100);
        double totalPrice = receipt.getTotalPrice();
        Assertions.assertThat(totalPrice).isEqualTo(expectedTotalPrice).as("Get ten percent off discount on the rice bag");

    }
