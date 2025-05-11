package com.dev.luan.learn.dto.create_tip.response;

import java.util.List;

public record CreateTipResponse(String id, String object, Long created, String model,
                List<ChoicesResponse> choices, UsageResponse usage) {
}
