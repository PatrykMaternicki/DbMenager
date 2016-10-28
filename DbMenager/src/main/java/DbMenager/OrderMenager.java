package DbMenager;
import DbMenager.Comunicators.AdressComunicator;
import DbMenager.Comunicators.ClientComunicator;
import DbMenager.Comunicators.OrderItemComunicator;
import DbMenager.Comunicators.iComunicators;
import DbMenager.Controlers.AdressControler;
import DbMenager.Controlers.ClientControler;
import DbMenager.Controlers.OrderItemControler;
import DbMenager.Controlers.iControlers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import model.Adress;
import model.Client;
import model.OrderItem;

public class OrderMenager {
 
    public static final String DB_DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:hsqldb:hsql://localhost/companydb";
    public  static Bug bug;
    private static iControlers ClientControler = new ClientControler ();
    private static iControlers AdressControler = new AdressControler ();
    private static iControlers OrderItemControler = new OrderItemControler ();
    
    private static Connection connect;
    private static Statement status;
    
    public OrderMenager (){
        try {
            Class.forName(OrderMenager.DB_DRIVER);
        } catch (ClassNotFoundException e) {
           bug = new Bug ();
           System.err.println(bug.cantFindDriver());
            e.printStackTrace();
        }
 
        try {
            connect = DriverManager.getConnection(DB_URL);
            status = connect.createStatement();
        } catch (SQLException e) {
            bug = new Bug();
            System.err.println(bug.disableConnect());
            e.printStackTrace();
        }
        createDb();
   
        
    }
    public static boolean createDb(){
      System.out.println("Database Start");
      ClientControler.init();
      AdressControler.init();
      OrderItemControler.init();
      try {
            status.execute(ClientControler.getDbCreateInfo());
            status.execute(AdressControler.getDbCreateInfo());
            status.execute(OrderItemControler.getDbCreateInfo());
      }
      catch (SQLException e) {
            bug = new Bug ();
            System.err.println(bug.cantConstructTable());
            e.printStackTrace();
            return false;
       
    }
      return true;
    }
    
    public boolean insertClient(){
       iComunicators comunicator = new ClientComunicator ();
        comunicator.run();
        ClientControler.setList(comunicator.getList());
        
        try {
            
        
            PreparedStatement prepStmt = connect.prepareStatement(
                    ClientControler.createInsert());
            prepStmt.setString(1, ClientControler.getRecord(0) );
            prepStmt.setString(2, ClientControler.getRecord(1));
            prepStmt.setString(3, ClientControler.getRecord(2));
            prepStmt.execute();
    }
        catch (SQLException e) {
            bug = new Bug();
            System.err.println(bug.cantInsert("Reader"));
             e.printStackTrace();
            return false;
            
        }
        return true;
    }
    
    public boolean insertAdress(){
       iComunicators comunicator = new AdressComunicator ();
        comunicator.run();
        AdressControler.setList(comunicator.getList());
        
        try {
            
        
            PreparedStatement prepStmt = connect.prepareStatement(
                    AdressControler.createInsert());
            prepStmt.setString(1, AdressControler.getRecord(0) );
            prepStmt.setString(2, AdressControler.getRecord(1));
            prepStmt.setString(3, AdressControler.getRecord(2));
            prepStmt.setString(4, AdressControler.getRecord(3));
            prepStmt.setString(5, AdressControler.getRecord(4));
            prepStmt.execute();
    }
        catch (SQLException e) {
            bug = new Bug();
            System.err.println(bug.cantInsert("Adress"));
             e.printStackTrace();
            return false;
            
        }
        return true;
    }
    
    
    public boolean insertOrderItem(){
       iComunicators comunicator = new OrderItemComunicator ();
        comunicator.run();
        OrderItemControler.setList(comunicator.getList());
        
        try {
            
        
            PreparedStatement prepStmt = connect.prepareStatement(
                    OrderItemControler.createInsert());
            prepStmt.setString(1, AdressControler.getRecord(0) );
            prepStmt.setString(2, AdressControler.getRecord(1));
            prepStmt.setString(3, AdressControler.getRecord(1));
            prepStmt.execute();
    }
        catch (SQLException e) {
            bug = new Bug();
            System.err.println(bug.cantInsert("Order Item"));
             e.printStackTrace();
            return false;
            
        }
        return true;
    }
    public List<Client> selectClient() {
        List<Client> clients = new LinkedList<Client>();
        try {
            ResultSet result = status.executeQuery(ClientControler.select());
            long id;
            String name, surName, login;
            while(result.next()) {
                id = result.getLong("id");
                name = result.getString("name");
                surName = result.getString("surname");
                login = result.getString("login");
                clients.add(new Client(id, name, surName, login));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return clients;
    }
    
    
      public List<Adress> selectAddress() {
        List<Adress> adress = new LinkedList<Adress>();
        try {
            ResultSet result = status.executeQuery(AdressControler.select());
            long id;  
            String street , buildingNumber , flatNumber , postalCode ,  city ,country;
            while(result.next()) {
                id = result.getLong("id");
                street = result.getString("street");
                buildingNumber = result.getString("buildingNumber");
                flatNumber = result.getString("flatNumber");
                postalCode = result.getString("postalCode");
                city = result.getString("city");
                country = result.getString("country");
                adress.add(new Adress(id, street, buildingNumber, flatNumber, postalCode, city, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return adress;
    }
      
         public List<OrderItem> selectOrderItem() {
        List<OrderItem> orderItem = new LinkedList<OrderItem>();
        try {
            ResultSet result = status.executeQuery(AdressControler.select());
            long id;  
            String name , description;
            double price;
            while(result.next()) {
                id = result.getLong("id");
                name = result.getString("name");
                description = result.getString("description");
                price = result.getDouble("price");
                orderItem.add(new OrderItem(id, name, description, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return orderItem;
    }
         
           public void closeConnection() {
        try {
            connect.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }
    
}