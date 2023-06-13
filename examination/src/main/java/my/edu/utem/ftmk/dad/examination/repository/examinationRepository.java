package my.edu.utem.ftmk.dad.examination.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.edu.utem.ftmk.dad.examination.model.examination;

public interface examinationRepository extends JpaRepository<examination, Long> {

}
