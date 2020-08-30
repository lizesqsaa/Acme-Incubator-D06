
package acme.features.entrepreneur.investmentRound;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.entities.investmentRounds.Activity;
import acme.entities.investmentRounds.Investment;
import acme.entities.roles.Entrepreneur;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurInvestmentRoundRepository extends AbstractRepository {

	@Query("select i from Investment i where i.id = ?1")
	Investment findOneById(int id);

	@Query("select i from Investment i")
	Collection<Investment> findManyAll();

	@Query("select i from Investment i where i.entrepreneur.id =?1")
	Collection<Investment> findInvestmentRoundsByEntrepreneurId(int id);

	@Query("select a from Application a where a.investmentRound.id = ?1")
	Collection<Application> findApplicationByInvestmentId(int id);

	@Query("select a from Activity a where a.investment.id = ?1")
	Collection<Activity> findActivitiesByInvestmentId(int id);

	@Query("select i from Investment i where i.id = ?1")
	Investment findOneInvestmentRoundById(int id);

	@Query("select a from Activity a where a.investment.id =?1")
	Collection<Activity> findActivitiesByInvestment(int id);

	@Query("select count(a) from Activity a where a.investment.id = ?1")
	int numberOfActivitiesByInvestmentId(int investmentId);

	@Query("select sum(a.budget.amount) from Activity a where a.investment.id = ?1")
	Double sumBudgetWorkProgramme(int id);

	@Query("select i.finalMode from Investment i where i.id = ?1")
	Boolean isFinalMode(int id);

	@Query("select e from Entrepreneur e where e.id = ?1")
	Entrepreneur findOneEntrepreneurByUserAccount(int userAccountId);

	@Query("select i from Investment i where i.ticker = ?1")
	Investment findInvestmentByTicker(String ticker);

}
