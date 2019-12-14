
package acme.features.authenticated.requestAuditor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.roles.RequestAuditor;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedRequestAuditorRepository extends AbstractRepository {

	@Query("select ua from UserAccount ua where ua.id = ?1")
	UserAccount findOneUserAccountById(int id);

	@Query("select a from RequestAuditor a where a.userAccount.id = ?1")
	RequestAuditor findOneRequestAuditorById(int id);
}
