
package DbMenager.Comunicators;


import java.util.Scanner;

public class ClientComunicator implements iComunicators {

    public String[] getList() {
        return list;
    }

    public void setList(String[] list) {
        this.list = list;
    }
    
    private String[] list = new String[2];
    private String[] messages  = {
        "Write Name /n",
        "Write SurName /n ",
        "Write Login /n "
    };
    private Scanner input = new Scanner (System.in);
    
    public void run (){
        getMessage(0);
        String outputName = input.nextLine(); 
        getMessage(1);
        String outputSurName = input.nextLine();
        getMessage(2);
        String outputLogin = input.nextLine();
        setVarToList ( new String[]{ 
            outputName,
            outputSurName,
            outputLogin
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