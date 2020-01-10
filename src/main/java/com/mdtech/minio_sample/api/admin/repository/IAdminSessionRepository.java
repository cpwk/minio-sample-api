package com.mdtech.minio_sample.api.admin.repository;

import com.mdtech.minio_sample.api.admin.model.AdminSession;
import com.mdtech.minio_sample.common.reposiotry.BaseRepository;

public interface IAdminSessionRepository extends BaseRepository<AdminSession, Integer> {

    AdminSession findByToken(String token);

}