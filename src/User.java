import java.util.Arrays;
import java.util.Scanner;

public class User {
    private String name;
    private String lastName;
    private String age;
    private String address;
    private double chek;
    private String login;
    private String password;

    public User() {
    }

    public User(String name, String lastName, String age, String address, double chek, String login, String password) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.chek = chek;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getChek() {
        return chek;
    }

    public void setChek(double chek) {
        this.chek = chek;
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

    public static User register(User user) {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        boolean loginFalse = false;

        System.out.print("Имя: ");
        user.setName(sc.nextLine());

        System.out.print("Фамилию: ");
        user.setLastName(sc.nextLine());

        System.out.print("Возраст: ");
        user.setAge(sc.nextLine());

        System.out.print("Aдрес: ");
        user.setAddress(sc.nextLine());

        System.out.print("Ваш счет: ");
        user.setChek(sc1.nextDouble());

        while (!loginFalse) {
            System.out.print("Логин: ");
            String login = sc.nextLine();

            System.out.print("Пароль: ");
            String password = sc.nextLine();

            try {
                if (login.contains("@gmail.com") && password.length() == 4) {
                    loginFalse = true;

                    user.setLogin(login);
                    user.setPassword(password);
                } else {
                    throw new Exception("Логин содержает @gmail.com!");
                }
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }

        return user;
    }

    public static User[] addUsers(User[] users, User regUser) {
        User[] newArr = Arrays.copyOf(users, users.length + 1);
        newArr[newArr.length - 1] = regUser;

        return newArr;
    }

    public static User loginUser(User[] users) {
        Scanner sc = new Scanner(System.in);
        boolean loginFalse = false;

        while (!loginFalse) {
            System.out.print("Логин: ");
            String login = sc.nextLine();

            System.out.print("Пароль: ");
            String password = sc.nextLine();

            for (User user : users) {
                try {
                    if (user.getLogin().equals(login) && user.getPassword().equals(password) && login.contains("@gmail.com")) {
                        loginFalse = true;
                        return user;
                    } else {
                        throw new Exception("Логин или пароль не правилный!");
                    }
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "Имя: " + name +
                "Фамилия: " + lastName +
                "Возраст: " + age +
                "Адрес: " + address + "\n";
    }
}
