package com.sample.hateoas.core.entities.auditing;

import com.sample.hateoas.core.security.UserDetailsServiceImpl;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by andresmerida on 4/4/2016.
 */

public class AuditorAwareImpl implements AuditorAware<Long> {

    @Override
    public Long getCurrentAuditor() {
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }

        return ((UserDetailsServiceImpl.CustomUserDetails) authentication.getPrincipal()).getUserId();
    }
}
