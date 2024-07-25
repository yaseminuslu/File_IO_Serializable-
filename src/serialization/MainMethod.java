package serialization;

import java.io.*;

public class MainMethod {
    public static void main(String[]args) throws IOException, ClassNotFoundException {
        Course course= new Course("matematik");
        Student student= new Student("Yasemin","uslu",course);
        //writeFile(student,"C:\\Users\\ekiny\\OneDrive\\Masaüstü\\Obss-staj\\day3example\\src\\serialization\\newfile.txt");
       readFile("C:\\Users\\ekiny\\OneDrive\\Masaüstü\\Obss-staj\\day3example\\src\\serialization\\newfile.txt");

    }
    public static void writeFile(Student student, String filePath) throws IOException {
        try(FileOutputStream fileOutputStream=new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream)){

            objectOutputStream.writeObject(student);
            objectOutputStream.flush();
        }
    }


    public static void readFile(String filePath) throws IOException, ClassNotFoundException {
        try(FileInputStream fileInputStream=new FileInputStream(filePath);
        ObjectInputStream objectInputStream= new ObjectInputStream(fileInputStream)){

            Student student= (Student) objectInputStream.readObject();
            System.out.println("Name:"+ student.getName());
            System.out.println("Surname: "+student.getSurname());
            System.out.println("Course: " + student.getCourse().getName());
        }
    }
}
