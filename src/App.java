import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String email;
    private String password;
    private ArrayList<String> courses;

    public Student(String email, String password) {
        this.email = email;
        this.password = password;
        courses = new ArrayList<String>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public void removeCourse(String course) {
        courses.remove(course);
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public boolean checkLogin(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }
}

class Application {
    private ArrayList<Student> students;
    private Scanner sc;

    public Application() {
        students = new ArrayList<Student>();
        sc = new Scanner(System.in);
    }
    public void start() {
        System.out.println("\n");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Kirjautumis - ja rekisteröitymisnäkymä");
        System.out.println("1. Kirjaudu sisään");
        System.out.println("2. Rekisteröidy");
        System.out.println("3. Sulje\n");
        System.out.print("Anna valintasi: \n");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\n");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            login();
        } else if (choice == 2) {
            register();
        }else if (choice == 3) { 
            System.out.println("------------------------Sovellus suljetaan, Nähdään pian!\n");
        }
        else {
            System.out.println("------------------------Väärä valinta, yritä uudelleen\n");
            start();
        }
    }

    private void login() {
        System.out.print("Anna sähköposti \n");
        String email = sc.nextLine();
        System.out.print("Anna salasana: \n");
        String password = sc.nextLine();

        for (Student student : students) {
            if (student.checkLogin(email, password)) {
                studentView(student);
                return;
            }
        }
        System.out.println("\n");
        System.out.println("ERROR:");
        System.out.println("------------------------Väärä salasana tai sähköposti, yritä uudelleen\n");
        start();
    }

    private void register() {
        System.out.print("Anna sähköposti: \n");
        String email = sc.nextLine();
        System.out.print("Anna salasana: \n");
        String password = sc.nextLine();
        
        Student student = new Student(email, password);
        students.add(student);
        System.out.println("\n");
        System.out.println("------------------------Rekisteröityminen onnistui! Voit kirjautua nyt sisään.\n");
        start();
    }

    private void studentView(Student student) {
        System.out.println("\n");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Päänäkymä");
        System.out.println("1. Käyttäjä asetukset");
        System.out.println("2. Kurssi näkymä");
        System.out.println("3. Kirjaudu ulos\n");
        System.out.print("Anna valintasi: \n");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\n");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            accountSettings(student);
        } else if (choice == 2) {
            courseView(student);
        } else if (choice == 3) {            
            System.out.println("\n");
            System.out.println("------------------------Kirjaudutaan ulos, Heippa!\n");
            start();
        } else {
            System.out.println("\n");
            System.out.println("ERROR:");
            System.out.println("------------------------Väärä valinta, yritä uudelleen\n");
            studentView(student);
        }
    }

    private void accountSettings(Student student) {
        System.out.println("\n");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Käyttäjä asetukset");
        System.out.println("1. Vaihda sähköposti");
        System.out.println("2. Vaihda salasana2");
        System.out.println("3. Palaa takaisin\n");
        System.out.print("Anna valintasi: \n");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\n");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.print("Anna uusi sähköposti: \n");
            String email = sc.nextLine();
            student.setEmail(email);
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("------------------------Sähköposti vaihdettu onnistuneesti.\n");
        } else if (choice == 2) {
            System.out.print("Anna uusi salasana: ");
            String password = sc.nextLine();
            student.setPassword(password);
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("------------------------Salasana vaihdettu onnistuneesti.\n");
        } else if (choice == 3) {
            studentView(student);
        }
        else {
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("ERROR:");
            System.out.println("------------------------Ei sallittu valinta, yritä uudelleen.\n");
            accountSettings(student);
        }

        studentView(student);
    }
    private void courseView(Student student) {
        System.out.println("\n");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Kurssi näkymä\n");
        System.out.println("1. Ilmottaudu kurssille");
        System.out.println("2. Poista ilmottautuminen kurssilta");
        System.out.println("3. Tarkastele kursseja, jonne olet ilmottautunut");
        System.out.println("4. Palaa takaisin\n");
        System.out.print("Anna valintasi: \n");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\n");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.println("\n");
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("Kurssit\n");
            System.out.println("1. Java");
            System.out.println("2. Javascript");
            System.out.println("3. HTML");
            System.out.println("4. CSM");
            System.out.println("5. Palaa takaisin\n");
            System.out.print("Anna valintasi: \n");
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("\n");
            int courseChoice = sc.nextInt();
            sc.nextLine();

            switch (courseChoice) {
                case 1:
                    registerForCourse(student, "Java");
                    break;
                case 2:
                    registerForCourse(student, "Javascript");
                    break;
                case 3:
                    registerForCourse(student, "HTML");
                    break;
                case 4:
                    registerForCourse(student, "CSM");
                break;
                case 5:
                    courseView(student);
                break;
                default:
                    System.out.println("\n");
                    System.out.println("ERROR:");
                    System.out.println("------------------------Ei sallittu valinta, yritä uudelleen.\n");
                    courseView(student);
                break;
                }
            } else if (choice == 2) {
                removeCourse(student);
            } else if (choice == 3) {
                viewCourses(student);
            } else if (choice == 4) {
                studentView(student);
            }
            else {                    
                System.out.println("\n");
                System.out.println("ERROR:");
                System.out.println("------------------------Ei sallittu valinta, yritä uudelleen.\n");
                courseView(student);
            }
    }

    private void registerForCourse(Student student, String course) {
        if (student.getCourses().contains(course)) {
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("------------------------Olet jo ilmottautunut tälle kurssille.\n");
            courseView(student);
        } else {
            student.getCourses().add(course);
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("------------------------Onnistuneesti ilmottauduttu " + course + " Kurssille.\n");
            courseView(student);
        }
    }

    private void removeCourse(Student student) {
        System.out.println("\n");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Kurssit\n");
        for (int i = 0; i < student.getCourses().size(); i++) {
            System.out.println((i + 1) + ". " + student.getCourses().get(i));
        }
        System.out.print("5. Palaa takaisin \n");
        System.out.print("Anna kurssi numero, jolta haluat poistaa ilmottautumisen: \n");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\n");
        int choice = sc.nextInt();
        sc.nextLine();
    
        if (choice > 0 && choice <= student.getCourses().size()) {
            String course = student.getCourses().get(choice - 1);
            student.getCourses().remove(course);
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("------------------------Ilmottautuminen onnistuneesti poistettu " + course + " kurssi.\n");
            courseView(student);
        } else if (choice == 5) {
            courseView(student);
        }
        else {
            System.out.println("\n");
            System.out.println("ERROR:");
            System.out.println("------------------------Ei sallittu valinta, takaisin Kurssinäkymään\n");
            courseView(student);
        }
    }

    private void viewCourses(Student student) {
        System.out.println("\n");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Kurssit minne olet ilmottautunut: \n");
        for (int i = 0; i < student.getCourses().size(); i++) {
            System.out.println((i + 1) + ". " + student.getCourses().get(i));
        }
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\n");
        courseView(student);
    }
}

public class App{
    public static void main(String[] args) throws Exception {
        Application app = new Application();
        app.start();
    }
}
