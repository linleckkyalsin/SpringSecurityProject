package com.reytech.awsimageupload.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.reytech.awsimageupload.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),ADMIN(Sets.newHashSet(COURSE_READ,COURSE_WRITE,STUDENT_READ,STUDENT_WRITE)),ADMINTRAINEE(Sets.newHashSet(COURSE_WRITE,STUDENT_WRITE));
    private Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
