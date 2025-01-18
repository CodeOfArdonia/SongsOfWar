package com.iafenvoy.sow.render.power.test;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class AggroBlastModel<T extends Entity> extends EntityModel<T> {
    private final ModelPart swirl1;
    private final ModelPart swirl2;
    private final ModelPart swirl3;
    private final ModelPart swirl4;
    private final ModelPart swirl5;
    private final ModelPart swirl7;
    private final ModelPart swirl6;
    private final ModelPart swirl9;
    private final ModelPart swirl8;

    public AggroBlastModel(ModelPart root) {
        this.swirl1 = root.getChild("swirl1");
        this.swirl2 = root.getChild("swirl2");
        this.swirl3 = root.getChild("swirl3");
        this.swirl4 = root.getChild("swirl4");
        this.swirl5 = root.getChild("swirl5");
        this.swirl7 = root.getChild("swirl7");
        this.swirl6 = root.getChild("swirl6");
        this.swirl9 = root.getChild("swirl9");
        this.swirl8 = root.getChild("swirl8");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData swirl1 = modelPartData.addChild("swirl1", ModelPartBuilder.create().uv(22, 44).cuboid(-0.5153F, -1.8813F, -1.5F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0153F, 8.8813F, -9.0F));

        ModelPartData cube_r1 = swirl1.addChild("cube_r1", ModelPartBuilder.create().uv(30, 85).cuboid(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.1492F, 0.4847F, 0.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r2 = swirl1.addChild("cube_r2", ModelPartBuilder.create().uv(78, 56).cuboid(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.1187F, -0.5153F, 0.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r3 = swirl1.addChild("cube_r3", ModelPartBuilder.create().uv(42, 79).cuboid(0.0F, -2.0F, -2.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.3508F, -0.3813F, 0.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r4 = swirl1.addChild("cube_r4", ModelPartBuilder.create().uv(26, 85).cuboid(0.0F, -2.0F, -2.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.3813F, 0.3508F, 0.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r5 = swirl1.addChild("cube_r5", ModelPartBuilder.create().uv(22, 85).cuboid(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.1187F, 0.4847F, 0.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r6 = swirl1.addChild("cube_r6", ModelPartBuilder.create().uv(78, 84).cuboid(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.3508F, 0.3508F, 0.5F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r7 = swirl1.addChild("cube_r7", ModelPartBuilder.create().uv(82, 68).cuboid(0.0F, -2.0F, -2.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.4847F, 0.1187F, 0.5F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r8 = swirl1.addChild("cube_r8", ModelPartBuilder.create().uv(46, 75).cuboid(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.4847F, -0.1492F, 0.5F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r9 = swirl1.addChild("cube_r9", ModelPartBuilder.create().uv(58, 67).cuboid(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.1492F, -0.5153F, 0.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r10 = swirl1.addChild("cube_r10", ModelPartBuilder.create().uv(58, 65).cuboid(0.0F, -2.0F, -2.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.3813F, -0.3813F, 0.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r11 = swirl1.addChild("cube_r11", ModelPartBuilder.create().uv(18, 62).cuboid(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.5153F, -0.1492F, 0.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl2 = modelPartData.addChild("swirl2", ModelPartBuilder.create().uv(3, 84).cuboid(-1.0F, -3.7321F, -2.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 8.7321F, -12.0F));

        ModelPartData cube_r12 = swirl2.addChild("cube_r12", ModelPartBuilder.create().uv(81, 82).cuboid(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.7321F, 0.0F, 1.0F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r13 = swirl2.addChild("cube_r13", ModelPartBuilder.create().uv(81, 79).cuboid(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, -0.866F, 1.0F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r14 = swirl2.addChild("cube_r14", ModelPartBuilder.create().uv(15, 84).cuboid(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-0.866F, -1.5F, 1.0F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r15 = swirl2.addChild("cube_r15", ModelPartBuilder.create().uv(59, 83).cuboid(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -0.866F, 1.0F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r16 = swirl2.addChild("cube_r16", ModelPartBuilder.create().uv(53, 83).cuboid(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.866F, -1.5F, 1.0F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r17 = swirl2.addChild("cube_r17", ModelPartBuilder.create().uv(71, 83).cuboid(-1.0F, 0.0F, -3.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, 0.866F, 1.0F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r18 = swirl2.addChild("cube_r18", ModelPartBuilder.create().uv(65, 83).cuboid(-1.0F, 0.0F, -3.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-0.866F, 1.5F, 1.0F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r19 = swirl2.addChild("cube_r19", ModelPartBuilder.create().uv(-3, 83).cuboid(-1.0F, 0.0F, -3.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.7321F, 1.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r20 = swirl2.addChild("cube_r20", ModelPartBuilder.create().uv(41, 83).cuboid(-1.0F, 0.0F, -3.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.866F, 1.5F, 1.0F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r21 = swirl2.addChild("cube_r21", ModelPartBuilder.create().uv(47, 83).cuboid(-1.0F, 0.0F, -3.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, 0.866F, 1.0F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r22 = swirl2.addChild("cube_r22", ModelPartBuilder.create().uv(9, 84).cuboid(-1.0F, 0.0F, -3.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(1.7321F, 0.0F, 1.0F, 0.0F, 0.0F, -1.5708F));

        ModelPartData swirl3 = modelPartData.addChild("swirl3", ModelPartBuilder.create().uv(50, 71).cuboid(-1.5F, -5.5981F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 8.5981F, -15.0F));

        ModelPartData cube_r23 = swirl3.addChild("cube_r23", ModelPartBuilder.create().uv(82, 74).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.366F, -3.366F, -1.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r24 = swirl3.addChild("cube_r24", ModelPartBuilder.create().uv(82, 65).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-2.866F, -2.2321F, -1.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r25 = swirl3.addChild("cube_r25", ModelPartBuilder.create().uv(82, 62).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-3.5981F, -0.5F, -1.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r26 = swirl3.addChild("cube_r26", ModelPartBuilder.create().uv(82, 59).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-3.366F, 1.366F, -1.5F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r27 = swirl3.addChild("cube_r27", ModelPartBuilder.create().uv(82, 56).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-2.2321F, 2.866F, -1.5F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r28 = swirl3.addChild("cube_r28", ModelPartBuilder.create().uv(34, 82).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 3.5981F, -1.5F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r29 = swirl3.addChild("cube_r29", ModelPartBuilder.create().uv(26, 82).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(1.366F, 3.366F, -1.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r30 = swirl3.addChild("cube_r30", ModelPartBuilder.create().uv(18, 82).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(2.866F, 2.2321F, -1.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r31 = swirl3.addChild("cube_r31", ModelPartBuilder.create().uv(82, 13).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(3.5981F, 0.5F, -1.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r32 = swirl3.addChild("cube_r32", ModelPartBuilder.create().uv(82, 10).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(3.366F, -1.366F, -1.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r33 = swirl3.addChild("cube_r33", ModelPartBuilder.create().uv(82, 77).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(2.2321F, -2.866F, -1.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl4 = modelPartData.addChild("swirl4", ModelPartBuilder.create().uv(78, -6).cuboid(-1.7514F, -7.8947F, -3.5385F, 4.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.2486F, 8.8947F, -19.4615F));

        ModelPartData cube_r34 = swirl4.addChild("cube_r34", ModelPartBuilder.create().uv(78, 3).cuboid(-2.0F, -4.0F, -4.0F, 4.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-3.2155F, -0.4306F, 0.4615F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r35 = swirl4.addChild("cube_r35", ModelPartBuilder.create().uv(78, 0).cuboid(-2.0F, -4.0F, -4.0F, 4.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-2.7514F, -2.1627F, 0.4615F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r36 = swirl4.addChild("cube_r36", ModelPartBuilder.create().uv(78, -3).cuboid(-2.0F, -4.0F, -4.0F, 4.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-1.4834F, -3.4306F, 0.4615F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r37 = swirl4.addChild("cube_r37", ModelPartBuilder.create().uv(18, 75).cuboid(-2.0F, -4.0F, -4.0F, 4.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(3.2486F, -2.1627F, 0.4615F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r38 = swirl4.addChild("cube_r38", ModelPartBuilder.create().uv(4, 78).cuboid(-2.0F, -4.0F, -4.0F, 4.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(1.9807F, -3.4306F, 0.4615F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r39 = swirl4.addChild("cube_r39", ModelPartBuilder.create().uv(68, 77).cuboid(-2.0F, 2.0F, -4.0F, 4.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-2.7514F, 1.3014F, 0.4615F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r40 = swirl4.addChild("cube_r40", ModelPartBuilder.create().uv(66, 52).cuboid(-2.0F, 2.0F, -3.0F, 4.0F, 2.0F, 6.0F, new Dilation(0.0F))
                .uv(58, 77).cuboid(-2.0F, 2.0F, -4.0F, 4.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-1.4834F, 2.5694F, 0.4615F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r41 = swirl4.addChild("cube_r41", ModelPartBuilder.create().uv(48, 77).cuboid(-2.0F, 2.0F, -4.0F, 4.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.2486F, 3.0335F, 0.4615F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r42 = swirl4.addChild("cube_r42", ModelPartBuilder.create().uv(38, 77).cuboid(-2.0F, 2.0F, -4.0F, 4.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(1.9807F, 2.5694F, 0.4615F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r43 = swirl4.addChild("cube_r43", ModelPartBuilder.create().uv(-6, 77).cuboid(-2.0F, 2.0F, -4.0F, 4.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(3.2486F, 1.3014F, 0.4615F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r44 = swirl4.addChild("cube_r44", ModelPartBuilder.create().uv(28, 75).cuboid(-2.0F, 2.0F, -4.0F, 4.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(3.7127F, -0.4306F, 0.4615F, 0.0F, 0.0F, -1.5708F));

        ModelPartData swirl5 = modelPartData.addChild("swirl5", ModelPartBuilder.create().uv(45, 77).cuboid(-2.4792F, -9.4079F, -2.0F, 5.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.0208F, 8.4079F, -24.5F));

        ModelPartData cube_r45 = swirl5.addChild("cube_r45", ModelPartBuilder.create().uv(77, 33).cuboid(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-8.8093F, -3.4438F, -1.0F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r46 = swirl5.addChild("cube_r46", ModelPartBuilder.create().uv(-3, 77).cuboid(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-5.9433F, -7.4079F, -1.0F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r47 = swirl5.addChild("cube_r47", ModelPartBuilder.create().uv(77, 30).cuboid(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-9.3093F, 1.4222F, -1.0F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r48 = swirl5.addChild("cube_r48", ModelPartBuilder.create().uv(77, 27).cuboid(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-7.3093F, 5.8864F, -1.0F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r49 = swirl5.addChild("cube_r49", ModelPartBuilder.create().uv(77, 24).cuboid(-4.0F, -2.0F, -1.0F, 5.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-3.3452F, 8.7524F, -1.0F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r50 = swirl5.addChild("cube_r50", ModelPartBuilder.create().uv(9, 78).cuboid(-4.0F, -3.0F, -1.0F, 5.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.4792F, 7.2524F, -1.0F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r51 = swirl5.addChild("cube_r51", ModelPartBuilder.create().uv(69, 77).cuboid(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(2.3869F, 7.0203F, -1.0F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r52 = swirl5.addChild("cube_r52", ModelPartBuilder.create().uv(57, 77).cuboid(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(5.6189F, 4.8864F, -1.0F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r53 = swirl5.addChild("cube_r53", ModelPartBuilder.create().uv(77, 21).cuboid(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(7.351F, 1.4222F, -1.0F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r54 = swirl5.addChild("cube_r54", ModelPartBuilder.create().uv(77, 18).cuboid(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(7.1189F, -2.4438F, -1.0F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r55 = swirl5.addChild("cube_r55", ModelPartBuilder.create().uv(77, 15).cuboid(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(4.9849F, -5.6758F, -1.0F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl7 = modelPartData.addChild("swirl7", ModelPartBuilder.create().uv(68, 50).cuboid(-3.0F, -11.1962F, -3.0F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 8.5981F, -29.0F));

        ModelPartData cube_r56 = swirl7.addChild("cube_r56", ModelPartBuilder.create().uv(74, 39).cuboid(-4.0F, -4.0F, 0.0F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-2.7321F, -6.7321F, -3.0F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r57 = swirl7.addChild("cube_r57", ModelPartBuilder.create().uv(74, 35).cuboid(-4.0F, -4.0F, 0.0F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-5.7321F, -4.4641F, -3.0F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r58 = swirl7.addChild("cube_r58", ModelPartBuilder.create().uv(28, 73).cuboid(-4.0F, -4.0F, 0.0F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-7.1962F, -1.0F, -3.0F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r59 = swirl7.addChild("cube_r59", ModelPartBuilder.create().uv(12, 73).cuboid(-4.0F, -4.0F, 0.0F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-6.7321F, 2.7321F, -3.0F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r60 = swirl7.addChild("cube_r60", ModelPartBuilder.create().uv(72, 68).cuboid(-4.0F, -4.0F, 0.0F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-4.4641F, 5.7321F, -3.0F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r61 = swirl7.addChild("cube_r61", ModelPartBuilder.create().uv(64, 72).cuboid(-4.0F, -4.0F, 0.0F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 7.1962F, -3.0F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r62 = swirl7.addChild("cube_r62", ModelPartBuilder.create().uv(48, 72).cuboid(-4.0F, -4.0F, 0.0F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(2.7321F, 6.7321F, -3.0F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r63 = swirl7.addChild("cube_r63", ModelPartBuilder.create().uv(-4, 72).cuboid(-4.0F, -4.0F, 0.0F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(5.7321F, 4.4641F, -3.0F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r64 = swirl7.addChild("cube_r64", ModelPartBuilder.create().uv(32, 69).cuboid(-4.0F, -4.0F, 0.0F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(7.1962F, 1.0F, -3.0F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r65 = swirl7.addChild("cube_r65", ModelPartBuilder.create().uv(16, 69).cuboid(-4.0F, -4.0F, 0.0F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(6.7321F, -2.7321F, -3.0F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r66 = swirl7.addChild("cube_r66", ModelPartBuilder.create().uv(56, 68).cuboid(-4.0F, -4.0F, 0.0F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(4.4641F, -5.7321F, -3.0F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl6 = modelPartData.addChild("swirl6", ModelPartBuilder.create().uv(55, 13).cuboid(-3.3925F, -15.9804F, -3.6154F, 8.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.3589F, 9.0856F, -34.9231F));

        ModelPartData cube_r67 = swirl6.addChild("cube_r67", ModelPartBuilder.create().uv(67, 43).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-6.3207F, -1.0522F, 0.3846F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r68 = swirl6.addChild("cube_r68", ModelPartBuilder.create().uv(-5, 65).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-5.3925F, -4.5163F, 0.3846F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r69 = swirl6.addChild("cube_r69", ModelPartBuilder.create().uv(39, 55).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-2.8566F, -7.0522F, 0.3846F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r70 = swirl6.addChild("cube_r70", ModelPartBuilder.create().uv(55, 27).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(6.6075F, -4.5163F, 0.3846F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r71 = swirl6.addChild("cube_r71", ModelPartBuilder.create().uv(55, 20).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(4.0716F, -7.0522F, 0.3846F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r72 = swirl6.addChild("cube_r72", ModelPartBuilder.create().uv(35, 62).cuboid(-4.0F, 4.0F, -4.0F, 8.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-5.3925F, 2.4119F, 0.3846F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r73 = swirl6.addChild("cube_r73", ModelPartBuilder.create().uv(54, 33).cuboid(-4.0F, 6.0F, -2.0F, 8.0F, 2.0F, 6.0F, new Dilation(0.0F))
                .uv(15, 62).cuboid(-4.0F, 4.0F, -4.0F, 8.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-2.8566F, 4.9478F, 0.3846F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r74 = swirl6.addChild("cube_r74", ModelPartBuilder.create().uv(59, 61).cuboid(-4.0F, 4.0F, -4.0F, 8.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.6075F, 5.876F, 0.3846F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r75 = swirl6.addChild("cube_r75", ModelPartBuilder.create().uv(59, 55).cuboid(-4.0F, 4.0F, -4.0F, 8.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(4.0716F, 4.9478F, 0.3846F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r76 = swirl6.addChild("cube_r76", ModelPartBuilder.create().uv(-5, 59).cuboid(-4.0F, 4.0F, -4.0F, 8.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(6.6075F, 2.4119F, 0.3846F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r77 = swirl6.addChild("cube_r77", ModelPartBuilder.create().uv(19, 55).cuboid(-4.0F, 3.0F, -4.0F, 8.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(7.5357F, -1.0522F, 0.3846F, 0.0F, 0.0F, -1.5708F));

        ModelPartData swirl9 = modelPartData.addChild("swirl9", ModelPartBuilder.create().uv(26, 38).cuboid(-5.0F, -18.6603F, -3.0F, 10.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 8.3301F, -41.0F));

        ModelPartData cube_r78 = swirl9.addChild("cube_r78", ModelPartBuilder.create().uv(56, 2).cuboid(-8.0F, -4.0F, -2.0F, 10.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-17.6603F, -6.7321F, -1.0F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r79 = swirl9.addChild("cube_r79", ModelPartBuilder.create().uv(56, -4).cuboid(-8.0F, -4.0F, -2.0F, 10.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-11.9282F, -14.6603F, -1.0F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r80 = swirl9.addChild("cube_r80", ModelPartBuilder.create().uv(-4, 54).cuboid(-8.0F, -4.0F, -2.0F, 10.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-18.6603F, 3.0F, -1.0F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r81 = swirl9.addChild("cube_r81", ModelPartBuilder.create().uv(44, 50).cuboid(-8.0F, -4.0F, -2.0F, 10.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-14.6603F, 11.9282F, -1.0F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r82 = swirl9.addChild("cube_r82", ModelPartBuilder.create().uv(50, 38).cuboid(-8.0F, -4.0F, -2.0F, 10.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-6.7321F, 17.6603F, -1.0F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r83 = swirl9.addChild("cube_r83", ModelPartBuilder.create().uv(20, 50).cuboid(-8.0F, -4.0F, -2.0F, 10.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 14.6603F, -1.0F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r84 = swirl9.addChild("cube_r84", ModelPartBuilder.create().uv(-4, 48).cuboid(-8.0F, -4.0F, -2.0F, 10.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(4.7321F, 14.1962F, -1.0F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r85 = swirl9.addChild("cube_r85", ModelPartBuilder.create().uv(44, 44).cuboid(-8.0F, -4.0F, -2.0F, 10.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(11.1962F, 9.9282F, -1.0F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r86 = swirl9.addChild("cube_r86", ModelPartBuilder.create().uv(20, 44).cuboid(-8.0F, -4.0F, -2.0F, 10.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(14.6603F, 3.0F, -1.0F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r87 = swirl9.addChild("cube_r87", ModelPartBuilder.create().uv(-4, 42).cuboid(-8.0F, -4.0F, -2.0F, 10.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(14.1962F, -4.7321F, -1.0F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r88 = swirl9.addChild("cube_r88", ModelPartBuilder.create().uv(56, 8).cuboid(-8.0F, -4.0F, -2.0F, 10.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(9.9282F, -11.1962F, -1.0F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl8 = modelPartData.addChild("swirl8", ModelPartBuilder.create().uv(-2, -2).cuboid(-6.0F, -22.5478F, -2.5F, 12.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.7536F, -46.5F));

        ModelPartData cube_r89 = swirl8.addChild("cube_r89", ModelPartBuilder.create().uv(-2, 22).cuboid(-8.0F, -8.0F, 1.0F, 12.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-5.4641F, -13.6196F, -3.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r90 = swirl8.addChild("cube_r90", ModelPartBuilder.create().uv(-2, 14).cuboid(-8.0F, -8.0F, 1.0F, 12.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-11.4641F, -9.0837F, -3.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r91 = swirl8.addChild("cube_r91", ModelPartBuilder.create().uv(-2, 37).cuboid(-8.0F, -8.0F, 1.0F, 12.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-14.3923F, -2.1555F, -3.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r92 = swirl8.addChild("cube_r92", ModelPartBuilder.create().uv(28, 33).cuboid(-8.0F, -8.0F, 1.0F, 12.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-13.4641F, 5.3086F, -3.5F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r93 = swirl8.addChild("cube_r93", ModelPartBuilder.create().uv(-2, 30).cuboid(-8.0F, -8.0F, 1.0F, 12.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-8.9282F, 11.3086F, -3.5F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r94 = swirl8.addChild("cube_r94", ModelPartBuilder.create().uv(28, 26).cuboid(-8.0F, -8.0F, 1.0F, 12.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 14.2368F, -3.5F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r95 = swirl8.addChild("cube_r95", ModelPartBuilder.create().uv(28, 19).cuboid(-8.0F, -8.0F, 1.0F, 12.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(5.4641F, 13.3086F, -3.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r96 = swirl8.addChild("cube_r96", ModelPartBuilder.create().uv(28, 12).cuboid(-8.0F, -8.0F, 1.0F, 12.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(11.4641F, 8.7727F, -3.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r97 = swirl8.addChild("cube_r97", ModelPartBuilder.create().uv(28, 5).cuboid(-8.0F, -8.0F, 1.0F, 12.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(14.3923F, 1.8445F, -3.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r98 = swirl8.addChild("cube_r98", ModelPartBuilder.create().uv(28, -2).cuboid(-8.0F, -8.0F, 1.0F, 12.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(13.4641F, -5.6196F, -3.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r99 = swirl8.addChild("cube_r99", ModelPartBuilder.create().uv(-2, 6).cuboid(-8.0F, -8.0F, 1.0F, 12.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(8.9282F, -11.6196F, -3.5F, 0.0F, 0.0F, 0.5236F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        this.swirl1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl3.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl4.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl5.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl7.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl6.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl9.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl8.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}