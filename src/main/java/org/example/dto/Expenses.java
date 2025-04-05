package org.example.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Expenses {
    String expenseId;
    Map<String, Double> userContriMap;
    Date createdDate;
    String groupId;

    public Expenses(Date createdDate, String groupId) {
        this.expenseId = UUID.randomUUID().toString();
        this.createdDate = createdDate;
        this.groupId = groupId;
    }
}
