package com.skillmentor.root.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "classroom")
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_room_id")
    private Integer classRoomId;
    @NotNull(message = "Title must not be null")
    @Column(name = "title", nullable = false)
    private String title;
    @NotNull(message = "Enrolled student count must not be null")
    @Column(name = "enrolled_student_count", nullable = false)
    private Integer enrolledStudentCount;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mentor_id", referencedColumnName = "mentor_id")
    private MentorEntity mentor;
    @OneToMany(mappedBy = "classRoomEntity", fetch = FetchType.EAGER)
    private List<SessionEntity> sessionEntityList = new ArrayList<>();
}
