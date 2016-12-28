package io.softwarestrategies.kafkatemplate.common.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Data;

@Data
public class WorkUnit {
    private String id;
    private String description;

    public WorkUnit() {}

    @JsonCreator
    public WorkUnit(@JsonProperty("id") String id,
                    @JsonProperty("description") String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("description", description)
                .toString();
    }
}
