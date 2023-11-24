public class Bank {
    public double bank = 1000000000;

    public double getBank() {
        return bank;
    }

    public void credit(User currentUser, double money){
        if (money <= bank) {
            bank -= money;
            currentUser.setChek(currentUser.getChek() + money);
            System.out.println("Вы успешно получили кредит!");
            System.out.println("Ваш счет: $" + currentUser.getChek());
        } else if (money < 0) {
            System.out.println("Не правильная сумма!");
        } else {
            System.out.println("В банке нету такой суммы!");
        }
    }
}
