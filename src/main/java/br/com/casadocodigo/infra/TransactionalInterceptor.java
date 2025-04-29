package br.com.casadocodigo.infra;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.io.Serializable;
import org.jboss.logging.Logger;

@Interceptor
@Transactional
@Priority(Interceptor.Priority.APPLICATION)
public class TransactionalInterceptor implements Serializable {

  @Inject
  private EntityManager entityManager;

  private final Logger log = Logger.getLogger(this.getClass());


  @AroundInvoke
  public Object invoke(InvocationContext ctx) throws Exception {
    EntityTransaction trx = entityManager.getTransaction();
    boolean creator = false;

    log.info(String.format("@@@ %s ==> Initialize transaction: Method: %s%nCreator: %s%nActive: %s%n",
        getClass().getName(), ctx.getMethod().getName(), creator, trx.isActive()));

    try {
      if (!trx.isActive()) {
        log.info(String.format("@@@ %s ==> Transaction is not active. Execute begin() and rollback(). Method: %s%nCreator: %s%n",
            getClass().getName(), ctx.getMethod().getName(), creator));
        trx.begin();
        trx.rollback();

        trx.begin();
        creator = true;

        log.info(String.format("@@@ %s ==> Execute begin() again and set creator to true. Method: %s%nCreator: %s%n",
            getClass().getName(), ctx.getMethod().getName(), creator));
      }

      log.info(String.format("@@@ %s ==> Proceed transaction. Method: %s%nCreator: %s%n",
          getClass().getName(), ctx.getMethod().getName(), creator));

      return ctx.proceed();
    } catch (Exception e) {
      log.error(String.format("@@@ %s ==> Error transactional: %s", getClass().getName(), e.getMessage()), e);

      if (creator) {
        log.info(String.format("@@@ %s ==> Applying rollback(). Method: %s%nCreator: %s%n",
            getClass().getName(), ctx.getMethod().getName(), creator));
        trx.rollback();
      }
      throw e;
    }finally {
      if (trx.isActive() && creator) {
        log.info(String.format("@@@ %s ==> Applying commit(). Method: %s%nCreator: %s%n",
            getClass().getName(), ctx.getMethod().getName(), creator));
        trx.commit();
      }
    }

  }

}
