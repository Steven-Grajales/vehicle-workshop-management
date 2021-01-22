package com.repair.car.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserSearchForm {
/*    private static final String EMAIL_PATTERN = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{1,63}$";
    private static final String AFM_PATTERN = "^[0-9]*$";
    private static final int AFM_SIZE = 9;

    @NotNull(message = "{register.email.null}")
    @Pattern(regexp = EMAIL_PATTERN, message = "{register.email.invalid}")
    private String email;

    @Pattern(regexp = AFM_PATTERN, message = "{register.afm.invalid}")
    @Size(min = AFM_SIZE, max = AFM_SIZE, message = "{register.afm.size}")
    private String afm;*/

    private String SearchText;

    public String getSearchText() {
        return SearchText;
    }

    public void setSearchText(String searchText) {
        SearchText = searchText;
    }
}
