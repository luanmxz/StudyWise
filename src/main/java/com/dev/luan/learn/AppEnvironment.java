package com.dev.luan.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppEnvironment {

    @Autowired
    private Environment env;

    public String getHuggingFaceUrl() {
        env.getActiveProfiles();
        return env.getProperty("HUGGINGFACE_API_URL");
    }

    public String getHuggingFaceApiKey() {
        return env.getProperty("HUGGINGFACE_API_KEY");
    }

    public String getGenerativeIaModel() {
        return env.getProperty("GENERATIVE_IA_MODEL");
    }

    public String getMaxTokensToGenerateText() {
        return env.getProperty("MAX_TOKENS_TO_GENERATE_TEXT");
    }

    public String getPromptToCreateTip() {
        return env.getProperty("PROMPT_TO_CREATE_TIP");
    }
}
