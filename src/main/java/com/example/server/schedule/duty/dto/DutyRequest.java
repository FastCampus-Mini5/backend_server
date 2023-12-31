package com.example.server.schedule.duty.dto;

import com.example.server.schedule.duty.model.Duty;
import com.example.server.user.model.User;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DutyRequest {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class AddDTO {

        @NotNull
        private Timestamp dutyDate;

        public Duty toEntityWith(User user) {
            return Duty.builder()
                    .user(user)
                    .dutyDate(dutyDate)
                    .build();
        }
    }
}