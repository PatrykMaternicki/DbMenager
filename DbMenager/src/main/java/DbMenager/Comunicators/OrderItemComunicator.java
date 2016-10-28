
package DbMenager.Comunicators;


import java.util.Scanner;

public class OrderItemComunicator implements iComunicators {
    
     public String[] getList() {
        return list;
    }

    public void setList(String[] list) {
        this.list = list;
    }
    
    private String[] list = new String[2];
    private String[] messages  = {
        "Write description ",
        "Write name ",
        "Write price "
    };
    private Scanner input = new Scanner (System.in);
    
    public void run (){
        getMessage(0);
        String outputDescription = input.nextLine(); 
        getMessage(1);
        String outputName = input.nextLine();
        getMessage(2);
        String outputPrice = input.nextLine();
      
        setVarToList ( new String[]{ 
          outputDescription,
          outputName,
          outputPrice 
        });
        testList();
    }
    private void getMessage(int index){
        System.out.println(messages[index]);
        
        
    }
    
    private void setVarToList (String ... outputList){
       for (int i =0; outputList.length - 1 > i; i++){
           list[i] = outputList[i];
       }
   
    }

    public void testList() {
        for (String record: list){
           System.out.println(record); 
        }
    }
    
}
