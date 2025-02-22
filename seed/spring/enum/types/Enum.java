/**
 * This file was auto-generated by Fern from our API Definition.
 */

package types;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Override;
import java.lang.String;

public enum Enum {
  ONE("ONE"),

  TWO("TWO"),

  THREE("THREE");

  private final String value;

  Enum(String value) {
    this.value = value;
  }

  @JsonValue
  @Override
  public String toString() {
    return this.value;
  }
}
