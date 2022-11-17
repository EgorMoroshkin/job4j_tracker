package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковской системы
 *
 * @author Egor Moroshkin
 * @version 1.0
 */

public class BankService {
    /**
     * Создаем коллекцию типа Map для добавления пользователей
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляем пользователй в коллекцию
     *
     * @param user который добавляется в коллекцию
     */

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод удаления пользователя из коллекции
     *
     * @param user который удаляется из коллеции
     */

    public void deleteUser(User user) {
        if (users.containsKey(user)) {
            users.remove(user);
        }
    }

    /**
     * Добавляем счет пользователю
     *
     * @param passport ФИО пользователя которому добавляется счет
     * @param account  счет который добавляем пользователю
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя в коллеции  по паспорту
     *
     * @param passport по которому происходит поиск
     * @return возвращаем пользователя который соответствует паспорту
     */

    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(x -> x.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод в котором ищем пользоваетля по реквизитам
     *
     * @param passport  паспорт пользователя для поиска счета
     * @param requisite реквизиты пользователя для поиска счета
     * @return возвращаем счет который соответствует паспорту и реквизитам
     */

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(x -> x.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод в котором осуществляем перевод средств между счетами
     *
     * @param srcPassport   паспорт пользователя со счета которого происходит перевод
     * @param srcRequisite  реквизиты пользователя со счета которого происходит перевод
     * @param destPassport  паспорт пользователя на счет которого поступает перевод
     * @param destRequisite реквизиты пользователя на счет которого происходит перевод
     * @param amount        сумма перевода
     * @return возвращаем значение успеха при переводе
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && srcAccount.getBalance() >= amount && destAccount != null) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод возвращает коллекцию счетов пользователя
     *
     * @param user пользовател по которому просисходит поиск коллекции счетов
     * @return возврашем коллекцию счетов пользователя
     */

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}