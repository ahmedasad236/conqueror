package exceptions;

public class NotEnoughGoldException extends Exception{

    NotEnoughGoldException() {
        super();
    }

    NotEnoughGoldException(String s) {
        super(s);
    }
    
}
