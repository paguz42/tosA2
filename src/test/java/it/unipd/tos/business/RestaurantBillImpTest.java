////////////////////////////////////////////////////////////////////
// MANUEL PAGOTTO 1144708
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

public class RestaurantBillImpTest {

	@Test
	public void getOrderPrice_Standard_Test() {
		List<MenuItem> conto = new ArrayList<MenuItem>();
		RestaurantBillImp cassa = new RestaurantBillImp();
		conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",23));
		conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",24));
        conto.add(new MenuItem(MenuItem.itemType.PRIMI,"Spaghetti",2.5));
        conto.add(new MenuItem(MenuItem.itemType.PRIMI,"Risotto",3));
		double totale = 0;
        try {
            totale = cassa.getOrderPrice(conto);
        } catch (RestaurantBillException e) {
            e.printStackTrace();
        }
		assertEquals(totale, 52.5, 0.001);
		
	}
	
	@Test
	public void getOrderPrice_MoreThan10Pizzas_Test() {
	    List<MenuItem> conto = new ArrayList<MenuItem>();
        RestaurantBillImp cassa = new RestaurantBillImp();
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",13));
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",24));
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",2.5));
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",3));
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",13));
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",13));
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",4));
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",2.5));
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",3));
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",4));
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",2.5));
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",3));
        conto.add(new MenuItem(MenuItem.itemType.PRIMI,"Spaghetti",2.5));
        conto.add(new MenuItem(MenuItem.itemType.PRIMI,"Risotto",3));
        conto.add(new MenuItem(MenuItem.itemType.PRIMI,"Spaghetti",2.5));
        conto.add(new MenuItem(MenuItem.itemType.PRIMI,"Risotto",3));

        double totale = 0;
        try {
            totale = cassa.getOrderPrice(conto);
        } catch (RestaurantBillException e) {
            e.printStackTrace();
        }
        assertEquals(totale, 96, 0.001);
	}
	
	
	@Test
	public void getOrderPrice_MoreThan100Euros_Test() {
	    List<MenuItem> conto = new ArrayList<MenuItem>();
	    RestaurantBillImp cassa = new RestaurantBillImp();
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",13));
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",24));
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",2.5));
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",3));
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",43));
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",13));
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",4));
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",2.5));
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",3));
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",4));
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",2.5));
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",3));
	    conto.add(new MenuItem(MenuItem.itemType.PRIMI,"Spaghetti",2.5));
	    conto.add(new MenuItem(MenuItem.itemType.PRIMI,"Risotto",3));
	    conto.add(new MenuItem(MenuItem.itemType.PRIMI,"Spaghetti",2.5));
	    conto.add(new MenuItem(MenuItem.itemType.PRIMI,"Risotto",3));

	    double totale = 0;
	    try {
	        totale = cassa.getOrderPrice(conto);
	    } catch (RestaurantBillException e) {
	        e.printStackTrace();
	    }
	    assertEquals(totale, 119.7, 0.001);
	}
	
	
	@Test(expected = RestaurantBillException.class)
	public void getOrderPrice_MoreThan20Items_Test() throws RestaurantBillException {
	    List<MenuItem> conto = new ArrayList<MenuItem>();
	    RestaurantBillImp cassa = new RestaurantBillImp();
	    for(int i=1;i < 13;i++) {
	        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",13));
	        conto.add(new MenuItem(MenuItem.itemType.PRIMI,"Spaghetti",24));
	    }

	    double totale = cassa.getOrderPrice(conto);
	}
}
