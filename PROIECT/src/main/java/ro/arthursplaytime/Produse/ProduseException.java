package ro.arthursplaytime.Produse;

public class ProduseException extends RuntimeException{
    public ProduseException(){
        super("Nu exista acest id !");
    }
}
