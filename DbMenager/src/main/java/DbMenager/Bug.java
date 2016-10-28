
package DbMenager;


public class Bug {
 
    
    public String cantFindDriver (){
    return "Driver db is not exist";
}
    public String disableConnect(){
    return "No connect";
    }
    public String cantConstructTable (){
    return "I cant construct table";
    }
    public String cantInsert (String value){
    return "I cant insert in " + value ;
    }
}
