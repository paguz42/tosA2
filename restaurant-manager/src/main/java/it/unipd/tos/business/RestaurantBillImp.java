////////////////////////////////////////////////////////////////////
// MANUEL PAGOTTO 1144708
////////////////////////////////////////////////////////////////////


package it.unipd.tos.business;

import java.util.List;
import java.util.stream.Collectors;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

public class RestaurantBillImp implements RestaurantBill{

    public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException {
        if (itemsOrdered.size() > 20) {
            throw new RestaurantBillException();
        }
        
        double final_price = itemsOrdered.stream().mapToDouble(MenuItem::getPrice).sum();
        int pizza_count = (int) itemsOrdered.stream().filter(x -> x.getDish().equals(MenuItem.itemType.PIZZE)).count();
        
        if (pizza_count > 10) {
            final_price -= itemsOrdered.stream()
                                 .filter(x -> x.getDish().equals(MenuItem.itemType.PIZZE))
                                 .mapToDouble(x -> x.getPrice())
                                 .min().getAsDouble();
        }
        
        
        if (final_price > 100) {
            final_price -= final_price/100.0*5.0;
        }
        
        return final_price;
    }

}
