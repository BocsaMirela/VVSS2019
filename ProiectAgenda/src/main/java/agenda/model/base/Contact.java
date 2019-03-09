package agenda.model.base;

import agenda.exceptions.InvalidFormatException;

public class Contact {
    private String name;
    private String address;
    private String telefon;

    public Contact() {
        name = "";
        address = "";
        telefon = "";
    }

    public Contact(String name, String address, String telefon) {
        this.name = name;
        this.address = address;
        this.telefon = telefon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append("#");
        sb.append(address);
        sb.append("#");
        sb.append(telefon);
        sb.append("#");
        return sb.toString();
    }


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Contact)) return false;
        Contact o = (Contact) obj;
        if (name.equals(o.name) && address.equals(o.address) &&
                telefon.equals(o.telefon))
            return true;
        return false;
    }

}
