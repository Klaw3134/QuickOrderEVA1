package cl.QuickOrder.EVA.modelo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
public class QuickOrder {
    private int id;
    private String nombreCliente;
    private String fechaPedido;
    private String estadoPedido;
    private int montoTotal;


}
