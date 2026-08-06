package com.todocode.springsecurity.controller;

import com.todocode.springsecurity.model.Permission;
import com.todocode.springsecurity.model.Role;
import com.todocode.springsecurity.service.IPermissionService;
import com.todocode.springsecurity.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/roles")
public class RoleController {


    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPermissionService permissionService;

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping
    public ResponseEntity<List> getAllRoles() {
        List roles = roleService.findAll();
        return ResponseEntity.ok(roles);
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/{id}")
    public ResponseEntity getRoleById(@PathVariable Long id) {
        Optional <Role> role = roleService.findById(id);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') and hasAuthority('CREATE')")
    public ResponseEntity createRole(@RequestBody Role role) {
        Set<Permission> permissionList = new HashSet<Permission>();
        Permission readPermission;

        // Recuperar la Permission/s por su ID
        for (Permission per : role.getPermissionsList()) {
            readPermission = (Permission) permissionService.findById(per.getId()).orElse(null);
            if (readPermission != null) {
                //si encuentro, guardo en la lista
                permissionList.add(readPermission);
            }
        }

        role.setPermissionsList(permissionList);
        Role newRole = roleService.save(role);
        return ResponseEntity.ok(newRole);
    }

    @PatchMapping("/{id}/permissions")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Role> patchPermissions(
            @PathVariable Long id,
            @RequestBody Set<Permission> permissionsList) {

        // El servicio se encarga de todo el trabajo
        Role updatedRole = roleService.updatePermissions(id, permissionsList);

        return ResponseEntity.ok(updatedRole);
    }



}



