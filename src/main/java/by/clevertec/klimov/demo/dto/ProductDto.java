package by.clevertec.klimov.demo.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class ProductDto implements Serializable {
  @Id private long id;
  @CsvBindByName(column = "name")
  private String name;
  @CsvBindByName(column = "price")
  private double price;
  @CsvBindByName(column = "discount")
  private boolean discount;
}
