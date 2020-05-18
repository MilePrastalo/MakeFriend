package com.makefriend.makefriend.dto;

import java.util.List;

public class FriendSuggestionsDTO {
    private List<FriendSuggestionDTO> suggestions;

    public FriendSuggestionsDTO() {
    }

    public FriendSuggestionsDTO(List<FriendSuggestionDTO> suggestions) {
        this.suggestions = suggestions;
    }

    public List<FriendSuggestionDTO> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<FriendSuggestionDTO> suggestions) {
        this.suggestions = suggestions;
    }
}
