import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Orders extends DbConnection{
    Orders() throws SQLException {
    }
    public void selectItems(int C_id,String date) throws SQLException {
        Products p=new Products();
        p.displayProducts();
        System.out.println("select the product first and then enter the count: ");
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=1;
        String pname=null;
        int count=0;
        while(n==1){
            System.out.println("enter the Product Id: ");
            int pr=o.nextInt();
            String sql="Select * from Products where  product_id=?;";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,pr);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                pname=rs.getString(2);

            }
            System.out.println("Enter the count of "+pname+" :");
             count=o.nextInt();
             if(hm.containsKey(pr)){
                 hm.put(pr,hm.get(pr)+count);
             }
             else
            hm.put(pr,count);
            System.out.println("to select another product press 1 else press 0");
            n=o.nextInt();
        }
        System.out.println("your order is:");
        System.out.println("+----------------------+----------+----------+");
        System.out.printf("| %-20s | %-8s | %-8s |\n", "Product", "Count","price");
        System.out.println("+----------------------+----------+----------+");
        int total=0;
        for(Map.Entry<Integer,Integer> mi:hm.entrySet() ){
            String s1="select * from Products where product_id=?;";
            PreparedStatement pst=con.prepareStatement(s1);
            pst.setInt(1,mi.getKey());
            ResultSet rs=pst.executeQuery();
            int value=0;
            if(rs.next()){
                pname=rs.getString(2);
                value=rs.getInt(3);
            }
            System.out.printf("| %-20s | %-8d | %-8d |\n",pname,mi.getValue(),mi.getValue()*value);
            total+=mi.getValue()*value;

        }
        System.out.print("+----------------------+----------+----------+\n");
        System.out.printf("| %-31s | %-8d |\n","Total",total);
        System.out.println("+----------------------+----------+----------+\n");
        System.out.println("to conform this press 1 else 0: ");
        n=o.nextInt();
        if(n==1){
            order_Conformation(C_id,date,total,hm);


        }





    }
    public void order_Conformation(int C_id,String date,double total,HashMap<Integer,Integer> hm) throws SQLException {
        String sql="insert into Orders(customer_id,order_date,total_amount) values(?,?,?);";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setInt(1,C_id);
        pst.setString(2,date);
        pst.setDouble(3,total);
        pst.executeUpdate();
        sql="select * from Orders where customer_id=? and order_date=? and total_amount=?;";
        pst=con.prepareStatement(sql);
        pst.setInt(1,C_id);
        pst.setString(2,date);
        pst.setDouble(3,total);
        ResultSet rs=pst.executeQuery();
        int O_id=0;
        if(rs.next()) O_id=rs.getInt(1);
        orderList(O_id,hm);
    }
    public void orderList(int O_id,HashMap<Integer,Integer> hm) throws SQLException {
        int t=0;
        for(Map.Entry<Integer,Integer> mi:hm.entrySet()){
            String sql="insert into Order_Items(order_id,product_id,quantity,price,subtotal) values(?,?,?,?,?);";
            PreparedStatement pst= con.prepareStatement(sql);
            pst.setInt(1,O_id);
            pst.setInt(2,mi.getKey());
            pst.setInt(3,mi.getValue());
            String s1="select * from Products where product_id=?;";
            PreparedStatement pst2= con.prepareStatement(s1);
            pst2.setInt(1,mi.getKey());
            double p=0;
            ResultSet rs=pst2.executeQuery();
            if(rs.next()) p=rs.getDouble(3);
            pst.setDouble(4,p);
            pst.setDouble(5,p*mi.getValue());
           if(pst.executeUpdate()==1) t=1;
        }
        if (t==1) System.out.println("order conformed!");

    }

}
