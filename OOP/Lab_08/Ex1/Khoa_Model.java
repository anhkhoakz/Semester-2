import java.util.ArrayList;

public class Khoa_Model<T> {
    private ArrayList<T> al = new ArrayList<>();

    public void add(T obj) {
        al.add(obj);
    }

    public void display() {
        for (T obj : al) {
            System.out.println(obj);
        }
    }

}