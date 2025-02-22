/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.submission.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.UUID;

public final class SubmissionId {
  private final UUID value;

  private SubmissionId(UUID value) {
    this.value = value;
  }

  @JsonValue
  public UUID get() {
    return this.value;
  }

  @Override
  public boolean equals(Object other) {
    return this == other || (other instanceof SubmissionId && this.value.equals(((SubmissionId) other).value));
  }

  @Override
  public int hashCode() {
    return value.hashCode();
  }

  @Override
  public String toString() {
    return value.toString();
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static SubmissionId of(UUID value) {
    return new SubmissionId(value);
  }

  public static SubmissionId valueOf(String value) {
    return of(value);
  }
}
