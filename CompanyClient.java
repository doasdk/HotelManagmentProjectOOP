package pl.edu.amu.wmi.s474155;

import pl.edu.amu.wmi.s474155.Client;

public class CompanyClient extends Client {
    private boolean receipt;
    private int recId;

    public CompanyClient(int clientId, String surname, String name, String sex, boolean receipt, int recId){
        super(clientId, surname, name, sex);
        this.receipt = receipt;
        this.recId = recId;
    }
    public CompanyClient(int clientId, String surname, String name, String sex, boolean receipt){
        super(clientId, surname, name, sex);
        this.receipt = receipt;
        this.recId = 0;
    }

    public void setReceipt(boolean receipt){
        this.receipt = receipt;
    }
    public boolean getReceipt(){
        return receipt;
    }

    public void setRecId(int recId){
        this.recId = recId;
    }
    public int getRecId(){
        return recId;
    }
}
