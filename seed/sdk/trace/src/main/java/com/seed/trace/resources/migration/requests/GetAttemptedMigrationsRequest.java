/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.trace.resources.migration.requests;

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

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GetAttemptedMigrationsRequest.Builder.class)
public final class GetAttemptedMigrationsRequest {
    private final String adminKeyHeader;

    private final Map<String, Object> additionalProperties;

    private GetAttemptedMigrationsRequest(String adminKeyHeader, Map<String, Object> additionalProperties) {
        this.adminKeyHeader = adminKeyHeader;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("admin-key-header")
    public String getAdminKeyHeader() {
        return adminKeyHeader;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetAttemptedMigrationsRequest && equalTo((GetAttemptedMigrationsRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GetAttemptedMigrationsRequest other) {
        return adminKeyHeader.equals(other.adminKeyHeader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.adminKeyHeader);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static AdminKeyHeaderStage builder() {
        return new Builder();
    }

    public interface AdminKeyHeaderStage {
        _FinalStage adminKeyHeader(String adminKeyHeader);

        Builder from(GetAttemptedMigrationsRequest other);
    }

    public interface _FinalStage {
        GetAttemptedMigrationsRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements AdminKeyHeaderStage, _FinalStage {
        private String adminKeyHeader;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(GetAttemptedMigrationsRequest other) {
            adminKeyHeader(other.getAdminKeyHeader());
            return this;
        }

        @Override
        @JsonSetter("admin-key-header")
        public _FinalStage adminKeyHeader(String adminKeyHeader) {
            this.adminKeyHeader = adminKeyHeader;
            return this;
        }

        @Override
        public GetAttemptedMigrationsRequest build() {
            return new GetAttemptedMigrationsRequest(adminKeyHeader, additionalProperties);
        }
    }
}
