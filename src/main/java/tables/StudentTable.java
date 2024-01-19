package tables;

import db.MySQLConnector;
import objects.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentTable extends AbsTable {

    public StudentTable() {
        super("student");
        columns = new HashMap<>();
        columns.put("id","int PRIMARY KEY AUTO_INCREMENT");
        columns.put("fio","varchar(100)");
        columns.put("sex","varchar(10)");
        columns.put("id_group","int");
        create();
    }

    public ArrayList<Student> selectAll(){
        String sqlQuery = String.format("SELECT * FROM %s", tableName);
        return selectByQuery(sqlQuery);
    }


    private ArrayList<Student> selectByQuery(String sqlQuery){
        ArrayList<Student> students= new ArrayList<>();
        db = new MySQLConnector();
        ResultSet rs = db.executeRequestWithAnswer(sqlQuery);
        try {
            while (rs.next()) {
                students.add(new Student(
                        rs.getLong("id"),
                        rs.getString("fio"),
                        rs.getString("sex"),
                        rs.getLong("id_group")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return students;
    }

    public void insert(Student student){
        db = new MySQLConnector();
        String sqlQuery = String.format("INSERT INTO %s (fio, sex, id_group)" +
                        " values ('%s', '%s', '%d')",
                tableName, student.getFio(),student.getSex(),student.getId_group());
        db.executeRequest(sqlQuery);
    }

    public long countStudent (){
        db = new MySQLConnector();
        long count=0;
        String sqlQuery = String.format("SELECT COUNT(*) count from %s",
                tableName);
        db.executeRequest(sqlQuery);
        ResultSet rs = db.executeRequestWithAnswer(sqlQuery);
        try {
            while (rs.next()) {
                count = rs.getLong("count");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return count;
    }

    public ArrayList<Student> selectStudentBySex (String sex){
        db = new MySQLConnector();
        ArrayList<Student> students= new ArrayList<>();
        String sqlQuery = String.format("SELECT * from %s where sex = '%s'",
                tableName, sex);
        db.executeRequest(sqlQuery);
        ResultSet rs = db.executeRequestWithAnswer(sqlQuery);
        try {
            // Перебор строк с данными
            while (rs.next()) {
                students.add(new Student(
                        rs.getLong("id"),
                        rs.getString("fio"),
                        rs.getString("sex"),
                        rs.getLong("id_group")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return students;
    }

}
