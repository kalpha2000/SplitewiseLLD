package org.example.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Expenses {
    String expenseId;
    List<String> paidByUserIdList;
    List<String> paidForUserIdList;
    Date createdDate;
    String groupId;
}
