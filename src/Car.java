import java.util.Arrays;
import java.util.Scanner;
public class Car {
    private int id;
    private String marka;
    private double price;
    private Driver driver;
    private boolean reservation;

    public  Car(){}
    public Car(int id, String marka, double price, Driver driver) {
        this.id = id;
        this.marka = marka;
        this.price = price;
        this.driver = driver;
        this.reservation = false;
    }

    public boolean getReservation() {
        return reservation;
    }

    public void setRezervation(boolean rezervation) {
        this.reservation = rezervation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void reservationCar(Car car, User currentUser) {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);

        if (!car.getReservation()) {
            if (currentUser.getChek() >= car.getPrice()) {
                car.setRezervation(true);
                currentUser.setChek(currentUser.getChek() - car.getPrice());
                System.out.println("Машина успешно забронирована: " + car.getMarka());
                System.out.println("Ваш счет: " + currentUser.getChek());
            } else {
                System.out.println("У вас не хватает денег!");
                System.out.println("Ваш счет: $" + currentUser.getChek());

                System.out.print("""
                        Вы берете кредить?
                        1. Да✔   2. Нет❌
                                                
                        """);
                System.out.print("Выбор: \n");
                switch (sc.nextLine()) {
                    case "1" -> {
                        System.out.print("Введите сумму: ");
                        double money = sc.nextDouble();
                        sc.nextLine();

                        bank.credit(currentUser, money);
                    }
                    case "2" -> {
                        System.out.println("ok");
                    }
                }
            }
        } else {
            System.out.println("Машина уже забронирована");
        }
    }

    @Override
    public String toString() {
        return "Марка: " + marka +
                " Цена: " + price +
                "  Водитель: " + driver + "\n"
                ;
    }
}
