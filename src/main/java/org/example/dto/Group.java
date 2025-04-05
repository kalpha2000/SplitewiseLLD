package org.example.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Group {
    String groupId;
    List<String> userIds;
    Map<String, Map<String, Long>>  expenseAdjMap;
}
