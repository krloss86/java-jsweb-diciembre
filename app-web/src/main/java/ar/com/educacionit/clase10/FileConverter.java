package ar.com.educacionit.clase10;

import java.util.Collection;

import ar.com.educacionit.domain.Producto;

public interface FileConverter<T> {

	T convert(Collection<Producto> producto);
}
