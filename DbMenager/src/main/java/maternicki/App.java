package maternicki;

import DbMenager.OrderMenager;
public class App 
{
    
    private static  OrderMenager db = new OrderMenager ();
    public static void main( String[] args )
    {
        db.createDb();
    }
}
