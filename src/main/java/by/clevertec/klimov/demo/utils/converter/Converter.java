package by.clevertec.klimov.demo.utils.converter;

import java.util.List;

public interface Converter {
  <T, V> V mapToDto(T entityObject, Class<V> model);

  <T, V> List<V> mapToDto(List<T> entityObjects, Class<V> model);

  <T, V> List<T> mapToEntity(List<V> dtoObjects, Class<T> model);

  <T, V> T mapToEntity(V dtoObject, Class<T> model);
}
