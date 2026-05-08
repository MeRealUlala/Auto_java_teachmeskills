package model;

public class PlayerRequest {

    private Integer teamId;
    private String firstName;
    private String lastName;
    private String position;
    private Integer age;
    private Integer height;
    private Integer weight;

    public PlayerRequest() {
    }

    public PlayerRequest(Integer teamId, String firstName, String lastName, String position,
                         Integer age, Integer height, Integer weight) {
        this.teamId = teamId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }
}