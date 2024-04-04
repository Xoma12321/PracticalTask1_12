import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Хомяков Даниил Васильевич\nРИБО-05-22\nВариант №1");
        Scanner scan = new Scanner(System.in);
        int function;
        do {
            System.out.println("Выберите функцию:\n1 - Создать и сохранить объект\n2 - Загрузить объект\n3 - Выход из программы");
            function = scan.nextInt();
            scan.nextLine();
            switch (function) {
                case 1:
                    CreteAndSave(scan);
                    break;
                case 2:
                    Load();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова!");
            }
        } while (function != 3);
    }

    public static void CreteAndSave(Scanner scan) {
        System.out.println("Введите название машины: ");
        String name = scan.nextLine();
        System.out.println("Введите год выпуска автомобиля: ");
        int year = scan.nextInt();
        scan.nextLine();
        System.out.println("Введите ГосНомер автомобиля: ");
        String gosnomer = scan.nextLine();
        System.out.println("Есть ли у машины повреждения?(true/false)");
        Boolean carcondition = scan.nextBoolean();
        scan.nextLine();
        System.out.println("Введите цену автомобиля: ");
        int price = scan.nextInt();
        scan.nextLine();
        Car car = new Car(name, year, gosnomer, carcondition, price);
        SaverRunnable sr = new SaverRunnable(car, "C:\\cars.txt");
        Thread th = new Thread(sr);
        th.start();
        try {
            th.join();
        } catch (InterruptedException ex) {

        }
    }

    public static void Load() {
        LoaderRunnable lr = new LoaderRunnable("C:\\cars.txt");
        Thread th = new Thread(lr);
        th.start();
        try {
            th.join();
        } catch (InterruptedException ex) {
        }
    }
}