package com.letcode.SecureBankSystem.services.suggestions;

import com.letcode.SecureBankSystem.bo.suggestions.CreateSuggestionRequest;
import com.letcode.SecureBankSystem.entities.GuestEntity;
import com.letcode.SecureBankSystem.repositories.GuestRepository;
import com.letcode.SecureBankSystem.services.suggestions.processorSuggestion.SuggestionProcessor;
import com.letcode.SecureBankSystem.utils.enums.SuggestionStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuggestionsServiceImpl implements SuggestionsService{
    private final GuestRepository guestRepository;

    public SuggestionsServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public void createSuggestion(CreateSuggestionRequest createSuggestionRequest) {
        SuggestionProcessor function = suggestion -> {
            GuestEntity guestEntity = new GuestEntity();
            guestEntity.setSuggestionText(suggestion.getSuggestionText());
            guestEntity.setRate(suggestion.getRate());
            guestEntity.setStatus(SuggestionStatus.valueOf(suggestion.getStatus().toUpperCase()));
            guestRepository.save(guestEntity);
        };
        function.processSuggestion(createSuggestionRequest);
    }

    @Override
    public List<GuestEntity> findSuggestions(String status) {
        List<GuestEntity> suggestions = guestRepository.findAll()
                .stream()
                .filter(guestEntity -> guestEntity.getStatus().toString().equals(status))
                .collect(Collectors.toList());
        return suggestions;
    }

}
