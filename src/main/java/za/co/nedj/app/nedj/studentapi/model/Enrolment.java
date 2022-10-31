package za.co.nedj.app.nedj.studentapi.model;

import lombok.*;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "enrolment")
@Entity
@IdClass(EnrolmentId.class)
public class Enrolment {
    /**
    @Id
    @Generated
    private long id ;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    */
    @Id
    private long studentId;
    @Id
    private long courseId;

    @ManyToOne
    @PrimaryKeyJoinColumn(name="student_id", referencedColumnName="id")
    private Student student;

    @ManyToOne
    @PrimaryKeyJoinColumn(name="course_id", referencedColumnName="id")
    private Course course;

    /**@ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;
    */

}
