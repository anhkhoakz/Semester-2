public class Khoa_Person {
    protected String name;
    protected int birth_year;

    public Khoa_Person() {
        this.name = "";
        this.birth_year = -1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthYear(int year) {
        this.birth_year = year;
    }

    public Khoa_Person(String name, int year) {
        setName(name);
        setBirthYear(year);
    }

    public String getName() {
        return this.name;
    }

    public int getBirthYear() {
        return this.birth_year;
    }

    public String toString() {
        return "Name: " + getName() + ", Birth Year: " + getBirthYear();
    }
}
