package by.clevertec.klimov.demo.utils.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConverterImpl implements Converter {

  private final ModelMapper modelMapper;

  @Autowired
  public ConverterImpl(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  @Override
  public <T, V> V mapToDto(T entityObject, Class<V> model) {
    return modelMapper.map(entityObject, model);
  }

  @Override
  public <T, V> List<V> mapToDto(List<T> entityObjects, Class<V> model) {
    return entityObjects.stream().map(entityObject -> mapToDto(entityObject, model)).toList();
  }

  @Override
  public <T, V> List<T> mapToEntity(List<V> dtoObjects, Class<T> model) {
    return dtoObjects.stream().map(dtoObject -> mapToDto(dtoObject, model)).toList();
  }

  @Override
  public <T, V> T mapToEntity(V dtoObject, Class<T> model) {
    return modelMapper.map(dtoObject, model);
  }
}
