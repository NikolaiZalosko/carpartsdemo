package noncom.nickz.carpartsdemo.repository;

import noncom.nickz.carpartsdemo.model.Part;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface PartRepository extends CassandraRepository<Part, UUID> {

  List<Part> findByNumberIn(List<String> numbers);

  void deleteAllByNumberIn(List<String> numbers);
}
