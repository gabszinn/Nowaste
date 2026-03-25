package A3.project.noWaste.service;

import A3.project.noWaste.domain.Product;
import A3.project.noWaste.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    Product findById(Integer id);

    List<Product> findAllByInventory(Integer inventoryId);

    Product create(Integer inventoryId, ProductDTO obj);

    Product update(Integer id, ProductDTO obj);

    void delete(Integer id);
}
