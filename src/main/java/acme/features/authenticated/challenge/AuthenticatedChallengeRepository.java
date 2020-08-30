
package acme.features.authenticated.challenge;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.challenges.Challenge;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedChallengeRepository extends AbstractRepository {

	@Query("select req from Challenge req where req.id = ?1")
	Challenge findChallengeById(int id);

	@Query("select req from Challenge req")
	Collection<Challenge> findMany();

}
