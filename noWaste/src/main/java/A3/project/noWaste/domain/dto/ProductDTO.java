package A3.project.noWaste.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Integer Id;
    private String name;
    private String brand;
    private String category;
}
