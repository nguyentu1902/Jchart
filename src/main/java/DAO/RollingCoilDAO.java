package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connector.ConnectToSinglestoreDB;
import model.RollingCoilModel;

public class RollingCoilDAO extends ConnectToSinglestoreDB {

    public List<RollingCoilModel> getAllRollingCoil() {
        List<RollingCoilModel> lstRollingCoil = new ArrayList<>();
        try {
            String sql = "SELECT * FROM rolling_coil";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                RollingCoilModel rcm = new RollingCoilModel();
                rcm.setId(rs.getInt("id"));
                rcm.setCoilNo(rs.getString("coil_no"));
                rcm.setCoilName(rs.getString("coil_name"));
                lstRollingCoil.add(rcm);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return lstRollingCoil;
    }
}
