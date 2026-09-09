package dev.brunopablo.smartlocck.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.brunopablo.smartlocck.entity.PurchaseItemRequestEntity;

public interface PurchaseItemRequestRepository extends MongoRepository<PurchaseItemRequestEntity, String>{}