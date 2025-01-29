package proyecto.back_duoc_consumer.Listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import proyecto.back_duoc_consumer.Model.AlertaMedica;
import proyecto.back_duoc_consumer.Service.AlertaMedicaService;

@Component
public class RabbitMQListener {

    private final AlertaMedicaService alertaMedicaService;

    public RabbitMQListener(AlertaMedicaService alertaMedicaService) {
        this.alertaMedicaService = alertaMedicaService;
    }

    @RabbitListener(queues = "queues_alertasmedicas")
    public void recibirAlertaGeneral(AlertaMedica alerta) {
        System.out.println("📩 Recibida alerta general: " + alerta);
        alertaMedicaService.guardarAlerta(alerta);
    }

    @RabbitListener(queues = "queues_alertasgraves")
    public void recibirAlertaGrave(AlertaMedica alerta) {
        System.out.println("🚨 Recibida alerta grave: " + alerta);
        alertaMedicaService.guardarAlerta(alerta);
    }
}