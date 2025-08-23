package com.skillmentor.root.common;

import org.springframework.security.access.prepost.PreAuthorize;

public class Constants {
    public static final String APPLICATION_JSON = "application/json";

    public static final String ADMIN_ROLE_PERMISSION = "hasRole('ADMIN')";
    public static final String MODERATOR_ROLE_PERMISSION = "hasRole('MODERATOR')";
}
