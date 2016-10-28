
package DbMenager.Controlers;


import java.util.ArrayList;

public class OrderItemControler implements iControlers {
     private String dbCreateInfo = "";
    private String[] records = new String[3];

    public String getDbCreateInfo() {
        return dbCreateInfo;
    }

    public void setDbCreateInfo(String dbCreateInfo) {
        this.dbCreateInfo = dbCreateInfo;
    }


    public  void init() {
        Key key = new Key();
        key.setNameTable("OrderItem");
        key.setNamePrimaryKey("id");
        ArrayList<String> infoList = new ArrayList<String>();
        infoList.add("name varchar(255),");
        infoList.add("description varchar (255), ");
        infoList.add("price double (255)");
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
       
	return "INSERT INTO OrderItem "
        + "(NAME, DESCRIPTION, price ) VALUES"
        + "(NULL,?,?,?)";
   }
      public String select (){
        return "SELECT * FROM OrderItem";
    }
   

}
