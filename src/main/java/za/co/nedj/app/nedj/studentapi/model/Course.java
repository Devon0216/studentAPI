package za.co.nedj.app.nedj.studentapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "course")
@Entity
public class Course {
    @Id
    @Generated
    private long id ;
    @Column(name = "name")
    private String name ;
    @Column(name = "department")
    private String department ;

    /**@OneToMany
    private Set<Enrolment> enrolments;
    */

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();
}
