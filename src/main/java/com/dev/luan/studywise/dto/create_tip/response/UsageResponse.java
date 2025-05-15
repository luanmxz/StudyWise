package com.dev.luan.studywise.dto.create_tip.response;

import com.google.gson.annotations.SerializedName;

public class UsageResponse {

    @SerializedName("prompt_tokens")
    private Integer promptTokens;

    @SerializedName("total_tokens")
    private Integer totalTokens;

    @SerializedName("completion_tokens")
    private Integer completionTokens;
}
