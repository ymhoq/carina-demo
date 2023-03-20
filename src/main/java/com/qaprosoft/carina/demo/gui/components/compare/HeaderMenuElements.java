package com.qaprosoft.carina.demo.gui.components.compare;

public enum HeaderMenuElements {

    HOME(0),
    NEWS(1),
    REVIEWS(2),
    VIDEOS(3),
    FEATURED(4),
    PHONE_FINDER(5),
    DEALS(6),
    MERGE(7),
    COVERAGE(8),
    CONTACT_US(9);

    private final Integer headerElement;
    HeaderMenuElements( Integer headerElement) {
        this.headerElement = headerElement;
    }

    public Integer getHeaderElement()
    { return headerElement;  }
}
