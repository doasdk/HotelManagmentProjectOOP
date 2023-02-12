package pl.edu.amu.wmi.s474155;

import java.io.Serializable;

public class Client implements Serializable  {

    private int clientId;
    private String surname;
    private String name;
    private String sex;

    public Client (int clientId, String surname, String name, String sex){
        this.clientId = clientId;
        this.surname = surname;
        this.name = name;

        try {
            if((sex.length() == 1) && ((sex.equals("f")) || (sex.equals("m")))){
                this.sex = sex;
            }else {
                throw new LengthException();
            }
        }catch(LengthException e){
            System.out.println("Gender length must be 1 letter: 'f' for 'female' and 'm' for 'male'");
        }
    }

    public void setClientId(int clientId){
        this.clientId = clientId;
    }
    public int getClientId() {
        return clientId;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }
    public String getSurname() {
        return surname;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setSex(String sex){ this.sex = sex; }
    public String getSex() { return sex; }

}
