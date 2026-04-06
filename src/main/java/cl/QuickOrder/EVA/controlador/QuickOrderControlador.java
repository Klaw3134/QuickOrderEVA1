package cl.QuickOrder.EVA.controlador;
import cl.QuickOrder.EVA.modelo.QuickOrder;
import cl.QuickOrder.EVA.service.QuickOrderService;
import cl.QuickOrder.EVA.dto.ClientRequest;
import cl.QuickOrder.EVA.mapper.QuickOrderMapper;
import cl.QuickOrder.EVA.exception.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/pedidos")

public class QuickOrderControlador {
    @Autowired
    private QuickOrderService pedidoService;
    
    @GetMapping
    public List<QuickOrder> listarPedidos(){
        return pedidoService.getPedidos();
    }

    @PostMapping
    public ResponseEntity<?> agregarPedido(@Valid @RequestBody ClientRequest request, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error -> 
                errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }

        return ResponseEntity.ok(pedidoService.savePedido(QuickOrderMapper.toModel(request)));
    }

    @GetMapping("{id}")
    public ResponseEntity<QuickOrder> buscarPedido(@PathVariable int id){
        QuickOrder pedido = pedidoService.getPedidoId(id);
        
        if (pedido == null) {
            throw new ResourceNotFoundException("Pedido no encontrado para id: " + id);
        }
        
        return ResponseEntity.ok(pedido);
    }

    @PutMapping ("{id}")
    public QuickOrder actualizaPedido(@PathVariable int id, @RequestBody QuickOrder pedido){
        return pedidoService.updatePedido(pedido);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarPedido(@PathVariable int id){
    QuickOrder pedido = pedidoService.getPedidoId(id);

    if (pedido == null) {
    throw new ResourceNotFoundException("Pedido no encontrado para id: " + id);
    }

    pedidoService.deletePedido(id);
    return ResponseEntity.ok("Pedido eliminado correctamente, id: " + id);
    }

    

}
