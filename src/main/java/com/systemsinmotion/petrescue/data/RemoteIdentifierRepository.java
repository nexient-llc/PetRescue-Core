package com.systemsinmotion.petrescue.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systemsinmotion.petrescue.entity.PetRecord;
import com.systemsinmotion.petrescue.entity.RemoteIdentifier;
import com.systemsinmotion.petrescue.entity.type.ApiType;

@Repository("remoteIdentifierRepository")
public interface RemoteIdentifierRepository extends
		JpaRepository<RemoteIdentifier, Integer> {

	RemoteIdentifier findByPet(PetRecord pet);

	RemoteIdentifier findByRemoteId(String id);

	List<RemoteIdentifier> findByApi(ApiType api);

	List<RemoteIdentifier> findByLastUpdatedAfter(Date date);

	List<RemoteIdentifier> findByLastUpdatedBefore(Date date);

	List<RemoteIdentifier> findByLastUpdatedLessThan(Date date);

	List<RemoteIdentifier> findByPetAndLastUpdatedLessThan(PetRecord pet,
			Date date);

	List<RemoteIdentifier> findByLastUpdatedBetween(Date date, Date date2);

}
