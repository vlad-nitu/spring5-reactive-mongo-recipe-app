package guru.springframework.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by jt on 6/13/17.
 */
@Getter
@Setter
public class Ingredient {

    private String id = UUID.randomUUID().toString();
    private String description;
    private BigDecimal amount;
    private UnitOfMeasure uom;

    public Ingredient() {

    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }

}
