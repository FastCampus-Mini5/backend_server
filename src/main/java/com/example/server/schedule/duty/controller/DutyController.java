package com.example.server.schedule.duty.controller;


import com.example.server._core.security.PrincipalUserDetail;
import com.example.server._core.util.ApiResponse;
import com.example.server.schedule.duty.dto.DutyRequest;
import com.example.server.schedule.duty.dto.DutyResponse;
import com.example.server.schedule.duty.service.DutyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class DutyController {

    private final DutyService dutyService;

    @PostMapping("/duty/add")
    public ResponseEntity<ApiResponse.Result<DutyResponse.DutyDTO>> add(@RequestBody @Valid DutyRequest.AddDTO dutyRequest,
                                                                        @AuthenticationPrincipal PrincipalUserDetail userDetails) {

        Long userId = userDetails.getUser().getId();
        DutyResponse.DutyDTO dutyResponse = dutyService.requestDuty(dutyRequest,userId);

        return ResponseEntity.ok(ApiResponse.success(dutyResponse));
    }
}