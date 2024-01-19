package tables;

import db.MySQLConnector;
import objects.Curator;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class CuratorTable extends AbsTable {

    public CuratorTable() {
        super("curator");
        columns = new HashMap<>();
        columns.put("id","int PRIMARY KEY AUTO_INCREMENT");
        columns.put("fio","varchar(100)");
        create();
    }

    public ArrayList<Curator> selectAll(){
        String sqlQuery = String.format("SELECT * FROM %s", tableName);
        return selectByQuery(sqlQuery);
    }

    private ArrayList<Curator> selectByQuery(String sqlQuery){
        ArrayList<Curator> curators= new ArrayList<>();
        db = new MySQLConnector();
        ResultSet rs = db.executeRequestWithAnswer(sqlQuery);
        try {
            while (rs.next()) {
                curators.add(new Curator(
                        rs.getLong("id"),
                        rs.getString("fio")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return curators;
    }

    public void insert(Curator curator){
        db = new MySQLConnector();
        String sqlQuery = String.format("INSERT INTO %s (fio) values ('%s')",
                tableName, curator.getFio());
        db.executeRequest(sqlQuery);
    }

}
