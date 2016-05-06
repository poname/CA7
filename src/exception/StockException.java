package exception;

/**
 * Created by dani on 4/7/2016.
 */
public abstract class StockException extends Exception {
    String message = "parent message";
    public String getMessage(){
        return this.message;
    }
}
