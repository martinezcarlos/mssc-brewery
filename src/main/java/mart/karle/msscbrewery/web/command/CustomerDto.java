package mart.karle.msscbrewery.web.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mart.karle.msscbrewery.web.markers.OnCreate;
import mart.karle.msscbrewery.web.markers.OnUpdate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
  @Null(groups = OnCreate.class)
  @NotNull(groups = OnUpdate.class)
  private UUID id;

  @NotBlank
  @Size(min = 3, max = 100)
  private String name;
}
