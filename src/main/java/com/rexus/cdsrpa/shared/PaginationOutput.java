package com.rexus.cdsrpa.shared;

import java.util.List;

public record PaginationOutput<T>(
        List<T> items,
        long page,
        long pageSize,
        long pageCount,
        long total
) {}