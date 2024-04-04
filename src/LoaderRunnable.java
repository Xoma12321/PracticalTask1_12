import java.io.*;

public class LoaderRunnable implements Runnable {

    private String path;

    public LoaderRunnable(String path) {
        this.path = path;
    }

    @Override
    public void run() {
        FileInputStream fis;
        if (this.path != null && new File(this.path).exists()) {
            try {
                fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Car car = (Car) ois.readObject();  System.out.println("Ошибка. Путь к файлу " + this.path + "\nПроверьте, что Вы запустили программу от имени администратора\n");
                ois.close();
                System.out.println(car.toString());
            } catch (ClassNotFoundException | IOException ex) {
                System.out.println("Ошибка. Путь к файлу " + this.path + "\n");
                System.out.println(ex.getMessage());
            }
        }
    }
}
