package wad.wo4.strarttech14patients.Nurses.DataModel;

public class DoctorData {

    String name,special;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public DoctorData(String name, String special) {
        this.name = name;
        this.special = special;
    }
}
