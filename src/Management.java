import java.util.Scanner;

import java.util.Arrays;

public class Management {
    private String name;
    private String lastName;
    private String login;
    private String password;


    public Management() {
    }

    public Management(String name, String lastName, String login, String password) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Management regManager(Management manager) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Имя: ");
        manager.setName(sc.nextLine());

        System.out.print("Фамилия: ");
        manager.setLastName(sc.nextLine());

        System.out.print("Логин: ");
        manager.setLogin(sc.nextLine());

        System.out.print("Пароль: ");
        manager.setPassword(sc.nextLine());

        return manager;
    }

    public static Management[] addMangers(Management[] managers, Management regManager) {
        Management[] newArrManagers = Arrays.copyOf(managers, managers.length + 1);
        newArrManagers[newArrManagers.length - 1] = regManager;

        return newArrManagers;
    }

    public static Management logManager(Management[] managers) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Логин: ");
        String login = sc.nextLine();

        System.out.print("Пароль: ");
        String password = sc.nextLine();

        for (Management manager : managers) {
            if (manager.getLogin().equals(login) && manager.getPassword().equals(password)) {
                return manager;
            }
        }
        return null;

    }

    public static void getAllUsers(User[] users) {
        System.out.println(Arrays.toString(users));
    }

    public static void getAllCars(Car[] cars) {
        System.out.println(Arrays.toString(cars));

    }

    public void clients(){}

    @Override
    public String toString() {
        return "Management{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
