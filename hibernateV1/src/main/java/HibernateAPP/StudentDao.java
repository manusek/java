package HibernateAPP;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDao {
    private static StudentDao studentDao;

    public static StudentDao getInstance(){
        if (studentDao == null){
            studentDao = new StudentDao();
        }
        return studentDao;
    }
    public void addStudent(Student student) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //start transaction
            transaction = session.beginTransaction();

            //save new student object
            session.save(student);

            //commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        Transaction transaction = null;
        Student student = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //start transaction
            transaction = session.beginTransaction();

            student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
            } else System.out.println("Nie istnieje student o podanym ID");

            //commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        Transaction transaction = null;
        List<Student> list = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            list = session.createQuery("from Student").list();

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return list;
    }

    public Student getStudentById(int id) {
        Transaction transaction = null;
        Student student = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            student = session.get(Student.class, id);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return student;
    }

    public void editRecord(int recordId, Student studentEdit) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Rozpocznij transakcję
            transaction = session.beginTransaction();

            // Pobierz istniejący rekord do edycji
            Student student = session.get(Student.class, recordId);

            if (student != null) {
                // Edytuj pole rekordu
                student.setName(studentEdit.getName());
                student.setSecondName(studentEdit.getSecondName());
                student.setAlbumNumber(studentEdit.getAlbumNumber());

                // Zapisz zmiany
                session.update(student);
                transaction.commit();
                System.out.println("Rekord zaktualizowany pomyślnie.");
            } else {
                System.out.println("Rekord o podanym ID nie istnieje.");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
