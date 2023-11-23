package entities;

import org.w3c.dom.ls.LSOutput;

public class Bill {
    public char gender;
    public int beer;
    public int barbecue;
    public int softDrink;

    public static final double COUVERT_ARTISTICO = 4;

    public double feeding(){
        return (this.beer * 5) + (this.barbecue * 7) + (this.softDrink * 3);
    }

    public double cover(){
        if(feeding() > 30.0){
            return 0.0;
        } else {
            return COUVERT_ARTISTICO;
        }
    }

    public double ticket(){
        if (gender == 'F'){
            return 8.00;
        } else {
            return 10.00;
        }
    }

    public double total(){
        return ticket() + cover() + feeding();
    }
}
