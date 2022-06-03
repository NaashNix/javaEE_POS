package dto;

public class CustomerDTO {
    private String idNumber;
    private String customerName;
    private String telephoneNumber;
    private String address;

    public CustomerDTO() {
    }

    public CustomerDTO(String idNumber, String customerName, String telephoneNumber, String address) {
        this.idNumber = idNumber;
        this.customerName = customerName;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "idNumber='" + idNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
