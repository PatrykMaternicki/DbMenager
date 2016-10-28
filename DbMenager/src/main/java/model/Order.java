
package model;


import java.util.ArrayList;

public class Order {

    private long id;
    private Client clientDeatils;
    private Adress deliveryAdress;
    private ArrayList<OrderItem>items = new ArrayList<OrderItem>();
    
}
