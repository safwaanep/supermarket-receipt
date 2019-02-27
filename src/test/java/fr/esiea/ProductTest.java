package fr.esiea;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProductTest {
    
@Test 
public void getUntit_Product_Test() {

    Product flour_bag = new Product("flour_bag", ProductUnit.Kilo);
  	Product flour_bag_bis = flour_bag;
    Product apple1 = new Product("apple", ProductUnit.Each);
    Product apple2 = new Product("apple", ProductUnit.Each);
    Product potato_each = new Product("potato", ProductUnit.Each);
    Product potato_kilo = new Product("potato", ProductUnit.Kilo);
    ReceiptItem receiptItem_flour_bag = new ReceiptItem(flour_bag, 4, 5, 20);


    // test of getName()
    assertThat(flour_bag.getName()).isEqualTo("flour_bag");

    // test of getUnit()
    assertThat(flour_bag.getUnit()).isEqualTo(ProductUnit.Kilo);

    // test of equals()
    assertThat(flour_bag.equals(flour_bag_bis)).isEqualTo(true);
    assertThat(flour_bag.equals(receiptItem_flour_bag)).isEqualTo(false);
    assertThat(flour_bag.equals(null)).isEqualTo(false);
    assertThat(apple1.equals(potato_each)).isEqualTo(false);
    assertThat(potato_each.equals(potato_kilo)).isEqualTo(false);
    assertThat(apple1.equals(apple2)).isEqualTo(true);
    

    // test of hashCode()
    assertThat(apple1.hashCode()).isEqualTo(apple2.hashCode());
    assertThat(apple1.hashCode()).isNotEqualTo(flour_bag.hashCode()); 

}

}