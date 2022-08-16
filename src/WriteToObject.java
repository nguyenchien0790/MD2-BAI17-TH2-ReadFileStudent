import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteToObject {
    public static void main(String[] args) {
        String PATH_FILE = "D:\\IdeaProjects\\MD2_B17_TH2_ReadFileStudent\\src\\student.txt";
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Lê Thị A", "Lào Cai"));
        students.add(new Student(2,"Lê Thị B", "Lai Châu"));
        students.add(new Student(3,"Lê Thị C", "Hải Dương"));
        students.add(new Student(4,"Lê Thị D", "Hà Tĩnh"));
        students.add(new Student(5,"Lê Thị E", "Tây Nguyên"));
        writeToFile(PATH_FILE,students);
        List<Student> studentDataFromFile = readDataFromFile(PATH_FILE);
        for (Student student:
             studentDataFromFile) {
            System.out.println(student);
        }

    }
    public static void writeToFile(String path, List<Student> students){
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>)  ois.readObject();
            fis.close();
            ois.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return students;
    }
}
