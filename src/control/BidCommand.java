
package control;

import model.Bid;
import view.ActiveAuctionLoader;


public class BidCommand implements Command{
    private final ActiveAuctionLoader activeAuctionLoader;
    private final Bid bid;

    public BidCommand(ActiveAuctionLoader activeAuctionLoader, Bid bid) {
        this.activeAuctionLoader = activeAuctionLoader;
        this.bid = bid;
    }

    @Override
    public void execute() {
        activeAuctionLoader.load().addBid(bid);
    }
    
}
