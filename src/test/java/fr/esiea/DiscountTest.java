
package fr.esiea;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DiscountTest 

{

@Test
    public void Discount_Methods_Test () 
    {

    	//We create the product and the discount associated to it
        Product pack_of_beer = new Product("pack of beer ", ProductUnit.Each);
        Discount discount_on_pack_of_beer = new Discount(pack_of_beer, "Beer discounted by 2$",1.25);

        // Testing the medthod getDecription of the class Discount
        assertThat(discount_on_pack_of_beer.getDescription()).isEqualTo("Beer discounted by 2$");

        // Testing the method getProduct on the class Discount
        assertThat(discount_on_pack_of_beer.getProduct()).isEqualTo(pack_of_beer);

        // Testing the method getDiscountAmount on the class Discount
        assertThat(discount_on_pack_of_beer.getDiscountAmount()).isEqualTo(1.25);
    }
    
}