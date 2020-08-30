
package acme.features.investor.application;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class InvestorApplicationListMineService implements AbstractListService<Investor, Application> {

	@Autowired
	InvestorApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		return request.getPrincipal().hasRole(Investor.class);
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		//model.setAttribute("status", entity.getStatus().toString());
		//model.setAttribute("investmentRound", entity.getInvestmentRound().getTitle());

		request.unbind(entity, model, "creationMoment", "ticker", "statement", "offer");

	}

	@Override
	public Collection<Application> findMany(final Request<Application> request) {
		assert request != null;

		Collection<Application> result;
		Principal principal;

		principal = request.getPrincipal();
		result = this.repository.findManyByInvestorId(principal.getActiveRoleId());

		return result;
	}

}
