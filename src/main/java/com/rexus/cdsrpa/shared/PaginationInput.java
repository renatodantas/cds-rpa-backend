package com.rexus.cdsrpa.shared;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.QueryParam;

/**
 * Parâmetros de paginação.
 */
public class PaginationInput {

    private static final int DEFAULT_PAGE = 1;
    private static final int DEFAULT_SIZE = 10;
    private static final int MAX_SIZE = 100;
    private static final String DEFAULT_ORDER = "asc";

    @QueryParam("page")
    public Integer page;

    @QueryParam("size")
    public Integer size;

    @QueryParam("sort")
    public String sort;

    @QueryParam("order")
    public String order = DEFAULT_ORDER; // asc | desc

    public Sort getSortOrDefault(String defaultField) {
        final var theSort = StringUtils.isEmpty(sort) ? defaultField : sort;
        final var theOrder = StringUtils.isEmpty(order) || "asc".equalsIgnoreCase(order)
                ? Sort.Direction.Ascending
                : Sort.Direction.Descending;
        return Sort.by(theSort, theOrder);
    }

    public Page getPageOrDefault() {
        final var thePage = page == null ? DEFAULT_PAGE : page;
        final var theSize = size == null || size > 100 ? DEFAULT_SIZE : size;
        return Page.of(thePage, theSize);
    }
}