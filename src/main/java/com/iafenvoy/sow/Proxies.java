package com.iafenvoy.sow;

import com.iafenvoy.sow.compat.reforgedstone.ReforgedStoneProxy;
import com.iafenvoy.sow.data.ArdoniNameProxy;
import com.iafenvoy.sow.world.sound.SongCubeSoundManager;

public final class Proxies {
    public static SongCubeSoundManager songCubeSoundManager = SongCubeSoundManager.Empty.INSTANCE;
    public static ArdoniNameProxy ardoniNameProxy = ArdoniNameProxy.Empty.INSTANCE;
    public static ReforgedStoneProxy reforgedStoneProxy = ReforgedStoneProxy.Empty.INSTANCE;
}
