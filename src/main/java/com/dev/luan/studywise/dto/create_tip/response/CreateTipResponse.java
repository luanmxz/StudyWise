package com.dev.luan.studywise.dto.create_tip.response;

import java.util.List;

public record CreateTipResponse(String id, String object, Long created, String model,
                List<ChoicesResponse> choices, UsageResponse usage) {
}
