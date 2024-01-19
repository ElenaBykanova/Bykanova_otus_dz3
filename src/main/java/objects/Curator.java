package objects;

public class Curator {
    private long id;
    private String fio;

    public Curator(Long id, String fio){
        this.id=id;
        this.fio=fio;
    }

    public Curator(String fio){
        this.fio=fio;
    }

    public long getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    @Override
    public String toString() {
        return "Curator{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                "}";
    }
}
