package DAO;

import context.DBContext;
import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoangduongngg
 */
public class AccountDAO {
    Connection conn = null; // ket noi toi SQL Server
    PreparedStatement ps = null; // Nem cau lenh Query tu NetBeans sang SQL Server
    ResultSet rs = null; // Nhan result tra ve
    
    public List<Account> getListAccount() {
        try {
            String query = "SELECT * FROM account";
            conn = new DBContext().getConnection();     // Mo ket noi toi SQL Server
            ps = conn.prepareStatement(query); //Nem cau lenh SQL vao trong SQL Server
            rs = ps.executeQuery(); // Execute query va nhan ket qua tra ve
            List<Account> listAccounts = new ArrayList<>();
            
            while (rs.next()) {
                Account ac = new Account(rs.getString(1), rs.getString(2)); //1: cot dau tien, 2:cot thu 2
                listAccounts.add(ac);   //Add account ac vao list 
            }
            return listAccounts;
            
        } catch (Exception e) {
        }
        return null;
    }
    
}
