package proyecto.back_duoc_consumer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.back_duoc_consumer.Model.AlertaMedica;
import java.util.List;

public interface AlertaMedicaRepository extends JpaRepository<AlertaMedica, Long> {

     // Método para obtener alertas graves
     List<AlertaMedica> findByNivelAlerta(String nivelAlerta);
}