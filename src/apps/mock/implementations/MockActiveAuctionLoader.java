
package apps.mock.implementations;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import model.Auction;
import model.Image;
import model.Product;
import view.ActiveAuctionLoader;


public class MockActiveAuctionLoader implements ActiveAuctionLoader{

    @Override
    public Auction load() {
        List<Image>images = new ArrayList<>();
        images.add(new Image("mesa_camping1.png"));
        images.add(new Image("mesa_camping2.png"));
       
        Auction auction  = new Auction(new Product("Mesa", "Mesa de camping", images), 2.0, new Time(10,0,0));
        
        return auction;
    }
    
}
