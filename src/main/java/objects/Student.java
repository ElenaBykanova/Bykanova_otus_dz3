package objects;

public class Student {
    private long id, id_group;
    private String sex, fio;

    public Student(String fio, String sex, long id_group) {
        this.fio = fio;
        this.sex = sex;
        this.id_group=id_group;
    }

    public Student(long id, String fio, String sex, long id_group) {
        this.id = id;
        this.fio = fio;
        this.sex = sex;
        this.id_group=id_group;
    }

       public long getId_group() {
        return id_group;
    }

    public String getSex() {
        return sex;
    }

    public String getFio() {
        return fio;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", sex='" + sex + '\'' +
                ", id_group='" + id_group + '\'' +
                '}';
    }
}
