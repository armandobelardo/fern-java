/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.unknown.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import core.ObjectMappers;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = MyObject.Builder.class
)
public final class MyObject {
  private final Object unknown;

  private MyObject(Object unknown) {
    this.unknown = unknown;
  }

  @JsonProperty("unknown")
  public Object getUnknown() {
    return unknown;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof MyObject && equalTo((MyObject) other);
  }

  private boolean equalTo(MyObject other) {
    return unknown.equals(other.unknown);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.unknown);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static UnknownStage builder() {
    return new Builder();
  }

  public interface UnknownStage {
    _FinalStage unknown(Object unknown);

    Builder from(MyObject other);
  }

  public interface _FinalStage {
    MyObject build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements UnknownStage, _FinalStage {
    private Object unknown;

    private Builder() {
    }

    @Override
    public Builder from(MyObject other) {
      unknown(other.getUnknown());
      return this;
    }

    @Override
    @JsonSetter("unknown")
    public _FinalStage unknown(Object unknown) {
      this.unknown = unknown;
      return this;
    }

    @Override
    public MyObject build() {
      return new MyObject(unknown);
    }
  }
}
