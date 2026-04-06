package cl.QuickOrder.EVA.mapper;
import cl.QuickOrder.EVA.dto.ClientRequest;
import cl.QuickOrder.EVA.modelo.QuickOrder;

public class QuickOrderMapper {

    public static QuickOrder toModel(ClientRequest request) {
        return new QuickOrder(
            request.getId(),
            request.getNombreCliente(),
            request.getFechaPedido(),
            request.getEstadoPedido(),
            request.getMontoTotal()
        );
    } 

}
