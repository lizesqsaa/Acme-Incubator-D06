
package acme.features.authenticated.inquiries;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.inquiries.Inquire;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedInquiriesListService implements AbstractListService<Authenticated, Inquire> {

	@Autowired
	AuthenticatedInquiriesRepository repository;


	@Override
	public boolean authorise(final Request<Inquire> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Inquire> request, final Inquire entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "minMoney", "maxMoney");
	}

	@Override
	public Collection<Inquire> findMany(final Request<Inquire> request) {
		assert request != null;

		Collection<Inquire> result;

		result = this.repository.findManyActive();

		return result;
	}

}
