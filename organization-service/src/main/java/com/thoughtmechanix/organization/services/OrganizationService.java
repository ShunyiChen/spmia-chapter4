package com.thoughtmechanix.organization.services;

import com.thoughtmechanix.organization.model.Organization;
import com.thoughtmechanix.organization.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository orgRepository;

    public Organization getOrg(String organizationId) {


//        Organization o = new Organization();
//        o.setOrganizationId(UUID.randomUUID().toString());
//        o.setContactEmail("chens@rocketsoftware.com");
//        o.setName("CHENS");
//        o.setContactPhone("15841124001");
//        o.setContactName("shunyi");
//        orgRepository.save(o);
//
//        Iterable<Organization> iter = orgRepository.findAll();
//        iter.forEach(e -> {
//            System.out.println("========"+e.getOrganizationId());
//        });


        Optional<Organization> opt = orgRepository.findById(organizationId);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            return new Organization();
        }
//        return orgRepository.findByOrganizationId(organizationId);
    }

    public void saveOrg(Organization org){
        org.setOrganizationId( UUID.randomUUID().toString());

        orgRepository.save(org);

    }

    public void updateOrg(Organization org){
        orgRepository.save(org);
    }

    public void deleteOrg(Organization org){
//        orgRepository.delete( org.getId());
    }
}
