package Project;

public abstract class Person {

    private String name;
    private int age;
    private String gender;

    public Person(String n, int a, String g) {
        this.name = n;
        this.age = a;
        this.gender = g;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public abstract String Check_Information();

    @Override
    public String toString() {
        return "Name: " + name + " , Age: " + age + " , Gender: " + gender;
    }
}
