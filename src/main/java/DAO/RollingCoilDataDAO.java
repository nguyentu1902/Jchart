package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connector.ConnectToSinglestoreDB;
import model.RollingCoilDataModel;

public class RollingCoilDataDAO{
    private ConnectToSinglestoreDB connectToSinglestoreDB;

    public RollingCoilDataDAO(){
        connectToSinglestoreDB = ConnectToSinglestoreDB.getInstance();
    }

    public List<RollingCoilDataModel> getAllRollingCoilData() {
        List<RollingCoilDataModel> lstRollingCoilData = new ArrayList<>();
        try {
            String sql = "SELECT * FROM rolling_coil rc" + 
                                " JOIN rolling_coil_data rcd ON rc.id = rcd.coil_id" +
                                " ORDER BY rcd.seq";
            Statement statement = connectToSinglestoreDB.conn.createStatement();
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

    public List<RollingCoilDataModel> findRollingCoilDataByCoilNo(String coilNo) {
        List<RollingCoilDataModel> lstRollingCoilData = new ArrayList<>();
        try {
            String sql = "SELECT * FROM rolling_coil rc" + 
                            " JOIN rolling_coil_data rcd ON rc.id = rcd.coil_id" +
                            " WHERE rc.coil_no LIKE (?)" +
                            " ORDER BY rcd.seq";
            PreparedStatement statement = connectToSinglestoreDB.conn.prepareStatement(sql);
            statement.setString(1, "%" + coilNo + "%");
            ResultSet rs = statement.executeQuery();
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
            System.out.println(e);
        }
        return lstRollingCoilData;
    }

}
