
package DbMenager.Controlers;

public interface iControlers {
 public void init ();
 public  String getDbCreateInfo  ();
 public String[] getRecords ();
 public String getRecord(int index);
 public String createInsert ();
public void setList(String[] list);
public String select ();

}
