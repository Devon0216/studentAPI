package za.co.nedj.app.nedj.studentapi.service;

import za.co.nedj.app.nedj.studentapi.model.Course;
import za.co.nedj.app.nedj.studentapi.model.Enrolment;
import za.co.nedj.app.nedj.studentapi.model.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class DataService {
    @PersistenceContext(name = "nfpePU")
    private EntityManager entityManager;


    private static final String STUDENT_GETALL_QUERY = "SELECT p FROM Student p";
    private static final String STUDENT_GET_QUERY = "SELECT p FROM Student p WHERE p.id = :id";
    private static final String STUDENT_DELETE_QUERY = "DELETE FROM Student p WHERE p.id =:id";

    private static final String COURSE_GETALL_QUERY = "SELECT p FROM Course p";
    private static final String COURSE_GET_QUERY = "SELECT p FROM Course p WHERE p.id = :id";
    private static final String COURSE_DELETE_QUERY = "DELETE FROM Course p WHERE p.id =:id";

    private static final String ENROLMENT_GETALL_QUERY = "SELECT p FROM Enrolment p";
    private static final String ENROLMENT_GET_QUERY = "SELECT p FROM Enrolment p WHERE p.id = :id";
    private static final String ENROLMENT_DELETE_QUERY = "DELETE FROM Enrolment p WHERE p.id =:id";


    /**
     * student api operations
     */
    public Student getStudent(Long studentId){
        TypedQuery<Student> getStudentTypeQuery = entityManager.createQuery(STUDENT_GET_QUERY, Student.class);
        getStudentTypeQuery.setParameter("id", studentId);
        return getStudentTypeQuery.getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }

    public List<Student> getAllStudents(){
        TypedQuery<Student> getAllStudentsTypeQuery = entityManager.createQuery(STUDENT_GETALL_QUERY, Student.class);
        return getAllStudentsTypeQuery.getResultList();

    }

    public Student insertStudent(Student student){
        entityManager.persist(student);
        return student;
    }

    public Student updateStudent(Student student){
        return entityManager.merge(student);
    }

    public int deleteStudent(Long studentId){
        TypedQuery<Student> deleteStudentTypeQuery = entityManager.createQuery(STUDENT_DELETE_QUERY, Student.class);
        deleteStudentTypeQuery.setParameter("id", studentId);
        int deletedCount = deleteStudentTypeQuery.executeUpdate();
        return deletedCount;
    }

    /**
     * course api operations
     */
    public Course getCourse(Long courseId){
        TypedQuery<Course> getCourseTypeQuery = entityManager.createQuery(COURSE_GET_QUERY, Course.class);
        getCourseTypeQuery.setParameter("id", courseId);
        return getCourseTypeQuery.getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }

    public List<Course> getAllCourses(){
        TypedQuery<Course> getAllCoursesTypeQuery = entityManager.createQuery(COURSE_GETALL_QUERY, Course.class);
        return getAllCoursesTypeQuery.getResultList();

    }

    public Course insertCourse(Course course){
        entityManager.persist(course);
        return course;
    }

    public Course updateCourse(Course course){
        return entityManager.merge(course);
    }

    public int deleteCourse(Long courseId){
        TypedQuery<Course> deleteCourseTypeQuery = entityManager.createQuery(COURSE_DELETE_QUERY, Course.class);
        deleteCourseTypeQuery.setParameter("id", courseId);
        int deletedCount = deleteCourseTypeQuery.executeUpdate();
        return deletedCount;
    }

    /**
     * enrolment api operations
     */
    public Enrolment getEnrolment(Long enrolmentId){
        TypedQuery<Enrolment> getEnrolmentTypeQuery = entityManager.createQuery(ENROLMENT_GET_QUERY , Enrolment.class);
        getEnrolmentTypeQuery.setParameter("id", enrolmentId);
        return getEnrolmentTypeQuery.getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }

    public List<Enrolment> getAllEnrolments(){
        TypedQuery<Enrolment> getAllEnrolmentsTypeQuery = entityManager.createQuery(ENROLMENT_GETALL_QUERY, Enrolment.class);
        return getAllEnrolmentsTypeQuery.getResultList();

    }

    public Enrolment insertEnrolment(Enrolment enrolment){
        entityManager.persist(enrolment);
        return enrolment;
    }

    public Enrolment updateEnrolment(Enrolment enrolment){
        return entityManager.merge(enrolment);
    }

    public int deleteEnrolment(Long enrolmentId){
        TypedQuery<Enrolment> deleteEnrolmentTypeQuery = entityManager.createQuery(ENROLMENT_DELETE_QUERY, Enrolment.class);
        deleteEnrolmentTypeQuery.setParameter("id", enrolmentId);
        int deletedCount = deleteEnrolmentTypeQuery.executeUpdate();
        return deletedCount;
    }


}
