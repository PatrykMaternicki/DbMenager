
package DbMenager.Comunicators;


import java.util.Scanner;


public class AdressComunicator implements iComunicators{
    public String[] getList() {
        return list;
    }

  
    
    private static String[] list = new String[5];
    private String[] messages  = {
        "Write BuildingNumber ",
        "Write City ",
        "Write Country ",
        "Write postalCode ",
        "Write street"
    };
    private Scanner input = new Scanner (System.in);
    
    public void run (){
        getMessage(0);
        String outputBuildingNumber = input.nextLine(); 
        getMessage(1);
        String outputCity = input.nextLine();
        getMessage(2);
        String outputCountry = input.nextLine();
        getMessage(3);
        String outputPostalCode = input.nextLine();
        getMessage(4);
        String outputStreet = input.nextLine();
        setVarToList ( new String[]{ 
            outputBuildingNumber,
            outputCity,
            outputCountry,
            outputPostalCode,
            outputStreet
            
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
