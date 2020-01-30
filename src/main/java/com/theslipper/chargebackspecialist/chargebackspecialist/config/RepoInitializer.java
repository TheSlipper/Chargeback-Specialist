package com.theslipper.chargebackspecialist.chargebackspecialist.config;

import com.google.common.collect.Lists;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.*;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

// TODO: Delete in production
@Configuration
public class RepoInitializer {

    private final CardHolderService cardHolderService;

    private final CardIssuerService cardIssuerService;

    private final ChargebackService chargebackService;

    private final HelpEntryService helpEntryService;

    private final SystemUserService systemUserService;

    private final TerminalService terminalService;

    private final UpdateService updateService;

    private final VendorService vendorService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RepoInitializer(CardHolderService cardHolderService, CardIssuerService cardIssuerService,
                           ChargebackService chargebackService, HelpEntryService helpEntryService,
                           SystemUserService systemUserService, TerminalService terminalService,
                           UpdateService updateService, VendorService vendorService) {
        this.cardHolderService = cardHolderService;
        this.cardIssuerService = cardIssuerService;
        this.chargebackService = chargebackService;
        this.helpEntryService = helpEntryService;
        this.systemUserService = systemUserService;
        this.terminalService = terminalService;
        this.updateService = updateService;
        this.vendorService = vendorService;
    }

    private void addCardIssuers() {
        if (cardIssuerService.hasCardIssuers())
            return;

        this.cardIssuerService.addCardIssuer(new CardIssuer(
                UUID.fromString("b8142ecb-b35f-4987-b9c7-ebbf3a73d520"),
                "VISA",
                true
        ));
        this.cardIssuerService.addCardIssuer(new CardIssuer(
                UUID.fromString("c465c40b-aff1-43d8-8571-509d200b60f6"),
                "Discover",
                false
        ));
        this.cardIssuerService.addCardIssuer(new CardIssuer(
                UUID.fromString("e03daf46-4250-460c-b176-4654ee94f653"),
                "Diners Club - Carte Blanche",
                false
        ));
        this.cardIssuerService.addCardIssuer(new CardIssuer(
                UUID.fromString("5193aa6f-1354-4891-a10b-518ffd231c1c"),
                "Visa Electron",
                true
        ));
        this.cardIssuerService.addCardIssuer(new CardIssuer(
                UUID.fromString("a5bc038c-a0d6-4a05-a090-600ed31c19b6"),
                "MasterCard",
                true
        ));
        this.cardIssuerService.addCardIssuer(new CardIssuer(
                UUID.fromString("6111e408-55c4-400d-9095-4cb3e9f5e080"),
                "JCB",
                false
        ));
        this.cardIssuerService.addCardIssuer(new CardIssuer(
                UUID.fromString("f0ef43bb-deb8-4475-ad01-c2b0ca542566"),
                "Diners Club - International",
                false
        ));
        this.cardIssuerService.addCardIssuer(new CardIssuer(
                UUID.fromString("3ff5dabc-5922-4f36-9253-4efe17a18bbe"),
                "InstaPayment",
                false
        ));
        this.cardIssuerService.addCardIssuer(new CardIssuer(
                UUID.fromString("600194cb-8b27-4d6d-a907-8c84e2ad1b3d"),
                "American Express (AMEX)",
                false
        ));
        this.cardIssuerService.addCardIssuer(new CardIssuer(
                UUID.fromString("bd23272e-d338-404f-9b1f-60784d6e37d2"),
                "Diners Club - North America",
                false
        ));
        this.cardIssuerService.addCardIssuer(new CardIssuer(
                UUID.fromString("f8659428-0e02-40ce-9561-be3aab63269a"),
                "Maestro",
                false
        ));
    }

    private void addCardHolders() {
        if (cardHolderService.hasCardHolders())
            return;

        CardIssuer visa = this.cardIssuerService.getCardIssuersByName("VISA").iterator().next();
        CardIssuer mastercard = this.cardIssuerService.getCardIssuersByName("MasterCard").iterator().next();

        this.cardHolderService.addCardHolder(new CardHolder(
                UUID.fromString("c0c9b6eb-a7c9-419c-8734-b93b13056c04"),
                "Poland",
                "4556905403224140",
                "Andrzej",
                "Bratczak",
                visa
        ));
        this.cardHolderService.addCardHolder(new CardHolder(
                UUID.fromString("96dabe2e-9a03-4a2d-9032-83b2ed060bca"),
                "Poland",
                "4132446310116221",
                "Mirosław",
                "Banański",
                visa
        ));
        this.cardHolderService.addCardHolder(new CardHolder(
                UUID.fromString("4ab8acbd-87ec-45a7-9deb-f1b380af0de7"),
                "Poland",
                "4532246243388609453",
                "Stanisław",
                "Ambraszkiewicz",
                visa
        ));
        this.cardHolderService.addCardHolder(new CardHolder(
                UUID.fromString("ea143f3b-f017-48a4-a4f1-c5e928674320"),
                "Poland",
                "5125090372562330",
                "Mirosław",
                "Szatan",
                mastercard
        ));
        this.cardHolderService.addCardHolder(new CardHolder(
                UUID.fromString("2d0be261-3f9e-42e8-b13a-009842c87f6a"),
                "Germany",
                "5535215281429552",
                "Irisdina",
                "Bernhard",
                mastercard
        ));
        this.cardHolderService.addCardHolder(new CardHolder(
                UUID.fromString("ef549e38-ed1a-4954-8dc5-6c39e19c18dd"),
                "Germany",
                "5100383193236559",
                "Theodor",
                "Eberbach",
                mastercard
        ));
        this.cardHolderService.addCardHolder(new CardHolder(
                UUID.fromString("4b3d0d36-c26f-42cf-9c14-df560c12704d"),
                "Germany",
                "5370865289337351",
                "Beatrix",
                "Brehme",
                mastercard
        ));
        this.cardHolderService.addCardHolder(new CardHolder(
                UUID.fromString("535271d3-df58-41c2-a40f-39cd4acc0f52"),
                "Germany",
                "5237741458877035",
                "Lise",
                "Hohenstein",
                mastercard
        ));
        this.cardHolderService.addCardHolder(new CardHolder(
                UUID.fromString("36273613-2185-45c9-adb0-ec5207aaff91"),
                "Germany",
                "5227195836616775",
                "Katia",
                "Waldheim",
                mastercard
        ));
        this.cardHolderService.addCardHolder(new CardHolder(
                UUID.fromString("c72629e8-c4fc-43f2-974d-cb0c92b5abdc"),
                "Germany",
                "4929487311707722",
                "Gretel",
                "Jeckeln",
                visa
        ));
        this.cardHolderService.addCardHolder(new CardHolder(
                UUID.fromString("c72629e8-c4fc-43f2-974d-cb0c92b5abdc"),
                "Japan",
                "4929022651401766",
                "Shirogane",
                "Takeru",
                visa
        ));
        this.cardHolderService.addCardHolder(new CardHolder(
                UUID.fromString("3b87acd0-1972-4c3d-a454-9e3e0a6972a1"),
                "Japan",
                "4305520768748208826",
                "Jinguuji",
                "Marimo",
                visa
        ));
    }

    private void addVendorTypes() {
        if (this.vendorService.hasVendorTypes())
            return;
        this.vendorService.addVendorType(new VendorType(
                UUID.fromString("0c9b5b28-4b3b-47e9-846f-5a2657fd1b6b"),
                "Standard Vendor",
                "Vendor that has a standard contract."
        ));
        this.vendorService.addVendorType(new VendorType(
                UUID.fromString("5bd2ae47-0415-463a-bc64-897994197977"),
                "Indebted vendor",
                "Vendor that has a standard contract and hasn't payed for the bills."
        ));
        this.vendorService.addVendorType(new VendorType(
                UUID.fromString("58b9988b-ae9a-4ef3-af85-1d288d5d69a4"),
                "VIP Vendor",
                "Vendor that has a VIP contract"
        ));
    }

    private void addVendors() {
        if (this.vendorService.hasVendors())
            return;

        VendorType standardVendor = this.vendorService.getVendorTypesByName("Standard Vendor").iterator().next();
        VendorType indebtedVendor = this.vendorService.getVendorTypesByName("Indebted vendor").iterator().next();
        VendorType vipVendor = this.vendorService.getVendorTypesByName("VIP Vendor").iterator().next();

        this.vendorService.addVendor(new Vendor(
                UUID.fromString("de91e63e-0193-41dc-9052-2bc22c14da7e"),
                "Sex Shop Żwawej Mamuśki",
                standardVendor
        ));
        this.vendorService.addVendor(new Vendor(
                UUID.fromString("e1ad39ec-ffca-441c-a77c-a41cb0beb1cb"),
                "Lokalna Apteka \"Hivek\"",
                    standardVendor
        ));
        this.vendorService.addVendor(new Vendor(
                UUID.fromString("682f15d7-5524-4f6d-98eb-e91740375e0e"),
                "Osiedlowa apteka \"Korona\"",
                    standardVendor
        ));
        this.vendorService.addVendor(new Vendor(
                UUID.fromString("a9ff57e0-23ce-4511-9848-b6f0863ca562"),
                "Chińska Restauracja \"Wuhan\"",
                standardVendor
        ));
        this.vendorService.addVendor(new Vendor(
                UUID.fromString("8d2506f8-6b8e-4165-96c5-2dfae4f6d2b4"),
                "RTV EURO AGD",
                vipVendor
        ));
        this.vendorService.addVendor(new Vendor(
                UUID.fromString("c0815d73-94b6-48e6-b102-1c4d0b9f16e4"),
                "Empik",
                vipVendor
        ));
        this.vendorService.addVendor(new Vendor(
                UUID.fromString("f1463ba9-f8e7-49a7-9696-7062d127a294"),
                "Włoska Restauracja \"Vento Aureo\"",
                indebtedVendor
        ));
        this.vendorService.addVendor(new Vendor(
                UUID.fromString("3efc19c6-b6f9-4205-99f6-b0687a9ec428"),
                "Bar mleczny \"Nasionko\"",
                indebtedVendor
        ));
        this.vendorService.addVendor(new Vendor(
                UUID.fromString("9dbc2494-8091-482f-9ae8-fda2be598110"),
                "Gra Internetowa Cancer of Legends",
                vipVendor
        ));
        this.vendorService.addVendor(new Vendor(
                UUID.fromString("1e7dcd80-0ce0-4855-b6e8-555d223c3e60"),
                "Sklep internetowy \"Trolele\"",
                standardVendor
        ));
        this.vendorService.addVendor(new Vendor(
                UUID.fromString("099497e6-9fba-4342-8254-f4c49893c791"),
                "Media Expert",
                vipVendor
        ));
        this.vendorService.addVendor(new Vendor(
                UUID.fromString("904cb49b-933c-4278-8eff-35b0e85726d2"),
                "Kaufland",
                vipVendor
        ));
        this.vendorService.addVendor(new Vendor(
                UUID.fromString("c16efaab-ec08-41d5-babb-8b1a699dffa2"),
                "Carrefour",
                vipVendor
        ));
    }

    private void addChargebacks() {
        if(this.chargebackService.hasChargebacks())
            return;

        List<CardHolder> cardHolders = Lists.newArrayList(this.cardHolderService.getAllCardHolders().iterator());
        List<Vendor> vendors = Lists.newArrayList(this.vendorService.getAllVendors().iterator());

        for (int i = 0; i < cardHolders.size(); i++) {
            this.chargebackService.addChargeback(new Chargeback(
                    UUID.randomUUID(),
                    UUID.randomUUID(),
                    Chargeback.ChargebackCode.CARDHOLDER_DISPUTE,
                    new Date(),
                    null,
                    null,
                    cardHolders.get(i),
                    vendors.get(i)
            ));
        }
    }

    private void addSystemUserRoles() {
        if (this.systemUserService.hasSystemUserRoles())
            return;
        this.systemUserService.addSystemUserRole(new SystemUserRole(
               UUID.fromString("9b4ae4ea-96c0-4b42-91dc-b2b33b729eb3"),
               "Standard User",
               new SystemUserRole.SystemPermission[] {
                       SystemUserRole.SystemPermission.PROCESS_VISA_CHARGEBACK,
                       SystemUserRole.SystemPermission.PROCESS_MASTERCARD_CHARGEBACK
               },
                "ROLE_USER"
        ));
        this.systemUserService.addSystemUserRole(new SystemUserRole(
                UUID.fromString("bab1accf-bdc5-4f7d-9ad4-13b596fd7996"),
                "New User",
                new SystemUserRole.SystemPermission[] {},
                "ROLE_USER"
        ));
        this.systemUserService.addSystemUserRole(new SystemUserRole(
                UUID.fromString("87d44b9c-8a5c-4fea-ad02-acfe8c97d5bc"),
                "Administrator",
                new SystemUserRole.SystemPermission[] {
                        SystemUserRole.SystemPermission.ADD_USER,
                        SystemUserRole.SystemPermission.DELETE_USER,
                        SystemUserRole.SystemPermission.EDIT_USER,
                        SystemUserRole.SystemPermission.PROCESS_VISA_CHARGEBACK,
                        SystemUserRole.SystemPermission.PROCESS_MASTERCARD_CHARGEBACK,
                        SystemUserRole.SystemPermission.SEND_UPDATE_MESSAGE,
                        SystemUserRole.SystemPermission.DELETE_UPDATE_MESSAGE,
                        SystemUserRole.SystemPermission.EDIT_UPDATE_MESSAGE
                },
                "ROLE_ADMIN"
        ));
    }

    private void addSystemUsers() {
        if (this.systemUserService.hasSystemUsers())
            return;

        SystemUserRole admin = this.systemUserService.getSystemUserRolesByName("Administrator").iterator().next();
        SystemUserRole standardUser = this.systemUserService.getSystemUserRolesByName("Standard User").iterator().next();
        SystemUserRole newUser = this.systemUserService.getSystemUserRolesByName("New User").iterator().next();

        this.systemUserService.addSystemUser(new SystemUser(
                UUID.randomUUID(),
                "Kornel",
                "Domeradzki",
                "korneldomeradzki1@gmail.com",
                "Slipper",
                passwordEncoder.encode("Slipper"),
                new Date(),
                null,
                admin,
                true
        ));
        this.systemUserService.addSystemUser(new SystemUser(
                UUID.randomUUID(),
                "Malwina",
                "Kozłowska",
                "malwinakozlowska@gmail.com",
                "kozlowska",
                passwordEncoder.encode("kozlowska"),
                new Date(),
                null,
                this.systemUserService.getSystemUserRolesByName("Standard User").iterator().next(),
                true
        ));
        this.systemUserService.addSystemUser(new SystemUser(
                UUID.randomUUID(),
                "Zuzanna",
                "Jaworska",
                "zuzannajaworska@gmail.com",
                "jaworska",
                passwordEncoder.encode("jaworska"),
                new Date(),
                null,
                standardUser,
                true
        ));
        this.systemUserService.addSystemUser(new SystemUser(
                UUID.randomUUID(),
                "Dominik",
                "Sobolewski",
                "dominiksobolewski@gmail.com",
                "sobolewski",
                passwordEncoder.encode("sobolewski"),
                new Date(),
                null,
                standardUser,
                true
        ));
        this.systemUserService.addSystemUser(new SystemUser(
                UUID.randomUUID(),
                "Patryk",
                "Kowalik",
                "patrykkowalik@gmail.com",
                "kowalik",
                passwordEncoder.encode("kowalik"),
                new Date(),
                null,
                newUser,
                true
        ));
        this.systemUserService.addSystemUser(new SystemUser(
                UUID.randomUUID(),
                "Wiktoria",
                "Pluta",
                "wiktoriapluta@gmail.com",
                "pluta",
                passwordEncoder.encode("pluta"),
                new Date(),
                null,
                newUser,
                true
        ));
    }

    @Bean
    InitializingBean init() {
        return () -> {
            // CARD ISSUERS
            addCardIssuers();

            // CARD HOLDERS
            addCardHolders();

            // VENDOR TYPES
            addVendorTypes();

            // VENDORS
            addVendors();

            // CHARGEBACKS
            addChargebacks();

            // SYSTEM USER ROLES
            addSystemUserRoles();

            // SYSTEM USERS
            addSystemUsers();

            // TODO: Add init for other types as well
        };
    }
}
