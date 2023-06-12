package my.edu.utem.ftmk.dad.examination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.examination.model.student;

@Repository
public interface studentRepository extends JpaRepository<student, Long> {

}
