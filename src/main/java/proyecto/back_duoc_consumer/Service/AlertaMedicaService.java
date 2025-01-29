package proyecto.back_duoc_consumer.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyecto.back_duoc_consumer.Model.AlertaMedica;
import proyecto.back_duoc_consumer.Model.AlertaGrave;
import proyecto.back_duoc_consumer.Repository.AlertaMedicaRepository;
import proyecto.back_duoc_consumer.Repository.AlertaGraveRepository;

@Service
public class AlertaMedicaService {

    private final AlertaMedicaRepository alertaMedicaRepository;
    private final AlertaGraveRepository alertaGraveRepository;

    public AlertaMedicaService(AlertaMedicaRepository alertaMedicaRepository, AlertaGraveRepository alertaGraveRepository) {
        this.alertaMedicaRepository = alertaMedicaRepository;
        this.alertaGraveRepository = alertaGraveRepository;
    }

    @Transactional
    public void guardarAlerta(AlertaMedica alerta) {
        // Guardamos la alerta en alertas_medicas
        alertaMedicaRepository.save(alerta);

        // Si la alerta es grave, también la guardamos en alertas_graves
        if ("Alta".equalsIgnoreCase(alerta.getNivelAlerta())) {
            AlertaGrave alertaGrave = new AlertaGrave();
            alertaGrave.setNombrePaciente(alerta.getNombrePaciente());
            alertaGrave.setTipoAlerta(alerta.getTipoAlerta());
            alertaGrave.setFechaAlerta(alerta.getFechaAlerta());
            alertaGraveRepository.save(alertaGrave);
        }
    }
}
