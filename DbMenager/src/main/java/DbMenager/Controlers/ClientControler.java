package DbMenager.Controlers;



import DbMenager.Controlers.Key;
import model.Client;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ClientControler  implements iControlers  {

    private static String dbCreateInfo = "";
    private static String[] records = new String[3];

    public String getDbCreateInfo() {
        return dbCreateInfo;
    }

    public void setDbCreateInfo(String dbCreateInfo) {
        this.dbCreateInfo = dbCreateInfo;
    }


    public  void init() {
        Key key = new Key();
        key.setNameTable("Client");
        key.setNamePrimaryKey("id");
        ArrayList<String> infoList = new ArrayList<String>();
        infoList.add("name varchar (255), ");
        infoList.add("surName varchar (255), ");
        infoList.add("login varchar (255)");
        key.setNameRecords(infoList);
        key.build();
        dbCreateInfo = key.getInfo();

    }
    public void setList (String ... list){
       records = list; 
    }
    public String[] getRecords (){
        return records;
    }

    public String getRecord(int index){
        return records[index];
    }
   public String createInsert (){
       
	return "INSERT INTO Client"
        + "(NAME, SURNAME, LOGIN ) VALUES"
        + "(NULL,?,?,?)";
   }
    public String select (){
        return "SELECT * FROM Client";
    }

}
