import java.io.*;
import java.util.Scanner;

class People implements Serializable{
    String last_name;
    String name;
    int year;
    int month;
}

public class var8method2{
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Scanner sc = new Scanner(System.in, "cp1251");
        File f = new File("C:\\Users\\USER\\My\\method2");
        if (f.exists()) f.delete();
        f.createNewFile();

        System.out.println("Введите количество людей: ");
        int N = sc.nextInt();
        sc.nextLine();

        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        People people;
        for (int i = 0; i < N; i++){
            people = new People();
            System.out.println("Введите информацию о "+ (i + 1) + "м человеке: ");
            System.out.print("Фамилию человека => ");
            people.last_name = sc.next();
            System.out.print("Имя человека => ");
            people.name = sc.next();
            System.out.print("Год рождения человека => ");
            people.year = sc.nextInt();
            System.out.print("Месяц рождения человека (от 1 до 12)=> ");
            people.month = sc.nextInt();
            oos.writeObject(people);
        }

        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream oin = new ObjectInputStream(fis);

        for (int i = 0; i < N; i++){
            people = (People) oin.readObject();
            if (people.month == 1){
                System.out.println("Фамилия человека: " + people.last_name);
                System.out.println("Имя человека: " + people.name);
                System.out.println("Год рождения человека: " + people.year);
                System.out.println("Месяц рождения человека: " + "january");
            }
        }
        oos.close();
    }
}
