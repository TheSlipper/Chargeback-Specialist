package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.Vendor;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.VendorType;
import com.theslipper.chargebackspecialist.chargebackspecialist.repositories.VendorRepository;
import com.theslipper.chargebackspecialist.chargebackspecialist.repositories.VendorTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorTypeRepository vendorTypeRepository;

    private final VendorRepository vendorRepository;

    @Autowired
    public VendorServiceImpl(VendorTypeRepository vendorTypeRepository, VendorRepository vendorRepository) {
        this.vendorTypeRepository = vendorTypeRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void addVendorType(VendorType vendorType) {
        this.vendorTypeRepository.save(vendorType);
    }

    @Override
    public void rmVendorTypeByID(UUID id) {
        this.vendorTypeRepository.deleteById(id);
    }

    @Override
    public Iterable<VendorType> getAllVendorTypes() {
        return this.vendorTypeRepository.findAll();
    }

    @Override
    public Optional<VendorType> getVendorTypeByID(UUID id) {
        return this.vendorTypeRepository.findById(id);
    }

    @Override
    public Iterable<VendorType> getVendorTypesByName(String name) {
        // TODO: Test this out
        Iterable<VendorType> vendorTypes = () -> StreamSupport.
                stream(this.vendorTypeRepository.findAll().spliterator(),false)
                .filter(vendorType -> vendorType.getVendorTypeName().contains(name)).iterator();
        return vendorTypes;
    }

    @Override
    public void addVendor(Vendor vendor) {
        this.vendorRepository.save(vendor);
    }

    @Override
    public void rmVendorByID(UUID id) {
        this.vendorRepository.deleteById(id);
    }

    @Override
    public Iterable<Vendor> getAllVendors() {
        return null;
    }

    @Override
    public Optional<Vendor> getVendorByID(UUID id) {
        return null;
    }

    @Override
    public Iterable<Vendor> getVendorsByName(String name) {
        return null;
    }

    @Override
    public Iterable<Vendor> getVIPVendors() {
        return null;
    }
}
