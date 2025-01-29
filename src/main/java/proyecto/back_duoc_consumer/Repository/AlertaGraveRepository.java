package proyecto.back_duoc_consumer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.back_duoc_consumer.Model.AlertaGrave;

@Repository
public interface AlertaGraveRepository extends JpaRepository<AlertaGrave, Long> {
}
