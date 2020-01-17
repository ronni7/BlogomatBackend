package com.blogomat.blogomat.services;

import com.blogomat.blogomat.model.entities.PostReport;
import com.blogomat.blogomat.repositories.ContactRepository;
import com.blogomat.blogomat.repositories.PostRepository;
import com.blogomat.blogomat.repositories.ReportRepository;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceImpl implements AdminService {
    private final ReportRepository reportRepository;
    private final PostRepository postRepository;
    private final ContactRepository contactRepository;

    public AdminServiceImpl(ReportRepository reportRepository, PostRepository postRepository, ContactRepository contactRepository) {
        this.reportRepository = reportRepository;
        this.postRepository = postRepository;
        this.contactRepository = contactRepository;
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

    @Override
    public void deleteByContactMessageID(Integer contactMessageID) {
        contactRepository.deleteById(contactMessageID);
        ;
    }
}
