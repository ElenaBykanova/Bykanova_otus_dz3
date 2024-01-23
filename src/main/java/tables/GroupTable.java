package tables;

import db.MySQLConnector;
import objects.Group;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class GroupTable extends AbsTable {

    public GroupTable() {
        super("grouptable");
        columns = new HashMap<>();
        columns.put("id","int PRIMARY KEY AUTO_INCREMENT");
        columns.put("name","varchar(100)");
        columns.put("id_curator","int");
        create();
    }

    public ArrayList<Group> selectAll(){
        String sqlQuery = String.format("SELECT * FROM %s", tableName);
        return selectByQuery(sqlQuery);
    }


    private ArrayList<Group> selectByQuery(String sqlQuery){
        ArrayList<Group> groups= new ArrayList<>();
        db = new MySQLConnector();
        ResultSet rs = db.executeRequestWithAnswer(sqlQuery);
        try {
            while (rs.next()) {
                groups.add(new Group(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getLong("id_curator")
                       )
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return groups;
    }

    public void insert(Group group){
        db = new MySQLConnector();
        String sqlQuery = String.format("INSERT INTO %s (name, id_curator) values ('%s', '%d')",
                tableName, group.getName(),group.getId_curator());
        db.executeRequest(sqlQuery);
    }

    public void update(Group group, int idCurator){
        db = new MySQLConnector();
        String sqlQuery = String.format("UPDATE %s " +
                        "SET id_curator='%d' " +
                        "WHERE id_curator = '%d'",
                tableName,
                idCurator,
                group.getId_curator()

        );
        db.executeRequest(sqlQuery);
    }

    public void selectGroupAndCurator() {
        String sqlQuery = "select g.name, c.fio  from grouptable g\n" +
                "join curator c on g.id_curator = c.id;";
        System.out.println("Cписок групп с их кураторами:");
        doThisSqlQuery(sqlQuery);
    }

}
