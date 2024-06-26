package com.sywyar.weTogether.entity.fake;

import com.sywyar.weTogether.WeTogether;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;

public class FakePlayerUtils {
    public static void createFakePlayers(List<FakePlayerInfo> fakePlayerInfos) {
        fakePlayerInfos.forEach(fakePlayerInfo -> {
            ServerPlayer fakePlayer = EntityPlayerMPFake.createFakePlayer(fakePlayerInfo.getUsername(),
                    fakePlayerInfo.getServer(),
                    fakePlayerInfo.getX(),
                    fakePlayerInfo.getY(),
                    fakePlayerInfo.getZ(),
                    fakePlayerInfo.getYaw(),
                    fakePlayerInfo.getPitch(),
                    fakePlayerInfo.getDimensionId(),
                    fakePlayerInfo.getGamemode(),
                    fakePlayerInfo.isIsflying(),
                    fakePlayerInfo.getTextures());
            if (fakePlayer != null) {
                fakePlayerInfo.setUuid(fakePlayer.getUUID());
                fakePlayerInfo.setFakePlayer(fakePlayer);
                WeTogether.fakePlayerInfos.put(fakePlayer.getUUID(), fakePlayerInfo);
            }
        });
    }
}
