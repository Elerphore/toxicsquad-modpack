package ru.elerphore.toxicpack.factory.mob;

import ru.elerphore.toxicpack.factory.explosion.ExplosionFactory;
import ru.elerphore.toxicpack.factory.mob.factories.CreeperMobFactory;
import ru.elerphore.toxicpack.factory.mob.factories.JohnMobFactory;
import ru.elerphore.toxicpack.factory.mob.factories.ZombieMobFactory;

public final class FactoryReceiver {
    private ZombieMobFactory zombieMobFactory;
    private ExplosionFactory explosionFactory;
    private JohnMobFactory johnMobFactory;
    private CreeperMobFactory creeperMobFactory;

    synchronized public ZombieMobFactory getZombieFactory() {
        if(zombieMobFactory == null) {
            zombieMobFactory = new ZombieMobFactory();
        }
        return zombieMobFactory;
    }

    synchronized public CreeperMobFactory getCreeperMobFactory() {
        if(creeperMobFactory == null) {
            creeperMobFactory = new CreeperMobFactory();
        }
        return creeperMobFactory;
    }

    synchronized public ExplosionFactory getExplosionFactory() {
        if(explosionFactory == null) {
            explosionFactory = new ExplosionFactory();
        }
        return explosionFactory;
    }

    synchronized public JohnMobFactory getJohnMobFactory() {
        if(johnMobFactory == null) {
            johnMobFactory = new JohnMobFactory();
        }
        return johnMobFactory;
    }

}
