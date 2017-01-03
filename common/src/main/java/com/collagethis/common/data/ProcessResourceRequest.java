package com.collagethis.common.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessResourceRequest {

    private String id;
    private int tryCount;
    private String description;

    public ProcessResourceRequest() {}

    @JsonCreator
    public ProcessResourceRequest(@JsonProperty("id") String id,
                                  @JsonProperty("description") String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("tryCount", tryCount)
                .add("description", description)
                .toString();
    }
}
