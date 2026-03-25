package model;

public class Librarian extends User  {

    private  String employeeCode;

    public Librarian (String id ,String name ,String email,String employeeCode) {
        super(id, name, email);
        this.employeeCode=employeeCode;
        
    }

    @Override
    public String getDetails(){

        return "Librarian no:"+employeeCode+toString();
    }

     public String getEmployeeCode() {
        return employeeCode;
    }



    

    

    

}
