package my.edu.utem.ftmk.dad.examination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.examination.model.device;

@Repository
public interface DeviceRepository extends JpaRepository<device, Long> {

}
