package wad.wo4.strarttech14patients.Doctors.DataModel;

public class ExerciseList {

    String category,exername, repcount, repduration;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getExername() {
        return exername;
    }

    public void setExername(String exername) {
        this.exername = exername;
    }

    public String getRepcount() {
        return repcount;
    }

    public void setRepcount(String repcount) {
        this.repcount = repcount;
    }

    public String getRepduration() {
        return repduration;
    }

    public void setRepduration(String repduration) {
        this.repduration = repduration;
    }

    public ExerciseList(String category, String exername, String repcount, String repduration) {
        this.category = category;
        this.exername = exername;
        this.repcount = repcount;
        this.repduration = repduration;
    }
}
