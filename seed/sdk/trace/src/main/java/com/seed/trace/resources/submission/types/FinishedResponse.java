/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.trace.resources.submission.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.trace.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = FinishedResponse.Builder.class)
public final class FinishedResponse {
    private final UUID submissionId;

    private final Map<String, Object> additionalProperties;

    private FinishedResponse(UUID submissionId, Map<String, Object> additionalProperties) {
        this.submissionId = submissionId;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("submissionId")
    public UUID getSubmissionId() {
        return submissionId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FinishedResponse && equalTo((FinishedResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(FinishedResponse other) {
        return submissionId.equals(other.submissionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.submissionId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static SubmissionIdStage builder() {
        return new Builder();
    }

    public interface SubmissionIdStage {
        _FinalStage submissionId(UUID submissionId);

        Builder from(FinishedResponse other);
    }

    public interface _FinalStage {
        FinishedResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements SubmissionIdStage, _FinalStage {
        private UUID submissionId;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(FinishedResponse other) {
            submissionId(other.getSubmissionId());
            return this;
        }

        @Override
        @JsonSetter("submissionId")
        public _FinalStage submissionId(UUID submissionId) {
            this.submissionId = submissionId;
            return this;
        }

        @Override
        public FinishedResponse build() {
            return new FinishedResponse(submissionId, additionalProperties);
        }
    }
}
