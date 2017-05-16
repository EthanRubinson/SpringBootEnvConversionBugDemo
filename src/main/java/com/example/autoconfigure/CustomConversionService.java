package com.example.autoconfigure;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.core.convert.support.ConfigurableConversionService;

/**
 * Support with getProperty(key, URL.class)
 * Try to convert a local file path to URL
 */
public class CustomConversionService implements ConfigurableConversionService {

  private ConfigurableConversionService m_delegate;

  public CustomConversionService(ConfigurableConversionService delegate) {
    m_delegate = delegate;
  }

  @Override
  public <S, T> void addConverter(Class<S> sourceType, Class<T> targetType, Converter<? super S, ? extends T> converter) {
    m_delegate.addConverter(sourceType, targetType, converter);
  }

  @Override
  public void addConverter(Converter<?, ?> converter) {
    m_delegate.addConverter(converter);
  }

  @Override
  public void addConverter(GenericConverter converter) {
    m_delegate.addConverter(converter);
  }

  @Override
  public void addConverterFactory(ConverterFactory<?, ?> converterFactory) {
    m_delegate.addConverterFactory(converterFactory);
  }

  @Override
  public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
    return m_delegate.canConvert(sourceType, targetType);
  }

  @Override
  public boolean canConvert(TypeDescriptor sourceType, TypeDescriptor targetType) {
    return m_delegate.canConvert(sourceType, targetType);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> T convert(Object source, Class<T> targetType) {
    //only try to convert to URL in case of file existence case
    if (targetType.equals(URL.class) && source instanceof String) {
      if ("CUSTOM_STRING_VALUE_THAT_RESOLVES_TO_THE_SPRING.IO_URL".equals((String)source)) {
        try {
          return (T) new URL("http://spring.io");
        } catch (MalformedURLException e) {
          e.printStackTrace();
        }
      }
    }
    return m_delegate.convert(source, targetType);
  }

  @Override
  public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
    return m_delegate.convert(source, sourceType, targetType);
  }

  @Override
  public void removeConvertible(Class<?> sourceType, Class<?> targetType) {
    m_delegate.removeConvertible(sourceType, targetType);
  }
}
