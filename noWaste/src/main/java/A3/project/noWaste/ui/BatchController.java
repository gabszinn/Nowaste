package A3.project.noWaste.ui;

import A3.project.noWaste.domain.Batch;
import A3.project.noWaste.dto.BatchDTO;
import A3.project.noWaste.service.BatchService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class BatchController {

    private final BatchService service;
    private final ModelMapper mapper;

    public BatchController(BatchService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    // metodo auxiliar
    private BatchDTO toDTO(Batch batch) {
        BatchDTO dto = mapper.map(batch, BatchDTO.class);
        dto.setTotalWeight(batch.getTotalWeight());
        dto.setDaysToExpire(batch.getDaysToExpire());
        dto.setStatus(batch.getStatus());
        return dto;
    }



    // listar todos os lotes
    @GetMapping("/inventories/{inventoryId}/products/{productId}/batches")
    public ResponseEntity<List<BatchDTO>> findAllByProduct(@PathVariable Integer inventoryId,
                                                           @PathVariable Integer productId) {
        List<Batch> list = service.findAllByProduct(inventoryId, productId);

        List<BatchDTO> listDTO = list.stream()
                .map(this::toDTO).collect(Collectors.toList());

        return ResponseEntity.ok(listDTO);
    }

    // lote específico
    @GetMapping("/inventories/{inventoryId}/products/{productId}/batches/{batchId}")
    public ResponseEntity<BatchDTO> findById(@PathVariable Integer inventoryId, @PathVariable Integer productId,
                                             @PathVariable Integer batchId) {
        Batch batch = service.findById(inventoryId, productId, batchId);

        return ResponseEntity.ok(toDTO(batch));
    }

    // criar um lote
    @PostMapping("/inventories/{inventoryId}/products/{productId}/batches")
    public ResponseEntity<BatchDTO> create(@PathVariable Integer inventoryId, @PathVariable Integer productId,
                                           @Valid @RequestBody BatchDTO obj) {
        Batch newBatch = service.create(inventoryId, productId, obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{batchId}")
                .buildAndExpand(newBatch.getId())
                .toUri();

        return ResponseEntity.created(uri).body(toDTO(newBatch));
    }

    // atualizar um lote
    @PutMapping("/inventories/{inventoryId}/products/{productId}/batches/{batchId}")
    public ResponseEntity<BatchDTO> update(@PathVariable Integer inventoryId, @PathVariable Integer productId,
                                           @PathVariable Integer batchId, @Valid @RequestBody BatchDTO obj) {
        Batch batchUpdated = service.update(inventoryId, productId, batchId, obj);

        return ResponseEntity.ok(toDTO(batchUpdated));
    }

    // deletar um lote
    @DeleteMapping("/inventories/{inventoryId}/products/{productId}/batches/{batchId}")
    public ResponseEntity<Void> delete(@PathVariable Integer inventoryId, @PathVariable Integer productId,
                                       @PathVariable Integer batchId) {
        service.delete(inventoryId, productId, batchId);

        return ResponseEntity.noContent().build();
    }

}
