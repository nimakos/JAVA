import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Vaggelis on 26/4/2017.
 */
public class CashRegister{

    public int counter;
    public double purchase;
    public double payment;

   public CashRegister() {
        }

    public double recordPurchase(ArrayList<Double> price)
    {
        counter = 0;
        purchase = 0;
        for (int i=0; i<price.size(); i++ ) {
            double total= purchase + price.get(i);
            purchase = total;
            counter++;
        }
        return purchase;
    }

    public int howmany()
    {
        return counter;
    }


    public void enterPayment(double lefta)
    {
            payment = lefta;
    }


    public double giveChange()
    {
        double change = payment - purchase;
           payment = 0;
           purchase = 0;

        return change;
    }

    public double more(double lefta)
    {
        double epipleon = purchase-lefta;
            purchase = 0;
            payment = 0;

        return epipleon;
    }

    public void create()
    {
        //Δημιουργία νέου αντικειμένου προκειμένου να αποδώσει τις τιμές στις συναρτήσεις της κλάσης
        CashRegister register = new CashRegister();

        // Create an ArrayList of objects.
        ArrayList<Products> list = new ArrayList<>();
        list.add(new Products(1, 13.4, "Ψυγείο"));
        list.add(new Products(2, 23.7, "TV"));
        list.add(new Products(3, 17.9, "Καρέκλες"));
        list.add(new Products(4, 36.2, "Κλίμα"));
        list.add(new Products(5, 48.4, "Υπολογιστής"));
        list.add(new Products(6, 54.1, "Σκούπα"));
        list.add(new Products(7, 45.4, "Καναπές"));
        list.add(new Products(8, 8.8,  "Κουζίνα"));
        list.add(new Products(9, 4.5,  "Ρολόϊ"));

        // Δημιουργία 1 λίστας για αποθήκευση ξεχωριστά των χαρακτηριστικών του κάθε προϊόντος
        ArrayList<Double> price = new ArrayList<Double>();

        //Δημιουργία καινούριας λίστας για αποθήκευση όλων χαρακτηριστικών των αγορασμένων προϊόντων
        ArrayList<Object> sinolo = new ArrayList<>();

        //Scanner για input
        Scanner input = new Scanner(System.in);


        try {
            double lefta;
            int code;
            int counter=0;
            int counter2=0;
            int counter3=0;
            System.out.println("Παρακαλώ καταχώρησε τον κωδικό προϊόντος από 1 έως 9, Για εκτύπωση απόδειξης πάτα το 0:");
            do {

                code = input.nextInt();

                // Λούπα για να ψάξει από την λίστα με τα καρφωτά προϊόντα
                for (Products i : list) {

                    //Εαν ταυτίζονται οι κωδικοί τότε αποθήκευσε στις καινούριες λίστες τα νέα στοιχεία
                    if (i.getcode() == code) {
                        price.add(i.getprice());
                        sinolo.add(new Products(i.getcode(), i.getprice(), i.getstring()));

                        System.out.println(i.getstring() + "\t" + "Τιμή: " + i.getprice());
                        counter2++;
                    }
                    else
                    {
                        //Ο counter θα ελέγξει πόσες φορές μπήκαμε στην συνθήκη else αν ταυτιστεί με το μέγεθος της λίστας πάει να πεί ότι μπήκε π.χ. 9 φορές και δεν βρήκε τίποτα
                        counter++;
                        if(counter == list.size() && code!=0)
                        {
                            System.out.println("Λάθος Κωδικός Προσπάθησε Ξανά");
                            counter3++;
                        }
                        //Αν κατα την πρώτη είσοδο πατηθεί το 0 και στη συνέχεια χωρις να έχουν οριστεί προϊόντα να κλεισεί το πρόγραμμα
                        if(code==0 && counter3>=0 && counter2==0 )
                        {
                            register.print_price(sinolo, price);
                            System.exit(0);
                        }
                    }
                }
                counter = 0;
            } while (code != 0);

            System.out.println("---------------- Σύνολο Αγορών--------------------: " + Math.round(register.recordPurchase(price)*1000d)/1000d + "€");

            while (true) {
                Scanner input1 = new Scanner(System.in);
                System.out.println("\nΠαρακαλώ Δώστε μου τα Χρήματα");
                lefta = input1.nextDouble();
                if (register.recordPurchase(price) <= lefta) {
                    register.recordPurchase(price);
                    register.enterPayment(lefta);
                    register.print_price(sinolo, price);
                    return;
                } else
                    {

                        System.out.println("Παρακαλώ δώστε μου επιπλέον: "   +Math.round(register.more(lefta)*1000d)/1000d +"€");

                    }
            }
        }
        catch (Exception e)
        {
            System.out.println("Λανθασμένη Είσοδος Στοιχείων");
        }
    }


     public void print_price(ArrayList<Object> sinolo, ArrayList<Double> price)
    {
        System.out.println("\n************************************************");
        for (int i=0; i<sinolo.size(); i++ )
        {
            System.out.println(sinolo.get(i));
        }
        System.out.println("\n************************************************");
        System.out.println("Αριθμός ποϊόντων που αγοράσατε: "   +howmany());
        System.out.println("Σύνολο Αγορών: "   +Math.round(recordPurchase(price)*1000d)/1000d +"€");
        System.out.println("Μου Δώσατε: "   +Math.round((payment)*1000d)/1000d +"€");
        System.out.println("Τα Ρέστα σας θα είναι: "   +Math.round(giveChange()*1000d)/1000d +"€");
        System.out.println("**************************************************");
    }
}