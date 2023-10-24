package ru.elerphore.toxicpack.factory.mob;

import ru.elerphore.toxicpack.factory.explosion.ExplosionFactory;

public final class FactoryReceiver {
    private ZombieMobFactory zombieMobFactory;
    private ExplosionFactory explosionFactory;

    synchronized public ZombieMobFactory getZombieFactory() {
        if(zombieMobFactory == null) {
            zombieMobFactory = new ZombieMobFactory();
        }
        return zombieMobFactory;
    }

    synchronized public ExplosionFactory getExplosionFactory() {
        if(explosionFactory == null) {
            explosionFactory = new ExplosionFactory();
        }
        return explosionFactory;
    }
}
