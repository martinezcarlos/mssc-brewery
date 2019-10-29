package mart.karle.msscbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Beer {
  private UUID id;
  private String name;
  private String style;
  private Long upc;
  private Timestamp creationDate;
  private Timestamp lastUpdatedDate;
}
