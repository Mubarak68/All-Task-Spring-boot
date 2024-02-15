package com.letcode.SecureBankSystem.services.suggestions.processorSuggestion;

import com.letcode.SecureBankSystem.bo.suggestions.CreateSuggestionRequest;

public interface SuggestionProcessor {
    void processSuggestion(CreateSuggestionRequest createSuggestionRequest);
}
