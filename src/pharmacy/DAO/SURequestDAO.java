package pharmacy.DAO;


import pharmacy.Models.RequestToGod;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SURequestDAO extends DAOInterface{

    public SURequestDAO(){
        createConnection();
    }

    @Override
    public List getAll() {
        List list = new ArrayList<RequestToGod>();
        RequestToGod temp;
        try {
            String sql = "SELECT * FROM requeststogod";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                temp = new RequestToGod();
                temp.setId(rs.getInt("id"));
                temp.setPassword(rs.getString("password"));
                temp.setUsername(rs.getString("username"));
                temp.setName(rs.getString("name"));
                temp.setSurname(rs.getString("surname"));
                temp.setNetworkId(rs.getInt("networkid"));
                System.out.println("fetch.: " + temp.getNetworkId() + " " + temp.getSurname());
                list.add(temp);
            }
        }catch (SQLException se) {
            se.printStackTrace();
        }

        return list;
    }
}
