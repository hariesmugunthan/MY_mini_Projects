import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Products extends DbConnection {
    private String Name;
    private double Price;

    Products() throws SQLException {
    }
    public int insertProduct() throws SQLException {
        System.out.println("Enter the Product name: ");
        Name=o.nextLine();
        System.out.println("Enter the Price($.$$): ");
        Price=o.nextDouble();
        String sql="insert into Products( product_name,price) values(?,?);";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setString(1,Name);
        pst.setDouble(2,Price);

        if(pst.executeUpdate()==1){
            sql="select *from Products where product_name=? and price=?; ";
            pst = con.prepareStatement(sql);
            pst.setString(1,Name);
            pst.setDouble(2,Price);
            ResultSet Pid=pst.executeQuery();
            Pid.next();

            System.out.println("Product inserted your product ID: ");
            return Pid.getInt("product_id");
        }
        return -1;


    }
    public void displayProducts() throws SQLException {
        String sql="select * from Products ";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(sql);
        System.out.println("+------------+----------------------+----------+");
        System.out.printf("| %-10s | %-20s | %-8s |\n", "ID", "Name", "Price");
        System.out.println("+------------+----------------------+----------+");


        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            double price = rs.getDouble(3);

            System.out.printf("| %-10d | %-20s | %-8.2f |\n", id, name, price);

        }
        System.out.println("+------------+----------------------+----------+");


    }

}
