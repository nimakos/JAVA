import java.lang.String;


class Products {
    public int code;
    public double price;
    public String name;

    //constructor με αντικείμενα
    public Products(int code, double price, String name) {
        this.code = code;
        this.name = name;
        this.price = price;
    }
    //Οι συναρτήσεις επιστρέφουν τις τιμές των αντικειμένων

    public int getcode() {
        return code;
    }

    public double getprice() {
        return price;
    }

    public String getstring() {return  name; }

    public String toString() {
        return "Κωδικός : " + this.code  + ", Όνομα : " + this.name + ",\t\t Τιμή : " + this.price+"€";
    }
}

public class Main {
    public static void main(String[] args) {

        //Δημιουργία νέου αντικειμένου προκειμένου να αποδώσει τις τιμές στις συναρτήσεις της κλάσης
        CashRegister register = new CashRegister();
        register.create();
    }
}