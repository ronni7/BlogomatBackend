package com.blogomat.blogomat.controllers;

import com.blogomat.blogomat.model.entities.ContactMessage;
import com.blogomat.blogomat.model.entities.PostReport;
import com.blogomat.blogomat.services.AdminService;
import com.blogomat.blogomat.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/admin")
//@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {
    private final AdminService adminService;
    private final UserService  userService;

    public AdminController(AdminService adminService, UserService userService) {
        this.adminService = adminService;
        this.userService = userService;
    }

    @GetMapping(path = "/reports")
    public @ResponseBody
    Iterable<PostReport> getReports() {
        return adminService.getReports();
    }
    @GetMapping(path = "/contactMessages")
    public @ResponseBody
    Iterable<ContactMessage> getContactMessages() {
        return userService.getContactMessages();
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

    @DeleteMapping(path = "/deleteContactMessage/{contactMessageID}")
    public @ResponseBody
    void ContactMessage(@PathVariable Integer contactMessageID) {
        adminService.deleteByContactMessageID(contactMessageID);
    }

}