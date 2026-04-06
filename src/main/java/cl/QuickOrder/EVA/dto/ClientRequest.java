package cl.QuickOrder.EVA.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Data
public class ClientRequest {

    @PositiveOrZero(message = "No puede ser negativo")
    private int id;
    
    @NotBlank(message = "No puede estar vacio")
    private String nombreCliente;
    
    @NotBlank(message = "No puede estar vacio")
    private String fechaPedido;
    
    @NotBlank(message = "No puede ser vacio")
    private String estadoPedido;
    
    @PositiveOrZero(message = "No puede ser negativo")
    private int montoTotal;


}