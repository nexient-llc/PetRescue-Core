package com.systemsinmotion.petrescue.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.systemsinmotion.petrescue.entity.RemoteIdentifier;
import com.systemsinmotion.petrescue.entity.type.ApiType;

public interface RemoteIdentifierRepository extends
		JpaRepository<RemoteIdentifier, Integer> {

	RemoteIdentifier findByPetId(Integer id);

	RemoteIdentifier findByRemoteId(String id);

	List<RemoteIdentifier> findByLastUpdatedLessThan(Date date);

	List<RemoteIdentifier> findByLastUpdatedAfter(Date date);

	List<RemoteIdentifier> findByLastUpdatedBefore(Date date);

	List<RemoteIdentifier> findByApi(ApiType api);

}
