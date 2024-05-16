package wad.wo4.strarttech14patients.Nurses.DataModel;

public class PatientData {

    String name,age,gender,id,status,link;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public PatientData(String name, String age, String gender, String id, String status, String link) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = id;
        this.status = status;
        this.link = link;
    }
}
