package cl.QuickOrder.EVA.repositorio;
import cl.QuickOrder.EVA.modelo.QuickOrder;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository

public class QuickOrderRepositorio {
     private List<QuickOrder> listaPedidos= new ArrayList<>();
    
    
    
    public List<QuickOrder> obtenerPedidos(){
        return listaPedidos;
    }

    public QuickOrder buscarPorId(int id){
        for (QuickOrder pedido : listaPedidos){
            if(pedido.getId() == id){
                return pedido;
            }
        }
        return null;
    }

    public QuickOrder buscarPorFechaPedido(String pedido){
        for (QuickOrder pedid : listaPedidos){
            if(pedid.getFechaPedido().equals(pedido)){
                return pedid ;
            }
        }
        return null;
    }

    
    public QuickOrder guardar (QuickOrder pedido){
        listaPedidos.add(pedido);
        return pedido;
    }

    public QuickOrder actualizar(QuickOrder ped){
        int id = 0;
        int idPosicion=0;
        for (int i = 0; i < listaPedidos.size(); i++){
            if (listaPedidos.get(i).getId()== ped.getId()){
                id = ped.getId();
                idPosicion=i;
            }
            
        }

        QuickOrder pedido1 = new QuickOrder();
        pedido1.setId(id);
        pedido1.setNombreCliente(ped.getNombreCliente());
        pedido1.setFechaPedido(ped.getFechaPedido());
        pedido1.setEstadoPedido(ped.getEstadoPedido());
        pedido1.setMontoTotal(ped.getMontoTotal());
    
        listaPedidos.set(idPosicion, pedido1);
        return pedido1;
    }


    public void eliminar(int id){
        QuickOrder pedido = buscarPorId(id);
        if(pedido != null){
            listaPedidos.remove(pedido);
        }


        

        


    }

}
