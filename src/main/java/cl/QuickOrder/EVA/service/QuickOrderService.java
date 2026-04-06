package cl.QuickOrder.EVA.service;
import cl.QuickOrder.EVA.modelo.QuickOrder;
import cl.QuickOrder.EVA.repositorio.QuickOrderRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuickOrderService {
     @Autowired
    private QuickOrderRepositorio pedidoRepositorio;
    public List<QuickOrder> getPedidos(){
        return pedidoRepositorio.obtenerPedidos();

    }

    public QuickOrder savePedido(QuickOrder pedido){
        return pedidoRepositorio.guardar(pedido);

    }

    public QuickOrder getPedidoId(int id){
        return pedidoRepositorio.buscarPorId(id);
    }

    public QuickOrder updatePedido(QuickOrder pedido){
        return pedidoRepositorio.actualizar(pedido);
    }
    public String deletePedido(int id){
        pedidoRepositorio.eliminar(id);
        return "Pedido elimminado";
    }


}
