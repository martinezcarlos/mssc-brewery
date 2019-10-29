package mart.karle.msscbrewery.web.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeerDto {
  @Null private UUID id;
  @NotBlank private String name;
  @NotBlank private String style;

  @Range(min = 10, max = 100)
  private Long upc;

  private OffsetDateTime creationDate;
  private OffsetDateTime lastUpdatedDate;
}
