package functional_programming.immutability.examplea;

public final class College {
    private String nameField;
    private Address addressField;

    public College(String nameField, Address addressField) {
        this.nameField = nameField;
        this.addressField = addressField;
    }

    public String getNameField() {
        return nameField;
    }

    public void setNameField(String nameField) {
        this.nameField = nameField;
    }

    public Address getAddressField() {
        return addressField;
    }

    public void setAddressField(Address addressField) {
        this.addressField = addressField;
    }
}
