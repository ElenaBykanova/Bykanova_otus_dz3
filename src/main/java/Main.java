import db.MySQLConnector;
import objects.*;
import tables.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        try {

            StudentTable studentTable = new StudentTable();
            GroupTable groupeTable = new GroupTable();
            CuratorTable curatorTable = new CuratorTable();

            ArrayList<Student> students = studentTable.selectAll();

            if (students.size() < 15) {
                studentTable.insert(new Student("Иванов Петр Петрович", "муж", 1));
                studentTable.insert(new Student("Иващенко Ирина Петровна", "жен", 1));
                studentTable.insert(new Student("Иванько Ирина Петровна", "жен", 1));
                studentTable.insert(new Student("Ищенко Гомер Валентинович", "муж", 1));
                studentTable.insert(new Student("Игнатьев Василий Васильевич", "муж", 1));
                studentTable.insert(new Student("Свиридов Петр Петрович", "муж", 2));
                studentTable.insert(new Student("Смирнова Ирина Петровна", "жен", 2));
                studentTable.insert(new Student("Синько Ирина Петровна", "жен", 2));
                studentTable.insert(new Student("Сыщенко Гомер Валентинович", "муж", 2));
                studentTable.insert(new Student("Сирота Василий Васильевич", "муж", 2));
                studentTable.insert(new Student("Петров Петр Петрович", "муж", 3));
                studentTable.insert(new Student("Петрова Ирина Петровна", "жен", 3));
                studentTable.insert(new Student("Питько Ирина Петровна", "жен", 3));
                studentTable.insert(new Student("Пыщенко Гомер Валентинович", "муж", 3));
                studentTable.insert(new Student("Пирогов Василий Васильевич", "муж", 3));
            }

            System.out.println("Содержимое таблицы student:");
            students = studentTable.selectAll();
            for (Student tmp : students) {
                System.out.println(tmp.toString());
            }
            System.out.println();


            ArrayList<Group> groups = groupeTable.selectAll();
            if (groups.size() < 3) {
                groupeTable.insert(new Group("JAVA для чайников", 1));
                groupeTable.insert(new Group("JAVA для мидлов", 2));
                groupeTable.insert(new Group("JAVA professional", 3));
            }

            System.out.println("Содержимое таблицы group:");
            groups = groupeTable.selectAll();
            for (Group tmp : groups) {
                System.out.println(tmp.toString());
            }
            System.out.println();

            ArrayList<Curator> curators = curatorTable.selectAll();
            if (curators.size() < 4) {
                curatorTable.insert(new Curator("Звонова Тамара Павловна"));
                curatorTable.insert(new Curator("Васильев Петр Иванович"));
                curatorTable.insert(new Curator("Ступина Ирина Петровна"));
                curatorTable.insert(new Curator("Лебедев Роман Павлович"));
            }

            System.out.println("Содержимое таблицы curator:");
            curators = curatorTable.selectAll();
            for (Curator tmp : curators) {
                System.out.println(tmp.toString());
            }
            System.out.println();

            System.out.println("Количество студентов: " + studentTable.countStudent());
            System.out.println();

            System.out.println("Все студентки в группе:");
            students = studentTable.selectStudentBySex("жен");
            for (Student tmp : students) {
                System.out.println(tmp.toString());
            }
            System.out.println();

            System.out.println("Тут поменяли куратора в группе:");
            groupeTable.update(groups.get(0), 4);

            groups = groupeTable.selectAll();
            for (Group tmp : groups) {
                System.out.println(tmp.toString());
            }
            System.out.println();


            studentTable.selectStudentWithGroupAndCurator();
            groupeTable.selectGroupAndCurator();
            studentTable.selectStudentFromGroup();

    }

        finally {
            MySQLConnector.close();
        }
    }


}
