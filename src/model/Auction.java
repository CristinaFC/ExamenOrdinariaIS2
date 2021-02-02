package model;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


public class Auction {
    
    private final Product product;
    private Double initPrice;
    private List<Bid> bids = new ArrayList<>();
    private Time leftTime;

    public Auction(Product object, Double initPrice, Time leftTime) {
        this.product = object;
        this.initPrice = initPrice;
        this.leftTime = leftTime;
    }

    public Product product() {
        return product;
    }

    public void addBid(Bid bid){
        if(!checkBid(bid)) {
            System.out.println("Fallo al hacer la puja. Vuelve a seleccionar una opción: ");
            return;
        }
        initPrice = bid.price();
        bids.add(bid);
        for (Bid bid1 : bids) {
            System.out.println(bid.toString());
        }
        System.out.println("Puja realizada.\n"
                + "Precio actual del producto:" + initPrice);
    }

    private boolean checkBid(Bid bid) {
        return checkCorrectProductBid(bid) && checkBidPrice(bid);
    }

    private boolean checkBidPrice(Bid bid) {
        if (bid.price() > initPrice) return true;
        System.out.println("El precio debe ser mayor que la última puja");
        return false;
    }

    private boolean checkCorrectProductBid(Bid bid) {
        if (product.name().equals(bid.productName())) return true;
        System.out.println("La puja no corresponde con esta subasta");
        return false;
    }
    
    public List<Bid> getBids() {
        return bids;
    }

    public Time getLeftTime() {
        return leftTime;
    }
    
    public String description(){
        return product.getDescription();
    }

    @Override
    public String toString() {
        return "Auction{" + "product=" + product + ", initPrice=" + initPrice + ", bids=" + bids + ", leftTime=" + leftTime + '}';
    }
    
    public String actualBids(){
        String res = "";
        for (int i = 0; i < bids.size(); i++) {
            res += bids.get(i).toString();
        }
        return res;
    }
    
    
}
