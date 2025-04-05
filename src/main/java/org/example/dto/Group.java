package org.example.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Group {
    String groupId;
    List<String> userIds;
    Map<String, Map<String, Long>>  expenseAdjMap;

    public Group(List<String> userIds) {
        this.groupId = UUID.randomUUID().toString();
        this.userIds = userIds;
    }
}
