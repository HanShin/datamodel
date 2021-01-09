package io.hanshin.datamodel.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ApiResponse<T> {

    private final List<T> result;

    @JsonProperty("total_data_count")
    public int getTotalDataCount(){
        return result.size();
    }
}
