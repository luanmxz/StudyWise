package com.dev.luan.studywise.adapters.dto.create_revision_unit.response;

import java.util.List;

public record CreateTipResponse(String id, String object, Long created, String model,
                List<ChoicesResponse> choices, UsageResponse usage) {
}
