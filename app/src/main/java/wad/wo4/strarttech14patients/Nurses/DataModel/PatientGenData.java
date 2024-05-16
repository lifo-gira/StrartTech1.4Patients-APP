package wad.wo4.strarttech14patients.Nurses.DataModel;

public class PatientGenData {

    String name,age,gender,id,link;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public PatientGenData(String name, String age, String gender, String id, String link) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = id;
        this.link = link;
    }
}
