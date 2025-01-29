package proyecto.back_duoc_consumer.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "alertas_graves")
@Data
public class AlertaGrave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlerta;

    @Column(nullable = false)
    private String nombrePaciente;

    @Column(nullable = false)
    private String tipoAlerta;

    @Column(nullable = false)
    private String nivelAlerta = "Alta"; // Este valor siempre será "Alta"

    @Column(nullable = false)
    private LocalDateTime fechaAlerta = LocalDateTime.now();
}
