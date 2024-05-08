package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connector.ConnectToSinglestoreDB;
import model.RollingCoilDataModel;

public class RollingCoilDataDAO extends ConnectToSinglestoreDB {

    public List<RollingCoilDataModel> getAllRollingCoilData() {
        List<RollingCoilDataModel> lstRollingCoilData = new ArrayList<>();
        try {
            String sql = "SELECT * from rolling_coil rc\r\n" + //
                    "join rolling_coil_data rcd \r\n" + //
                    "on rc.id = rcd.coil_id";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                RollingCoilDataModel rldm = new RollingCoilDataModel();
                rldm.setCoilNo(rs.getString("coil_no"));
                rldm.setCoilId(rs.getInt("coil_id"));
                rldm.setTime(rs.getString("time"));
                rldm.setSeq(rs.getString("seq"));
                rldm.setTemperature(rs.getInt("temperature"));
                rldm.setThickness(rs.getInt("thickness"));
                lstRollingCoilData.add(rldm);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return lstRollingCoilData;
    }


    public List<RollingCoilDataModel> findByCoilNo(String coilNo) {
        List<RollingCoilDataModel> lstRollingCoilData = new ArrayList<>();
        try {
            // String sql = "SELECT  * from coil_data WHERE coil_no IS NULL OR coil_no LIKE ?";
            // PreparedStatement statement = conn.prepareStatement(sql);
            // statement.setString(1, "%" + coilNo + "%");
            String sql = "SELECT * from rolling_coil rc join rolling_coil_data rcd on rc.id = rcd.coil_id WHERE rc.coil_no LIKE ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + coilNo + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                RollingCoilDataModel rldm = new RollingCoilDataModel();
                rldm.setCoilNo(rs.getString("coil_no"));
                rldm.setCoilId(rs.getInt("coil_id"));
                rldm.setTime(rs.getString("time"));
                rldm.setSeq(rs.getString("seq"));
                rldm.setTemperature(rs.getInt("temperature"));
                rldm.setTemperature(rs.getInt("thickness"));
                lstRollingCoilData.add(rldm);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lstRollingCoilData;
    }

}
