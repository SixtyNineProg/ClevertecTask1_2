package by.clevertec.klimov.demo.utils;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.core.io.ClassPathResource;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CustomCsvToBean<T> {
  public List<T> beanBuilder(String fileName, Class<T> requireClass, char separator)
      throws IOException {

    return new CsvToBeanBuilder<T>(
            new FileReader(new ClassPathResource(fileName).getFile().getAbsoluteFile().toString()))
        .withType(requireClass)
        .withSeparator(separator)
        .build()
        .parse();
  }
}
