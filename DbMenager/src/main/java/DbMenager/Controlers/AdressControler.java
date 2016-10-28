
package DbMenager.Controlers;

import java.util.ArrayList;

public class AdressControler implements iControlers {
     private String dbCreateInfo = "";
     private static String[] records = new String[5];

    public String getDbCreateInfo() {
        return dbCreateInfo;
    }

    public void setDbCreateInfo(String dbCreateInfo) {
        this.dbCreateInfo = dbCreateInfo;
    }


    public  void init() {
        Key key = new Key();
        key.setNameTable("Adress");
        key.setNamePrimaryKey("id");
        ArrayList<String> infoList = new ArrayList<String>();
        infoList.add("street varchar(255),");
        infoList.add("postalCode varchar (255), ");
        infoList.add("flatNumber varchar (255), ");
        infoList.add("buildingNumber varchar (255)");
        infoList.add("country varchar (255)");
        infoList.add("city varchar (255)");
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
    @Override
    public String getRecord(int index) {
        return this.records[index];
    }

    public String createInsert() {
        return "INSERT INTO Adress"
        + "(STREET, POSTALCODE, FLATNUMBER, BUILDINGNUMBER, COUNTRY, CITY ) VALUES"
        + "(NULL,?,?,?,?,?,?)";
    }
       public String select (){
        return "SELECT * FROM Adress";
    }
   
}
