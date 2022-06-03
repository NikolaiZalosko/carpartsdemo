package noncom.nickz.carpartsdemo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
@Getter
@Setter
public class Part {

  @PrimaryKeyColumn(
      name = "id",
      ordinal = 2,
      type = PrimaryKeyType.CLUSTERED,
      ordering = Ordering.DESCENDING)
  private UUID id;

  @PrimaryKeyColumn(name = "number",
      ordinal = 0,
      type = PrimaryKeyType.PARTITIONED)
  private String number;

  @Column
  private String name;

  @Column
  private float price;

  @Column
  private float weight;
}
