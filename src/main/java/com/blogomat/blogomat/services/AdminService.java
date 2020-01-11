package com.blogomat.blogomat.services;

import com.blogomat.blogomat.model.entities.PostReport;

public interface AdminService {
    Iterable<PostReport> getReports();

    void deletePost(int postID);

    void deleteByReportID(int reportID);
}
