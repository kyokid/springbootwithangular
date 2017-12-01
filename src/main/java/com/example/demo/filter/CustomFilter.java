package com.example.demo.filter;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.FirewalledRequest;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CustomFilter extends GenericFilterBean{

    private static final String FILTER_APPLIED = CustomFilter.class.getName().concat(".APPLIED");
    private List<SecurityFilterChain> filterChains;
//    private FilterChainProxy.FilterChainValidator filterChainValidator = new NullFilter
    private HttpFirewall firewall = new DefaultHttpFirewall();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        boolean clearContext = servletRequest.getAttribute(FILTER_APPLIED) == null;
        if (clearContext) {
            try{
                servletRequest.setAttribute(FILTER_APPLIED, Boolean.TRUE);
                doFilterInternal(servletRequest, servletResponse, filterChain);
            } finally {
                SecurityContextHolder.clearContext();
                servletRequest.removeAttribute(FILTER_APPLIED);
            }
        } else {
            doFilterInternal(servletRequest, servletResponse, filterChain);
        }
    }

    private void doFilterInternal(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        FirewalledRequest fwRequest = firewall.getFirewalledRequest((HttpServletRequest) request);
        HttpServletResponse fwResponse = firewall.getFirewalledResponse((HttpServletResponse) response);

        List<Filter> filters = getFilter(fwRequest);
        if ((null == filters) || (filters.size() == 0)) {
            fwRequest.reset();
            chain.doFilter(fwRequest, fwResponse);
            return;
        }
//        VirtualFilter
    }

    private List<Filter> getFilter(HttpServletRequest request) {
        for (SecurityFilterChain chain: this.filterChains) {
            if (chain.matches(request)) {
                return chain.getFilters();
            }
        }
        return null;
    }

    private static class VirtualFilterChain implements FilterChain {

        private final FilterChain originalChain;
        private final List<Filter> additionalFilters;
        private final FirewalledRequest firewalledRequest;
        private final int size;
        private int currentPosition = 0;

        public VirtualFilterChain(FilterChain originalChain, List<Filter> additionalFilters, FirewalledRequest firewalledRequest, int size) {
            this.originalChain = originalChain;
            this.additionalFilters = additionalFilters;
            this.firewalledRequest = firewalledRequest;
            this.size = size;
        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException {
            if (this.currentPosition == this.size) {
//                if (FilterChainProxy)
            }
        }
    }
}
