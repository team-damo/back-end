package com.example.damo.domains.group.interfaces;

public interface GroupFindAllByReaderIdInterface {
    Long getId();
    Boolean getIsDone();
    Long getMaxUser();
    String getName();
    String getType();
    String getInquiryContents();
    Long getInquirerId();
    Long getUnreadInquiries();
    String getCreatedAt();
    String getInquiryCreatedAt();
}
