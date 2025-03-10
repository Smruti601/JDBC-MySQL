import java.sql.*;
public class insertStudents {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/spark";
        String username = "root";
        String password = "root";

        String query = "select * from students ;";
        String insertQuery = "insert into students (name,age,course) values(?,?,?);";
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            PreparedStatement pr = con.prepareStatement(insertQuery);

            pr.setString(1,"Raj");
            pr.setInt(2,18);
            pr.setString(3,"BCA");
            pr.executeUpdate();

            pr.setString(1,"Vinaya");
            pr.setInt(2,23);
            pr.setString(3,"ITM");
            pr.executeUpdate();

            System.out.println("Data inserted successfully!");

            System.out.println("ID  |   NAME    |   AGE |   COURSE  ");
            System.out.println("-------------------------------------");
            while(rs.next())
            {
                System.out.println( rs.getInt("id") + "       " +
                        rs.getString("name") + "        " +
                        rs.getInt("age") + "       " +
                        rs.getString("course") + "      "
                );
            }


        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}