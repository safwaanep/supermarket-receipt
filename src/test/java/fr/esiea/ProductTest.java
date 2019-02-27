import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
//Import
import org.junit.jupiter.api.Test;

public class ProductTest {

	
	@Test
    public void testEquals () {

        Product apples = new Product("apples", ProductUnit.Kilo);
        List<Product> product_discount = Arrays.asList(apples);
        Discount discount = new Discount(product_discount, "Apples Discount", 0.199);

        Product banane = new Product("banane", ProductUnit.Kilo);
        Product toothbrush = new Product("toothbrush", ProductUnit.Each);
        Product apples1 = new Product("apples", ProductUnit.Kilo);
        Product apples2 = new Product("apples", ProductUnit.Each);

        Assertions.assertThat(apples.equals(apples)).isEqualTo(true);
        Assertions.assertThat(apples.equals(null)).isEqualTo(false);

        Assertions.assertThat(apples.equals(discount)).isEqualTo(false);

        Assertions.assertThat(apples.equals(banane)).isEqualTo(false);
        Assertions.assertThat(apples.equals(toothbrush)).isEqualTo(false);
        
        Assertions.assertThat(apples.equals(apples1)).isEqualTo(true);
        Assertions.assertThat(apples.equals(apples2)).isEqualTo(false);


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
