package com.skillmentor.root.repository;

import com.skillmentor.root.entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<SessionEntity, Integer> {

    @Query(value = "SELECT m.mentor_id AS mentorId, CONCAT(m.first_name, ' ', m.last_name) AS mentorName, SUM(m.session_fee) AS totalFee \n" +
            "FROM session s  JOIN mentor m \n" +
            "ON s.mentor_id = m.mentor_id  \n" +
            "WHERE s.start_time BETWEEN :startTime AND :endTime  \n" +
            "GROUP BY m.mentor_id;", nativeQuery = true)
    List<Object> findMentorPayments(@Param("startTime") String startTime, @Param("endTime") String endTime);
}
