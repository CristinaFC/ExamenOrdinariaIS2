package apps.mock.implementations;

import java.sql.Time;
import model.Auction;
import view.ActiveAuctionDisplay;


public class MockActiveAuctionDisplay implements ActiveAuctionDisplay{

    private Auction auction;

    @Override
    public void display(Auction auction) {
        this.auction = auction;
        System.out.println(auction.description());
    }

    public Auction activeAction() {
        if(auction.getLeftTime().equals(new Time(0, 0, 0))) return null;
        return auction;
    }

    
}
