package br.com.casadocodigo.infra;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class EntityManagerProducer {

  private final EntityManagerFactory factory;
  private final Logger logger = LoggerFactory.getLogger(EntityManagerProducer.class);
  private final String PERSISTENCE_UNIT_NAME = "casadocodigoPU";

  public EntityManagerProducer() {
    this.factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
  }

  @Produces
  @RequestScoped
  public EntityManager createEntityManager() {
    logger.info("Creating entity manager... {}", PERSISTENCE_UNIT_NAME);
    return this.factory.createEntityManager();
  }

  public void closeEntityManager(@Disposes EntityManager em) {
    em.close();
  }

}
