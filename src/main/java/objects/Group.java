package objects;

public class Group {
    private long id, id_curator;
    private String name;

    public Group(Long id, String name, long id_curator) {
        this.id=id;
        this.name=name;
        this.id_curator=id_curator;
    }

    public Group(String name, long id_curator) {
        this.name = name;
        this.id_curator = id_curator;
    }

    public long getId() {
        return id;
    }

    public long getId_curator() {
        return id_curator;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", id_curator='" + id_curator + '\'' +
                '}';
    }
}
