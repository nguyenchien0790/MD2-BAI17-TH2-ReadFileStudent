import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteToObject {
    public static void main(String[] args) {
        String PATH_FILE = "D:\\IdeaProjects\\MD2_B17_TH2_ReadFileStudent\\src\\student.txt";
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"AAA", "VietNam"));
        students.add(new Student(2,"BBB", "England"));
        students.add(new Student(3,"CCC", "Mexico"));
        students.add(new Student(4,"DDD", "Japan"));
        students.add(new Student(5,"EEE", "Indo"));
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
