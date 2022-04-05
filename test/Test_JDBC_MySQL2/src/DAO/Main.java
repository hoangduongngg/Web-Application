package DAO;

import entity.Account;
import java.util.List;

/**
 *
 * @author hoangduongngg
 */
public class Main {
    public static void main(String[] args) {
        AccountDAO accountDAO = new AccountDAO();
        List<Account> listAccounts = accountDAO.getListAccount();
        
        for (Account a:listAccounts) {
            System.out.println(a.getUsername() + " " + a.getPassword());
        }
//        System.out.println("Hello");
    }
}
