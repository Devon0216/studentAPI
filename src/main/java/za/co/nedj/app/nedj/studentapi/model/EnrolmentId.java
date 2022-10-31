package za.co.nedj.app.nedj.studentapi.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

public class EnrolmentId implements Serializable {
    @Column(name = "student_id")
    private long studentId;

    @Column(name = "course_id")
    private long courseId;
}
