package com.makefriend.makefriend.dto;

import java.util.List;

public class FriendSuggestionsDTO {
    private List<UserBasicDto> suggestions;

    public FriendSuggestionsDTO() {
    }

    public FriendSuggestionsDTO(List<UserBasicDto> suggestions) {
        this.suggestions = suggestions;
    }

    public List<UserBasicDto> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<UserBasicDto> suggestions) {
        this.suggestions = suggestions;
    }
}
