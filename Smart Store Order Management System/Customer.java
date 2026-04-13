import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Customer extends DbConnection{

    private String MobileNo;
    private String Name;
    Customer() throws SQLException {
    }
    public int createCustomer() throws SQLException {
        System.out.println("Enter your name: ");
        Name=o.nextLine();
        System.out.println("Enter your Mobile Number: ");
        MobileNo=o.next();
        String sql="insert into Customers (name,phone) values(?,?);";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setString(1,Name);
        pst.setString(2,MobileNo);
        if(pst.executeUpdate()==1){
            System.out.println("Registered successfully!");
        sql="select customer_id from Customers where name=? and phone=?;";
         pst=con.prepareStatement(sql);
        pst.setString(1,Name);
        pst.setString(2,MobileNo);
        ResultSet Cid=pst.executeQuery();
        if (Cid.next()) {
            return Cid.getInt("customer_id");
        }}

        return -1;
    }
}
