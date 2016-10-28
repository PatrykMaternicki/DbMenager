package DbMenager.Controlers;




import java.util.ArrayList;

public  class Key {
    
    private static String info;
    private String nameTable ;
    private String namePrimaryKey;
    private ArrayList<String> nameRecords = new ArrayList<String>();

    public static  String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ArrayList<String> getNameRecords() {
        return nameRecords;
    }

    public void setNameRecords(ArrayList<String> nameRecords) {
        this.nameRecords = nameRecords;
    }

    public String getNamePrimaryKey() {
        return namePrimaryKey;
    }

    public void setNamePrimaryKey(String namePrimaryKey) {
        this.namePrimaryKey = namePrimaryKey;
    }

    public String getNameTable() {
        return nameTable;
    }

    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }
    
    public  void build (){
        info = "CREATE TABLE IF NOT EXIST " + nameTable;
        info += "( " + namePrimaryKey + " BIGINT PRIMARY KEY AUTOINCREMENT, ";
        for (int i = 0; nameRecords.size() > i; i++){
            info += nameRecords.get(i);
        }
        info += " )";
        
    }
    
    
    
    
    
    
}
