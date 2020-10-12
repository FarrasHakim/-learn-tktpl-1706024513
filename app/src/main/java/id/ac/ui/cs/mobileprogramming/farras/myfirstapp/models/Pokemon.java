package id.ac.ui.cs.mobileprogramming.farras.myfirstapp.models;

public class Pokemon {
    private Integer id;
    private String name;
    private String type;
    private String desc;

    public Pokemon(Integer id, String name, String type, String desc) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
