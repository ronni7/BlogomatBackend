package com.blogomat.blogomat.services;

import com.blogomat.blogomat.model.entities.PostReport;
import com.blogomat.blogomat.repositories.PostRepository;
import com.blogomat.blogomat.repositories.ReportRepository;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceImpl implements AdminService {
    private final ReportRepository reportRepository;
    private final PostRepository postRepository;

    public AdminServiceImpl(ReportRepository reportRepository, PostRepository postRepository) {
        this.reportRepository = reportRepository;
        this.postRepository = postRepository;
    }

    @Override
    public Iterable<PostReport> getReports() {
        System.out.println("reportRepository = " + reportRepository.findAll());
        return reportRepository.findAll();
    }

    @Override
    public void deletePost(int postID) {
        postRepository.deleteById(postID);
    }

    @Override
    public void deleteByReportID(int reportID) {
        reportRepository.deleteById(reportID);
    }
}
