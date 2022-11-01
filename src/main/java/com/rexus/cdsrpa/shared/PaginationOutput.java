package com.rexus.cdsrpa.shared;

import java.util.List;

public class PaginationOutput<T> {

    public List<T> items;
    public long page;
    public long pageSize;
    public long pageCount;
    public long total;

    public PaginationOutput(List<T> items, long page, long pageSize, long pageCount, long total) {
        this.items = items;
        this.page = page;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.total = total;
    }
}