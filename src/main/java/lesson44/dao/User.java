package lesson44.dao;

public class User {
    private Integer id;
    private String first;
    private String last;

    public User(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Integer getId() {
        return id;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}
