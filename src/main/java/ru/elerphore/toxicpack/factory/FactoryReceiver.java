package ru.elerphore.toxicpack.factory;

public final class FactoryReceiver {
    private ZombieMobFactory zombieMobFactory;

    synchronized public ZombieMobFactory getZombieFactory() {
        if(zombieMobFactory == null) {
            zombieMobFactory = new ZombieMobFactory();
        }
        return zombieMobFactory;
    }
}
