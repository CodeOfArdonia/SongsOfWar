package com.iafenvoy.sow.render.power.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

@Environment(EnvType.CLIENT)
public class SphereModel<T extends Entity> extends EntityModel<T> {
    private final ModelPart root;

    public SphereModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        ModelPartData bottom_r1 = root.addChild("bottom_r1", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, -1.0F, -8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)).uv(0, 2).cuboid(-2.0F, -1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -1.0F, 1.5708F, 0.0F, 0.0F));
        ModelPartData single1 = root.addChild("single1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        ModelPartData bone2 = single1.addChild("bone2", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r1 = bone2.addChild("cube_r1", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r2 = bone2.addChild("cube_r2", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r3 = bone2.addChild("cube_r3", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData bone3 = single1.addChild("bone3", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 1.0F, -1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r4 = bone3.addChild("cube_r4", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        ModelPartData cube_r5 = bone3.addChild("cube_r5", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r6 = bone3.addChild("cube_r6", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r7 = bone3.addChild("cube_r7", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, -1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData single2 = root.addChild("single2", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.0F));
        ModelPartData bone4 = single2.addChild("bone4", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r8 = bone4.addChild("cube_r8", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r9 = bone4.addChild("cube_r9", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r10 = bone4.addChild("cube_r10", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData bone5 = single2.addChild("bone5", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 1.0F, -1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r11 = bone5.addChild("cube_r11", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        ModelPartData cube_r12 = bone5.addChild("cube_r12", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r13 = bone5.addChild("cube_r13", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r14 = bone5.addChild("cube_r14", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, -1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData single3 = root.addChild("single3", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
        ModelPartData bone6 = single3.addChild("bone6", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r15 = bone6.addChild("cube_r15", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r16 = bone6.addChild("cube_r16", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r17 = bone6.addChild("cube_r17", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData bone7 = single3.addChild("bone7", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 1.0F, -1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r18 = bone7.addChild("cube_r18", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        ModelPartData cube_r19 = bone7.addChild("cube_r19", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r20 = bone7.addChild("cube_r20", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r21 = bone7.addChild("cube_r21", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, -1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData single4 = root.addChild("single4", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.1781F, 0.0F));
        ModelPartData bone8 = single4.addChild("bone8", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r22 = bone8.addChild("cube_r22", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r23 = bone8.addChild("cube_r23", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r24 = bone8.addChild("cube_r24", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData bone9 = single4.addChild("bone9", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 1.0F, -1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r25 = bone9.addChild("cube_r25", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        ModelPartData cube_r26 = bone9.addChild("cube_r26", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r27 = bone9.addChild("cube_r27", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r28 = bone9.addChild("cube_r28", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, -1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData single5 = root.addChild("single5", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
        ModelPartData bone10 = single5.addChild("bone10", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r29 = bone10.addChild("cube_r29", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r30 = bone10.addChild("cube_r30", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r31 = bone10.addChild("cube_r31", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData bone11 = single5.addChild("bone11", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 1.0F, -1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r32 = bone11.addChild("cube_r32", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        ModelPartData cube_r33 = bone11.addChild("cube_r33", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r34 = bone11.addChild("cube_r34", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r35 = bone11.addChild("cube_r35", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, -1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData single6 = root.addChild("single6", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.9635F, 0.0F));
        ModelPartData bone12 = single6.addChild("bone12", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r36 = bone12.addChild("cube_r36", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r37 = bone12.addChild("cube_r37", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r38 = bone12.addChild("cube_r38", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData bone13 = single6.addChild("bone13", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 1.0F, -1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r39 = bone13.addChild("cube_r39", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        ModelPartData cube_r40 = bone13.addChild("cube_r40", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r41 = bone13.addChild("cube_r41", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r42 = bone13.addChild("cube_r42", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, -1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData single7 = root.addChild("single7", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -2.3562F, 0.0F));
        ModelPartData bone14 = single7.addChild("bone14", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r43 = bone14.addChild("cube_r43", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r44 = bone14.addChild("cube_r44", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r45 = bone14.addChild("cube_r45", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData bone15 = single7.addChild("bone15", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 1.0F, -1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r46 = bone15.addChild("cube_r46", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        ModelPartData cube_r47 = bone15.addChild("cube_r47", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r48 = bone15.addChild("cube_r48", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r49 = bone15.addChild("cube_r49", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, -1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData single8 = root.addChild("single8", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -2.7489F, 0.0F));
        ModelPartData bone16 = single8.addChild("bone16", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r50 = bone16.addChild("cube_r50", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r51 = bone16.addChild("cube_r51", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r52 = bone16.addChild("cube_r52", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData bone17 = single8.addChild("bone17", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 1.0F, -1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r53 = bone17.addChild("cube_r53", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        ModelPartData cube_r54 = bone17.addChild("cube_r54", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r55 = bone17.addChild("cube_r55", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r56 = bone17.addChild("cube_r56", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, -1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData single9 = root.addChild("single9", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
        ModelPartData bone18 = single9.addChild("bone18", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r57 = bone18.addChild("cube_r57", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r58 = bone18.addChild("cube_r58", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r59 = bone18.addChild("cube_r59", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData bone19 = single9.addChild("bone19", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 1.0F, -1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r60 = bone19.addChild("cube_r60", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        ModelPartData cube_r61 = bone19.addChild("cube_r61", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r62 = bone19.addChild("cube_r62", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r63 = bone19.addChild("cube_r63", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, -1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData single10 = root.addChild("single10", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 2.7489F, 0.0F));
        ModelPartData bone20 = single10.addChild("bone20", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r64 = bone20.addChild("cube_r64", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r65 = bone20.addChild("cube_r65", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r66 = bone20.addChild("cube_r66", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData bone21 = single10.addChild("bone21", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 1.0F, -1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r67 = bone21.addChild("cube_r67", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        ModelPartData cube_r68 = bone21.addChild("cube_r68", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r69 = bone21.addChild("cube_r69", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r70 = bone21.addChild("cube_r70", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, -1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData single11 = root.addChild("single11", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 2.3562F, 0.0F));
        ModelPartData bone22 = single11.addChild("bone22", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r71 = bone22.addChild("cube_r71", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r72 = bone22.addChild("cube_r72", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r73 = bone22.addChild("cube_r73", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData bone23 = single11.addChild("bone23", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 1.0F, -1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r74 = bone23.addChild("cube_r74", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        ModelPartData cube_r75 = bone23.addChild("cube_r75", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r76 = bone23.addChild("cube_r76", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r77 = bone23.addChild("cube_r77", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, -1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData single12 = root.addChild("single12", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.9635F, 0.0F));
        ModelPartData bone24 = single12.addChild("bone24", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r78 = bone24.addChild("cube_r78", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r79 = bone24.addChild("cube_r79", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r80 = bone24.addChild("cube_r80", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData bone25 = single12.addChild("bone25", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 1.0F, -1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r81 = bone25.addChild("cube_r81", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        ModelPartData cube_r82 = bone25.addChild("cube_r82", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r83 = bone25.addChild("cube_r83", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r84 = bone25.addChild("cube_r84", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, -1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData single13 = root.addChild("single13", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        ModelPartData bone26 = single13.addChild("bone26", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r85 = bone26.addChild("cube_r85", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r86 = bone26.addChild("cube_r86", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r87 = bone26.addChild("cube_r87", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData bone27 = single13.addChild("bone27", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 1.0F, -1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r88 = bone27.addChild("cube_r88", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        ModelPartData cube_r89 = bone27.addChild("cube_r89", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r90 = bone27.addChild("cube_r90", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r91 = bone27.addChild("cube_r91", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, -1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData single14 = root.addChild("single14", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData bone28 = single14.addChild("bone28", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r92 = bone28.addChild("cube_r92", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r93 = bone28.addChild("cube_r93", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r94 = bone28.addChild("cube_r94", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData bone29 = single14.addChild("bone29", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 1.0F, -1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r95 = bone29.addChild("cube_r95", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        ModelPartData cube_r96 = bone29.addChild("cube_r96", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r97 = bone29.addChild("cube_r97", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r98 = bone29.addChild("cube_r98", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, -1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData single15 = root.addChild("single15", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData bone30 = single15.addChild("bone30", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r99 = bone30.addChild("cube_r99", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r100 = bone30.addChild("cube_r100", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r101 = bone30.addChild("cube_r101", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData bone31 = single15.addChild("bone31", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 1.0F, -1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r102 = bone31.addChild("cube_r102", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        ModelPartData cube_r103 = bone31.addChild("cube_r103", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r104 = bone31.addChild("cube_r104", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r105 = bone31.addChild("cube_r105", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, -1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData single16 = root.addChild("single16", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData bone32 = single16.addChild("bone32", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r106 = bone32.addChild("cube_r106", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r107 = bone32.addChild("cube_r107", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r108 = bone32.addChild("cube_r108", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData bone33 = single16.addChild("bone33", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 1.0F, -1.5708F, 0.0F, 0.0F));
        ModelPartData cube_r109 = bone33.addChild("cube_r109", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        ModelPartData cube_r110 = bone33.addChild("cube_r110", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
        ModelPartData cube_r111 = bone33.addChild("cube_r111", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, 0.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
        ModelPartData cube_r112 = bone33.addChild("cube_r112", ModelPartBuilder.create().uv(0, 2).cuboid(-2.0F, -1.0F, 8.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        return TexturedModelData.of(modelData, 16, 16);
    }

    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        this.root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

}
