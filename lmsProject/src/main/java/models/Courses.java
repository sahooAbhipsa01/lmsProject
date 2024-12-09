package models;

public class Courses {
    private int id;
    private String name;
    private int trainerId;

    public Courses(int id, String name, int trainerId) {
        this.id = id;
        this.name = name;
        this.trainerId = trainerId;
    }

    public Courses() {}

    @Override
    public String toString() {
        return "Courses [id=" + id + ", name=" + name + ", trainerId=" + trainerId + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }
}
