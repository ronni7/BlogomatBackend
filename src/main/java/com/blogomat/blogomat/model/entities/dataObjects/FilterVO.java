package com.blogomat.blogomat.model.entities.dataObjects;

import java.io.Serializable;

public class FilterVO implements Serializable {
    private String sort;
    private String order;
    private SearchCriteria filters;

    public FilterVO() {
    }

    public FilterVO(String sort, String order, SearchCriteria filters) {
        this.sort = sort;
        this.order = order;
        this.filters = filters;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public SearchCriteria getFilters() {
        return filters;
    }

    public void setFilters(SearchCriteria filters) {
        this.filters = filters;
    }
}
