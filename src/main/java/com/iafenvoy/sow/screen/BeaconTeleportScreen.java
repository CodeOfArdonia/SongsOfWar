package com.iafenvoy.sow.screen;

import com.iafenvoy.sow.data.BeaconData;
import com.iafenvoy.sow.network.payload.BeaconTeleportC2SPayload;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class BeaconTeleportScreen extends Screen {
    private static final ResourceLocation ARROW = ResourceLocation.tryBuild(ResourceLocation.DEFAULT_NAMESPACE, "textures/gui/recipe_book.png");
    private static final int COUNT_PER_PAGE = 5;
    private final BeaconData beaconData;
    private final List<BeaconData.SingleBeaconData> data;
    private final BlockPos pos;
    private final int maxPage;
    private final int page;

    public BeaconTeleportScreen(BeaconData beaconData, BlockPos pos, int page) {
        super(beaconData.get(pos).map(BeaconData.SingleBeaconData::name).orElse(Component.literal("")));
        this.beaconData = beaconData;
        this.data = new ArrayList<>(beaconData.getBeaconPos());
        this.data.removeIf(x -> x.pos().equals(pos));
        this.pos = pos;
        this.maxPage = (int) Math.ceil(1.0 * this.data.size() / COUNT_PER_PAGE) - 1;
        this.page = page;
    }

    @Override
    protected void init() {
        super.init();
        int middleX = this.width / 2, middleY = this.height / 2;
        this.addRenderableWidget(Button.builder(Component.literal("<"), button -> {
            assert this.minecraft != null;
            this.minecraft.setScreen(new BeaconTeleportScreen(this.beaconData, this.pos, this.page - 1));
        }).bounds(middleX - 44, middleY + 75, 14, 18).build()).visible = this.page > 0;
        this.addRenderableWidget(Button.builder(Component.literal(">"), button -> {
            assert this.minecraft != null;
            this.minecraft.setScreen(new BeaconTeleportScreen(this.beaconData, this.pos, this.page + 1));
        }).bounds(middleX + 30, middleY + 75, 14, 18).build()).visible = this.page < this.maxPage;
        for (int i = 0; i < COUNT_PER_PAGE; i++) {
            int index = this.page * COUNT_PER_PAGE + i;
            if (this.data.size() <= index) break;
            BeaconData.SingleBeaconData d = this.data.get(index);
            this.addRenderableWidget(Button.builder(d.name(), button -> {
                PacketDistributor.sendToServer(new BeaconTeleportC2SPayload(this.pos, d.pos()));
                this.onClose();
            }).bounds(middleX - 50, middleY + (i - 2) * 25, 100, 20).build());
        }
    }

    @Override
    public void tick() {
        super.tick();
        assert this.minecraft != null && this.minecraft.player != null;
        if (this.minecraft.player.blockPosition().distSqr(this.pos) > 10 * 10)
            this.onClose();
    }

    @Override
    public void render(@NotNull GuiGraphics context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredString(this.font, this.title, this.width / 2, this.height / 2 - 85, -1);
        context.drawCenteredString(this.font, Component.literal(String.format("x=%d y=%d z=%d", this.pos.getX(), this.pos.getY(), this.pos.getZ())), this.width / 2, this.height / 2 - 70, -1);
        context.drawCenteredString(this.font, Component.literal(String.format("%d/%d", this.page + 1, this.maxPage + 1)), this.width / 2, this.height / 2 + 80, -1);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
