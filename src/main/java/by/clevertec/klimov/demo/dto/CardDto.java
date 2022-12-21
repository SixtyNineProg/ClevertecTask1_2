package by.clevertec.klimov.demo.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class CardDto implements Serializable {
  private long id;
  @CsvBindByName(column = "number")
  private int number;
  @CsvBindByName(column = "discount")
  private int discount;
}
