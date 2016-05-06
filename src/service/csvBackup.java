package service;

import dao.ExchangeDao;
import model.Exchange;

public class csvBackup {

    private static csvBackup instance;

    public csvBackup(){

    }

    public static csvBackup getInstance(){
        if(instance == null)
            instance = new csvBackup();
        return instance;
    }

    //public String getBackup(){
        public String make_backup() {

            String NEW_LINE_SEPARATOR = "\n";
            String file_header = "Buyer, Seller, instrument, type of trade, quantity, Buyer Remained Money, Seller Current Money\n";
            String outResult = file_header;

            for (Exchange e : ExchangeDao.getInstance().getAllExchanges()) {

                //for(Order o : approvedOrders.list){
                String line = e.getBuyerId() + ',' + e.getSellerId() + ',' + e.getSymbol() + ',' + e.getType() +
                        e.getQuantity() + ',' + e.getBuyPrice();
                outResult = line + NEW_LINE_SEPARATOR;
                //}

            }

            return outResult;
        }
    //}
}
