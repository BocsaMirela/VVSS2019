package agenda.model.repository.interfaces;
import java.util.List;

public interface IRepository<T> {

	boolean add(T item);
	boolean remove(T item);
	boolean update(T item);
	List<T> getAll();

}

