package com.blogomat.blogomat.controllers;

import com.blogomat.blogomat.model.entities.PostReport;
import com.blogomat.blogomat.services.AdminService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(path = "/reports")
    public @ResponseBody
    Iterable<PostReport> getReports() {
        return adminService.getReports();
    }

    @DeleteMapping(path = "/deletePost/{postID}")
    public @ResponseBody
    void delete(@PathVariable Integer postID) {
        adminService.deletePost(postID);
    }
    @DeleteMapping(path = "/deleteReport/{reportID}")
    public @ResponseBody
    void deleteReport(@PathVariable Integer reportID) {
        adminService.deleteByReportID(reportID);
    }
}