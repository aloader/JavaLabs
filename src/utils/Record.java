package utils;

// stream3, task25_ArrayOfObjectABCSort
public class Record {
    private long id;
    private String name;
    private boolean logged;

    public Record(long id, String name, boolean logged) {
        setId(id);
        setName(name);
        setLogged(logged);
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getFirstLetter() {return name.isEmpty()? "": name.substring(0,1);}
    public boolean getLogged() {
        return logged;
    }

    @Override
    public String toString() {
        return "\n{id="+ this.id + ",name=\""+this.name+"\",logged="+this.logged+"}";
    }
}
