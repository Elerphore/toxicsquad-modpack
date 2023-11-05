package ru.elerphore.toxicpack;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import ru.elerphore.toxicpack.entity.ModEntities;
import ru.elerphore.toxicpack.entity.client.john.JohnRenderer;
import ru.elerphore.toxicpack.entity.client.snusgolem.SnusGolemRenderer;
import ru.elerphore.toxicpack.events.OnItemChangeEventImplementation;
import ru.elerphore.toxicpack.events.OnKeyInputEventImplementation;
import ru.elerphore.toxicpack.factory.mob.FactoryReceiver;
import ru.elerphore.toxicpack.item.ModCreativeModTabs;
import ru.elerphore.toxicpack.item.ModItems;
import ru.elerphore.toxicpack.network.ToxicSquadPacketHandler;
import ru.elerphore.toxicpack.painsystems.mathquiz.MathQuiz;
import ru.elerphore.toxicpack.painsystems.mathquiz.scheduler.MathQuizScheduler;
import ru.elerphore.toxicpack.sound.ModSounds;

import java.util.Timer;
import java.util.concurrent.TimeUnit;


@Mod(ToxicMod.MODID)
public class ToxicMod {

    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    public static final FactoryReceiver factoryReceiver = new FactoryReceiver();

    public static final String MODID = "toxicsquadpack";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ToxicMod() {
        ToxicSquadPacketHandler.register();
        ModEntities.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);
        ModSounds.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            new Timer().scheduleAtFixedRate(new MathQuizScheduler(), 0, TimeUnit.MINUTES.toMillis(15));
        });
    }

    @Mod.EventBusSubscriber(modid = ToxicMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeEvents {

        @SubscribeEvent
        public static void onItemChangeEvent(LivingEquipmentChangeEvent event) {
            OnItemChangeEventImplementation.implementation(event);
        }

        @SubscribeEvent
        public static void onKeyInputEvent(InputEvent event) {
            OnKeyInputEventImplementation.implementation(event);
        }

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        event.getServer().overworld().players().stream().forEach(player -> {
            player.sendSystemMessage(Component.literal("Hi there"));
        });
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.JOHN.get(), JohnRenderer::new);
            EntityRenderers.register(ModEntities.SNUS_GOLEM.get(), SnusGolemRenderer::new);
        }

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ServerModEvents {

        @SubscribeEvent
        public static void onPlayerChat(ServerChatEvent event) {
            var player = event.getPlayer();
            var mathQuiz = MathQuiz.getInstance();

            try {
                if(mathQuiz.isMathQuizCurrentlyActive()) mathQuiz.playerAnswered(player, Float.valueOf(event.getRawText()));
            } catch(NumberFormatException exception) {
                mathQuiz.addPlayerToTheListWhoDidNotAnswer(player);
            }

        }

        @SubscribeEvent
        public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
            var mathQuiz = MathQuiz.getInstance();
            mathQuiz.addPlayer((ServerPlayer) event.getEntity());
        }

        @SubscribeEvent
        public static void onPlayerLeft(PlayerEvent.PlayerLoggedOutEvent event) {
            var mathQuiz = MathQuiz.getInstance();
            mathQuiz.removePlayer((ServerPlayer) event.getEntity());
        }

    }



}
