package com.iafenvoy.sow.render.power.test;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class AggroVortexModel extends EntityModel<Entity> {
    private final ModelPart swirl35;
    private final ModelPart swirl34;
    private final ModelPart swirl33;
    private final ModelPart swirl31;
    private final ModelPart swirl30;
    private final ModelPart swirl29;
    private final ModelPart swirl23;
    private final ModelPart swirl22;
    private final ModelPart swirl21;
    private final ModelPart swirl32;
    private final ModelPart swirl20;
    private final ModelPart swirl19;
    private final ModelPart swirl6;
    private final ModelPart swirl2;
    private final ModelPart swirl15;
    private final ModelPart swirl16;
    private final ModelPart swirl24;
    private final ModelPart swirl17;
    private final ModelPart swirl18;
    private final ModelPart swirl28;
    private final ModelPart swirl10;
    private final ModelPart swirl14;
    private final ModelPart swirl25;
    private final ModelPart swirl7;
    private final ModelPart swirl8;
    private final ModelPart swirl26;
    private final ModelPart swirl27;
    private final ModelPart swirl9;
    private final ModelPart swirl11;
    private final ModelPart swirl13;
    private final ModelPart swirl3;
    private final ModelPart swirl12;
    private final ModelPart swirl4;
    private final ModelPart swirl5;

    public AggroVortexModel(ModelPart root) {
        this.swirl35 = root.getChild("swirl35");
        this.swirl34 = root.getChild("swirl34");
        this.swirl33 = root.getChild("swirl33");
        this.swirl31 = root.getChild("swirl31");
        this.swirl30 = root.getChild("swirl30");
        this.swirl29 = root.getChild("swirl29");
        this.swirl23 = root.getChild("swirl23");
        this.swirl22 = root.getChild("swirl22");
        this.swirl21 = root.getChild("swirl21");
        this.swirl32 = root.getChild("swirl32");
        this.swirl20 = root.getChild("swirl20");
        this.swirl19 = root.getChild("swirl19");
        this.swirl6 = root.getChild("swirl6");
        this.swirl2 = root.getChild("swirl2");
        this.swirl15 = root.getChild("swirl15");
        this.swirl16 = root.getChild("swirl16");
        this.swirl24 = root.getChild("swirl24");
        this.swirl17 = root.getChild("swirl17");
        this.swirl18 = root.getChild("swirl18");
        this.swirl28 = root.getChild("swirl28");
        this.swirl10 = root.getChild("swirl10");
        this.swirl14 = root.getChild("swirl14");
        this.swirl25 = root.getChild("swirl25");
        this.swirl7 = root.getChild("swirl7");
        this.swirl8 = root.getChild("swirl8");
        this.swirl26 = root.getChild("swirl26");
        this.swirl27 = root.getChild("swirl27");
        this.swirl9 = root.getChild("swirl9");
        this.swirl11 = root.getChild("swirl11");
        this.swirl13 = root.getChild("swirl13");
        this.swirl3 = root.getChild("swirl3");
        this.swirl12 = root.getChild("swirl12");
        this.swirl4 = root.getChild("swirl4");
        this.swirl5 = root.getChild("swirl5");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData swirl35 = modelPartData.addChild("swirl35", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -3.7321F, -7.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.7321F, -2.5F));

        ModelPartData cube_r1 = swirl35.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r2 = swirl35.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, -0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r3 = swirl35.addChild("cube_r3", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.866F, -1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r4 = swirl35.addChild("cube_r4", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r5 = swirl35.addChild("cube_r5", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.866F, -1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r6 = swirl35.addChild("cube_r6", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.5F, 0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r7 = swirl35.addChild("cube_r7", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.866F, 1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r8 = swirl35.addChild("cube_r8", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 1.7321F, -6.5F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r9 = swirl35.addChild("cube_r9", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.866F, 1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r10 = swirl35.addChild("cube_r10", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.5F, 0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r11 = swirl35.addChild("cube_r11", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData swirl34 = modelPartData.addChild("swirl34", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.866F, -7.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.866F, -4.0F));

        ModelPartData cube_r12 = swirl34.addChild("cube_r12", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r13 = swirl34.addChild("cube_r13", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r14 = swirl34.addChild("cube_r14", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r15 = swirl34.addChild("cube_r15", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r16 = swirl34.addChild("cube_r16", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r17 = swirl34.addChild("cube_r17", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r18 = swirl34.addChild("cube_r18", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.134F, -7.5F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r19 = swirl34.addChild("cube_r19", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -0.134F, -7.5F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r20 = swirl34.addChild("cube_r20", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r21 = swirl34.addChild("cube_r21", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r22 = swirl34.addChild("cube_r22", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -0.134F, -7.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl33 = modelPartData.addChild("swirl33", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.866F, -7.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.866F, -6.0F));

        ModelPartData cube_r23 = swirl33.addChild("cube_r23", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r24 = swirl33.addChild("cube_r24", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r25 = swirl33.addChild("cube_r25", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r26 = swirl33.addChild("cube_r26", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r27 = swirl33.addChild("cube_r27", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r28 = swirl33.addChild("cube_r28", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r29 = swirl33.addChild("cube_r29", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.134F, -7.5F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r30 = swirl33.addChild("cube_r30", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -0.134F, -7.5F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r31 = swirl33.addChild("cube_r31", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r32 = swirl33.addChild("cube_r32", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r33 = swirl33.addChild("cube_r33", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -0.134F, -7.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl31 = modelPartData.addChild("swirl31", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.866F, -7.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.866F, -8.0F));

        ModelPartData cube_r34 = swirl31.addChild("cube_r34", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r35 = swirl31.addChild("cube_r35", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r36 = swirl31.addChild("cube_r36", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r37 = swirl31.addChild("cube_r37", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r38 = swirl31.addChild("cube_r38", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r39 = swirl31.addChild("cube_r39", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r40 = swirl31.addChild("cube_r40", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.134F, -7.5F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r41 = swirl31.addChild("cube_r41", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -0.134F, -7.5F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r42 = swirl31.addChild("cube_r42", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r43 = swirl31.addChild("cube_r43", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r44 = swirl31.addChild("cube_r44", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -0.134F, -7.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl30 = modelPartData.addChild("swirl30", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.866F, -7.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.866F, -10.0F));

        ModelPartData cube_r45 = swirl30.addChild("cube_r45", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r46 = swirl30.addChild("cube_r46", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r47 = swirl30.addChild("cube_r47", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r48 = swirl30.addChild("cube_r48", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r49 = swirl30.addChild("cube_r49", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r50 = swirl30.addChild("cube_r50", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r51 = swirl30.addChild("cube_r51", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.134F, -7.5F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r52 = swirl30.addChild("cube_r52", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -0.134F, -7.5F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r53 = swirl30.addChild("cube_r53", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r54 = swirl30.addChild("cube_r54", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r55 = swirl30.addChild("cube_r55", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -0.134F, -7.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl29 = modelPartData.addChild("swirl29", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -3.7321F, -7.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.7321F, -11.5F));

        ModelPartData cube_r56 = swirl29.addChild("cube_r56", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r57 = swirl29.addChild("cube_r57", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, -0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r58 = swirl29.addChild("cube_r58", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.866F, -1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r59 = swirl29.addChild("cube_r59", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r60 = swirl29.addChild("cube_r60", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.866F, -1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r61 = swirl29.addChild("cube_r61", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.5F, 0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r62 = swirl29.addChild("cube_r62", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.866F, 1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r63 = swirl29.addChild("cube_r63", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 1.7321F, -6.5F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r64 = swirl29.addChild("cube_r64", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.866F, 1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r65 = swirl29.addChild("cube_r65", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.5F, 0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r66 = swirl29.addChild("cube_r66", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData swirl23 = modelPartData.addChild("swirl23", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -3.7321F, -7.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.7321F, -13.5F));

        ModelPartData cube_r67 = swirl23.addChild("cube_r67", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r68 = swirl23.addChild("cube_r68", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, -0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r69 = swirl23.addChild("cube_r69", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.866F, -1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r70 = swirl23.addChild("cube_r70", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r71 = swirl23.addChild("cube_r71", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.866F, -1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r72 = swirl23.addChild("cube_r72", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.5F, 0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r73 = swirl23.addChild("cube_r73", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.866F, 1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r74 = swirl23.addChild("cube_r74", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 1.7321F, -6.5F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r75 = swirl23.addChild("cube_r75", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.866F, 1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r76 = swirl23.addChild("cube_r76", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.5F, 0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r77 = swirl23.addChild("cube_r77", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData swirl22 = modelPartData.addChild("swirl22", ModelPartBuilder.create().uv(-1, 0).cuboid(-1.5F, -5.5981F, -7.5F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.5981F, -15.0F));

        ModelPartData cube_r78 = swirl22.addChild("cube_r78", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.366F, -3.366F, -7.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r79 = swirl22.addChild("cube_r79", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.866F, -2.2321F, -7.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r80 = swirl22.addChild("cube_r80", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.5981F, -0.5F, -7.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r81 = swirl22.addChild("cube_r81", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.366F, 1.366F, -7.5F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r82 = swirl22.addChild("cube_r82", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.2321F, 2.866F, -7.5F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r83 = swirl22.addChild("cube_r83", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 3.5981F, -7.5F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r84 = swirl22.addChild("cube_r84", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.366F, 3.366F, -7.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r85 = swirl22.addChild("cube_r85", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.866F, 2.2321F, -7.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r86 = swirl22.addChild("cube_r86", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.5981F, 0.5F, -7.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r87 = swirl22.addChild("cube_r87", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.366F, -1.366F, -7.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r88 = swirl22.addChild("cube_r88", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.2321F, -2.866F, -7.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl21 = modelPartData.addChild("swirl21", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -3.7321F, -7.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.7321F, -16.5F));

        ModelPartData cube_r89 = swirl21.addChild("cube_r89", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r90 = swirl21.addChild("cube_r90", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, -0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r91 = swirl21.addChild("cube_r91", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.866F, -1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r92 = swirl21.addChild("cube_r92", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r93 = swirl21.addChild("cube_r93", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.866F, -1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r94 = swirl21.addChild("cube_r94", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.5F, 0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r95 = swirl21.addChild("cube_r95", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.866F, 1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r96 = swirl21.addChild("cube_r96", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 1.7321F, -6.5F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r97 = swirl21.addChild("cube_r97", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.866F, 1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r98 = swirl21.addChild("cube_r98", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.5F, 0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r99 = swirl21.addChild("cube_r99", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData swirl32 = modelPartData.addChild("swirl32", ModelPartBuilder.create().uv(-1, 0).cuboid(-1.5F, -5.5981F, -18.5F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.5981F, -7.0F));

        ModelPartData cube_r100 = swirl32.addChild("cube_r100", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.366F, -3.366F, -18.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r101 = swirl32.addChild("cube_r101", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.866F, -2.2321F, -18.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r102 = swirl32.addChild("cube_r102", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.5981F, -0.5F, -18.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r103 = swirl32.addChild("cube_r103", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.366F, 1.366F, -18.5F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r104 = swirl32.addChild("cube_r104", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.2321F, 2.866F, -18.5F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r105 = swirl32.addChild("cube_r105", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 3.5981F, -18.5F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r106 = swirl32.addChild("cube_r106", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.366F, 3.366F, -18.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r107 = swirl32.addChild("cube_r107", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.866F, 2.2321F, -18.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r108 = swirl32.addChild("cube_r108", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.5981F, 0.5F, -18.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r109 = swirl32.addChild("cube_r109", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.366F, -1.366F, -18.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r110 = swirl32.addChild("cube_r110", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.2321F, -2.866F, -18.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl20 = modelPartData.addChild("swirl20", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -3.7321F, -7.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.7321F, -19.5F));

        ModelPartData cube_r111 = swirl20.addChild("cube_r111", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r112 = swirl20.addChild("cube_r112", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, -0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r113 = swirl20.addChild("cube_r113", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.866F, -1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r114 = swirl20.addChild("cube_r114", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r115 = swirl20.addChild("cube_r115", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.866F, -1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r116 = swirl20.addChild("cube_r116", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.5F, 0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r117 = swirl20.addChild("cube_r117", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.866F, 1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r118 = swirl20.addChild("cube_r118", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 1.7321F, -6.5F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r119 = swirl20.addChild("cube_r119", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.866F, 1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r120 = swirl20.addChild("cube_r120", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.5F, 0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r121 = swirl20.addChild("cube_r121", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData swirl19 = modelPartData.addChild("swirl19", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -3.7321F, -7.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.7321F, -21.5F));

        ModelPartData cube_r122 = swirl19.addChild("cube_r122", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r123 = swirl19.addChild("cube_r123", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, -0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r124 = swirl19.addChild("cube_r124", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.866F, -1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r125 = swirl19.addChild("cube_r125", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r126 = swirl19.addChild("cube_r126", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.866F, -1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r127 = swirl19.addChild("cube_r127", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.5F, 0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r128 = swirl19.addChild("cube_r128", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.866F, 1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r129 = swirl19.addChild("cube_r129", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 1.7321F, -6.5F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r130 = swirl19.addChild("cube_r130", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.866F, 1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r131 = swirl19.addChild("cube_r131", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.5F, 0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r132 = swirl19.addChild("cube_r132", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData swirl6 = modelPartData.addChild("swirl6", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -3.7321F, -7.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.7321F, -23.5F));

        ModelPartData cube_r133 = swirl6.addChild("cube_r133", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r134 = swirl6.addChild("cube_r134", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, -0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r135 = swirl6.addChild("cube_r135", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.866F, -1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r136 = swirl6.addChild("cube_r136", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r137 = swirl6.addChild("cube_r137", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.866F, -1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r138 = swirl6.addChild("cube_r138", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.5F, 0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r139 = swirl6.addChild("cube_r139", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.866F, 1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r140 = swirl6.addChild("cube_r140", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 1.7321F, -6.5F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r141 = swirl6.addChild("cube_r141", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.866F, 1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r142 = swirl6.addChild("cube_r142", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.5F, 0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r143 = swirl6.addChild("cube_r143", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData swirl2 = modelPartData.addChild("swirl2", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.866F, -7.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.866F, -25.0F));

        ModelPartData cube_r144 = swirl2.addChild("cube_r144", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r145 = swirl2.addChild("cube_r145", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r146 = swirl2.addChild("cube_r146", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r147 = swirl2.addChild("cube_r147", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r148 = swirl2.addChild("cube_r148", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r149 = swirl2.addChild("cube_r149", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r150 = swirl2.addChild("cube_r150", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.134F, -7.5F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r151 = swirl2.addChild("cube_r151", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -0.134F, -7.5F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r152 = swirl2.addChild("cube_r152", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r153 = swirl2.addChild("cube_r153", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r154 = swirl2.addChild("cube_r154", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -0.134F, -7.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl15 = modelPartData.addChild("swirl15", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.866F, -7.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.866F, -27.0F));

        ModelPartData cube_r155 = swirl15.addChild("cube_r155", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r156 = swirl15.addChild("cube_r156", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r157 = swirl15.addChild("cube_r157", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r158 = swirl15.addChild("cube_r158", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r159 = swirl15.addChild("cube_r159", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r160 = swirl15.addChild("cube_r160", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r161 = swirl15.addChild("cube_r161", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.134F, -7.5F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r162 = swirl15.addChild("cube_r162", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -0.134F, -7.5F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r163 = swirl15.addChild("cube_r163", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r164 = swirl15.addChild("cube_r164", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r165 = swirl15.addChild("cube_r165", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -0.134F, -7.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl16 = modelPartData.addChild("swirl16", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.866F, -7.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.866F, -29.0F));

        ModelPartData cube_r166 = swirl16.addChild("cube_r166", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r167 = swirl16.addChild("cube_r167", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r168 = swirl16.addChild("cube_r168", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r169 = swirl16.addChild("cube_r169", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r170 = swirl16.addChild("cube_r170", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r171 = swirl16.addChild("cube_r171", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r172 = swirl16.addChild("cube_r172", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.134F, -7.5F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r173 = swirl16.addChild("cube_r173", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -0.134F, -7.5F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r174 = swirl16.addChild("cube_r174", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r175 = swirl16.addChild("cube_r175", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r176 = swirl16.addChild("cube_r176", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -0.134F, -7.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl24 = modelPartData.addChild("swirl24", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -3.7321F, -7.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.7321F, -30.5F));

        ModelPartData cube_r177 = swirl24.addChild("cube_r177", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r178 = swirl24.addChild("cube_r178", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, -0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r179 = swirl24.addChild("cube_r179", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.866F, -1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r180 = swirl24.addChild("cube_r180", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r181 = swirl24.addChild("cube_r181", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.866F, -1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r182 = swirl24.addChild("cube_r182", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.5F, 0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r183 = swirl24.addChild("cube_r183", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.866F, 1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r184 = swirl24.addChild("cube_r184", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 1.7321F, -6.5F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r185 = swirl24.addChild("cube_r185", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.866F, 1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r186 = swirl24.addChild("cube_r186", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.5F, 0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r187 = swirl24.addChild("cube_r187", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData swirl17 = modelPartData.addChild("swirl17", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.866F, -7.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.866F, -32.0F));

        ModelPartData cube_r188 = swirl17.addChild("cube_r188", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r189 = swirl17.addChild("cube_r189", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r190 = swirl17.addChild("cube_r190", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r191 = swirl17.addChild("cube_r191", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r192 = swirl17.addChild("cube_r192", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r193 = swirl17.addChild("cube_r193", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r194 = swirl17.addChild("cube_r194", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.134F, -7.5F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r195 = swirl17.addChild("cube_r195", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -0.134F, -7.5F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r196 = swirl17.addChild("cube_r196", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r197 = swirl17.addChild("cube_r197", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r198 = swirl17.addChild("cube_r198", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -0.134F, -7.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl18 = modelPartData.addChild("swirl18", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.866F, -7.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.866F, -34.0F));

        ModelPartData cube_r199 = swirl18.addChild("cube_r199", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r200 = swirl18.addChild("cube_r200", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r201 = swirl18.addChild("cube_r201", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r202 = swirl18.addChild("cube_r202", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r203 = swirl18.addChild("cube_r203", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r204 = swirl18.addChild("cube_r204", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r205 = swirl18.addChild("cube_r205", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.134F, -7.5F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r206 = swirl18.addChild("cube_r206", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -0.134F, -7.5F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r207 = swirl18.addChild("cube_r207", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r208 = swirl18.addChild("cube_r208", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r209 = swirl18.addChild("cube_r209", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -0.134F, -7.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl28 = modelPartData.addChild("swirl28", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -3.7321F, -7.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.7321F, -35.5F));

        ModelPartData cube_r210 = swirl28.addChild("cube_r210", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r211 = swirl28.addChild("cube_r211", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, -0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r212 = swirl28.addChild("cube_r212", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.866F, -1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r213 = swirl28.addChild("cube_r213", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r214 = swirl28.addChild("cube_r214", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.866F, -1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r215 = swirl28.addChild("cube_r215", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.5F, 0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r216 = swirl28.addChild("cube_r216", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.866F, 1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r217 = swirl28.addChild("cube_r217", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 1.7321F, -6.5F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r218 = swirl28.addChild("cube_r218", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.866F, 1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r219 = swirl28.addChild("cube_r219", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.5F, 0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r220 = swirl28.addChild("cube_r220", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData swirl10 = modelPartData.addChild("swirl10", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.866F, -37.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.866F, -7.0F));

        ModelPartData cube_r221 = swirl10.addChild("cube_r221", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, 0.5F, -37.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r222 = swirl10.addChild("cube_r222", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, -0.5F, -37.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r223 = swirl10.addChild("cube_r223", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, -0.366F, -37.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r224 = swirl10.addChild("cube_r224", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, 0.366F, -37.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r225 = swirl10.addChild("cube_r225", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, 0.5F, -37.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r226 = swirl10.addChild("cube_r226", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, 0.366F, -37.5F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r227 = swirl10.addChild("cube_r227", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.134F, -37.5F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r228 = swirl10.addChild("cube_r228", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -0.134F, -37.5F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r229 = swirl10.addChild("cube_r229", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, -0.5F, -37.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r230 = swirl10.addChild("cube_r230", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, -0.366F, -37.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r231 = swirl10.addChild("cube_r231", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -0.134F, -37.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl14 = modelPartData.addChild("swirl14", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.866F, -39.4444F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.866F, -7.0556F));

        ModelPartData cube_r232 = swirl14.addChild("cube_r232", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, 0.5F, -39.4444F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r233 = swirl14.addChild("cube_r233", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, -0.5F, -39.4444F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r234 = swirl14.addChild("cube_r234", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, -0.366F, -39.4444F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r235 = swirl14.addChild("cube_r235", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, 0.366F, -39.4444F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r236 = swirl14.addChild("cube_r236", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, 0.5F, -39.4444F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r237 = swirl14.addChild("cube_r237", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, 0.366F, -39.4444F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r238 = swirl14.addChild("cube_r238", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.134F, -39.4444F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r239 = swirl14.addChild("cube_r239", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -0.134F, -39.4444F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r240 = swirl14.addChild("cube_r240", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, -0.5F, -39.4444F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r241 = swirl14.addChild("cube_r241", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, -0.366F, -39.4444F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r242 = swirl14.addChild("cube_r242", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -0.134F, -39.4444F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl25 = modelPartData.addChild("swirl25", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.866F, -7.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.866F, -41.0F));

        ModelPartData cube_r243 = swirl25.addChild("cube_r243", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r244 = swirl25.addChild("cube_r244", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r245 = swirl25.addChild("cube_r245", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r246 = swirl25.addChild("cube_r246", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r247 = swirl25.addChild("cube_r247", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r248 = swirl25.addChild("cube_r248", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r249 = swirl25.addChild("cube_r249", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.134F, -7.5F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r250 = swirl25.addChild("cube_r250", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -0.134F, -7.5F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r251 = swirl25.addChild("cube_r251", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r252 = swirl25.addChild("cube_r252", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r253 = swirl25.addChild("cube_r253", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -0.134F, -7.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl7 = modelPartData.addChild("swirl7", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -3.7321F, -7.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.7321F, -42.5F));

        ModelPartData cube_r254 = swirl7.addChild("cube_r254", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r255 = swirl7.addChild("cube_r255", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, -0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r256 = swirl7.addChild("cube_r256", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.866F, -1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r257 = swirl7.addChild("cube_r257", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r258 = swirl7.addChild("cube_r258", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.866F, -1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r259 = swirl7.addChild("cube_r259", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.5F, 0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r260 = swirl7.addChild("cube_r260", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.866F, 1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r261 = swirl7.addChild("cube_r261", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 1.7321F, -6.5F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r262 = swirl7.addChild("cube_r262", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.866F, 1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r263 = swirl7.addChild("cube_r263", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.5F, 0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r264 = swirl7.addChild("cube_r264", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData swirl8 = modelPartData.addChild("swirl8", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -3.7321F, -7.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.7321F, -45.5F));

        ModelPartData cube_r265 = swirl8.addChild("cube_r265", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r266 = swirl8.addChild("cube_r266", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, -0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r267 = swirl8.addChild("cube_r267", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.866F, -1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r268 = swirl8.addChild("cube_r268", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r269 = swirl8.addChild("cube_r269", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.866F, -1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r270 = swirl8.addChild("cube_r270", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.5F, 0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r271 = swirl8.addChild("cube_r271", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.866F, 1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r272 = swirl8.addChild("cube_r272", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 1.7321F, -6.5F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r273 = swirl8.addChild("cube_r273", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.866F, 1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r274 = swirl8.addChild("cube_r274", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.5F, 0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r275 = swirl8.addChild("cube_r275", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData swirl26 = modelPartData.addChild("swirl26", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.866F, -7.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.866F, -44.0F));

        ModelPartData cube_r276 = swirl26.addChild("cube_r276", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r277 = swirl26.addChild("cube_r277", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r278 = swirl26.addChild("cube_r278", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r279 = swirl26.addChild("cube_r279", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r280 = swirl26.addChild("cube_r280", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r281 = swirl26.addChild("cube_r281", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r282 = swirl26.addChild("cube_r282", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.134F, -7.5F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r283 = swirl26.addChild("cube_r283", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -0.134F, -7.5F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r284 = swirl26.addChild("cube_r284", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r285 = swirl26.addChild("cube_r285", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r286 = swirl26.addChild("cube_r286", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -0.134F, -7.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl27 = modelPartData.addChild("swirl27", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.866F, -7.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.866F, -47.0F));

        ModelPartData cube_r287 = swirl27.addChild("cube_r287", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r288 = swirl27.addChild("cube_r288", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r289 = swirl27.addChild("cube_r289", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r290 = swirl27.addChild("cube_r290", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r291 = swirl27.addChild("cube_r291", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.134F, 0.5F, -7.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r292 = swirl27.addChild("cube_r292", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.366F, 0.366F, -7.5F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r293 = swirl27.addChild("cube_r293", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.134F, -7.5F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r294 = swirl27.addChild("cube_r294", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -0.134F, -7.5F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r295 = swirl27.addChild("cube_r295", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.134F, -0.5F, -7.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r296 = swirl27.addChild("cube_r296", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.366F, -0.366F, -7.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r297 = swirl27.addChild("cube_r297", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -0.134F, -7.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl9 = modelPartData.addChild("swirl9", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -3.7321F, -7.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.7321F, -48.5F));

        ModelPartData cube_r298 = swirl9.addChild("cube_r298", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r299 = swirl9.addChild("cube_r299", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, -0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r300 = swirl9.addChild("cube_r300", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.866F, -1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r301 = swirl9.addChild("cube_r301", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r302 = swirl9.addChild("cube_r302", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.866F, -1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r303 = swirl9.addChild("cube_r303", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.5F, 0.866F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r304 = swirl9.addChild("cube_r304", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.866F, 1.5F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r305 = swirl9.addChild("cube_r305", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 1.7321F, -6.5F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r306 = swirl9.addChild("cube_r306", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.866F, 1.5F, -6.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r307 = swirl9.addChild("cube_r307", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.5F, 0.866F, -6.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r308 = swirl9.addChild("cube_r308", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.7321F, 0.0F, -6.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData swirl11 = modelPartData.addChild("swirl11", ModelPartBuilder.create().uv(-1, 0).cuboid(-1.5F, -5.5981F, -7.5F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.5981F, -50.0F));

        ModelPartData cube_r309 = swirl11.addChild("cube_r309", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.366F, -3.366F, -7.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r310 = swirl11.addChild("cube_r310", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.866F, -2.2321F, -7.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r311 = swirl11.addChild("cube_r311", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.5981F, -0.5F, -7.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r312 = swirl11.addChild("cube_r312", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.366F, 1.366F, -7.5F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r313 = swirl11.addChild("cube_r313", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.2321F, 2.866F, -7.5F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r314 = swirl11.addChild("cube_r314", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 3.5981F, -7.5F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r315 = swirl11.addChild("cube_r315", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.366F, 3.366F, -7.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r316 = swirl11.addChild("cube_r316", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.866F, 2.2321F, -7.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r317 = swirl11.addChild("cube_r317", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.5981F, 0.5F, -7.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r318 = swirl11.addChild("cube_r318", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.366F, -1.366F, -7.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r319 = swirl11.addChild("cube_r319", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.2321F, -2.866F, -7.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl13 = modelPartData.addChild("swirl13", ModelPartBuilder.create().uv(-1, 0).cuboid(-1.5F, -5.5981F, -7.5F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.5981F, -52.0F));

        ModelPartData cube_r320 = swirl13.addChild("cube_r320", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.366F, -3.366F, -7.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r321 = swirl13.addChild("cube_r321", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.866F, -2.2321F, -7.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r322 = swirl13.addChild("cube_r322", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.5981F, -0.5F, -7.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r323 = swirl13.addChild("cube_r323", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.366F, 1.366F, -7.5F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r324 = swirl13.addChild("cube_r324", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.2321F, 2.866F, -7.5F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r325 = swirl13.addChild("cube_r325", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 3.5981F, -7.5F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r326 = swirl13.addChild("cube_r326", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.366F, 3.366F, -7.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r327 = swirl13.addChild("cube_r327", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.866F, 2.2321F, -7.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r328 = swirl13.addChild("cube_r328", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.5981F, 0.5F, -7.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r329 = swirl13.addChild("cube_r329", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.366F, -1.366F, -7.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r330 = swirl13.addChild("cube_r330", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.2321F, -2.866F, -7.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl3 = modelPartData.addChild("swirl3", ModelPartBuilder.create().uv(-1, 0).cuboid(-1.5F, -5.5981F, -7.5F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.5981F, -54.0F));

        ModelPartData cube_r331 = swirl3.addChild("cube_r331", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.366F, -3.366F, -7.5F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r332 = swirl3.addChild("cube_r332", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.866F, -2.2321F, -7.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r333 = swirl3.addChild("cube_r333", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.5981F, -0.5F, -7.5F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r334 = swirl3.addChild("cube_r334", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.366F, 1.366F, -7.5F, 0.0F, 0.0F, -2.0944F));

        ModelPartData cube_r335 = swirl3.addChild("cube_r335", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.2321F, 2.866F, -7.5F, 0.0F, 0.0F, -2.618F));

        ModelPartData cube_r336 = swirl3.addChild("cube_r336", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 3.5981F, -7.5F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r337 = swirl3.addChild("cube_r337", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.366F, 3.366F, -7.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r338 = swirl3.addChild("cube_r338", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.866F, 2.2321F, -7.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r339 = swirl3.addChild("cube_r339", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.5981F, 0.5F, -7.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r340 = swirl3.addChild("cube_r340", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.366F, -1.366F, -7.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r341 = swirl3.addChild("cube_r341", ModelPartBuilder.create().uv(-1, 0).cuboid(-2.0F, -2.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.2321F, -2.866F, -7.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData swirl12 = modelPartData.addChild("swirl12", ModelPartBuilder.create().uv(0, 0).cuboid(-1.7514F, -7.8947F, -7.5385F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.2486F, 6.8947F, -55.4615F));

        ModelPartData cube_r342 = swirl12.addChild("cube_r342", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -4.0F, -2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.2155F, -0.4306F, -5.5385F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r343 = swirl12.addChild("cube_r343", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -4.0F, -2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.7514F, -2.1627F, -5.5385F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r344 = swirl12.addChild("cube_r344", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -4.0F, -2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.4834F, -3.4306F, -5.5385F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r345 = swirl12.addChild("cube_r345", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -4.0F, -2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.2486F, -2.1627F, -5.5385F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r346 = swirl12.addChild("cube_r346", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -4.0F, -2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.9807F, -3.4306F, -5.5385F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r347 = swirl12.addChild("cube_r347", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-2.0F, 2.0F, -2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.7514F, 1.3014F, -5.5385F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r348 = swirl12.addChild("cube_r348", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-2.0F, 2.0F, -1.0F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 0).mirrored().cuboid(-2.0F, 2.0F, -2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.4834F, 2.5694F, -5.5385F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r349 = swirl12.addChild("cube_r349", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-2.0F, 2.0F, -2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.2486F, 3.0335F, -5.5385F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r350 = swirl12.addChild("cube_r350", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-2.0F, 2.0F, -2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.9807F, 2.5694F, -5.5385F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r351 = swirl12.addChild("cube_r351", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-2.0F, 2.0F, -2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.2486F, 1.3014F, -5.5385F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r352 = swirl12.addChild("cube_r352", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-2.0F, 2.0F, -2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.7127F, -0.4306F, -5.5385F, 0.0F, 0.0F, -1.5708F));

        ModelPartData swirl4 = modelPartData.addChild("swirl4", ModelPartBuilder.create().uv(0, 0).cuboid(-1.7514F, -7.8947F, -7.5385F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.2486F, 6.8947F, -57.4615F));

        ModelPartData cube_r353 = swirl4.addChild("cube_r353", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -4.0F, -2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.2155F, -0.4306F, -5.5385F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r354 = swirl4.addChild("cube_r354", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -4.0F, -2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.7514F, -2.1627F, -5.5385F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r355 = swirl4.addChild("cube_r355", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -4.0F, -2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.4834F, -3.4306F, -5.5385F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r356 = swirl4.addChild("cube_r356", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -4.0F, -2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.2486F, -2.1627F, -5.5385F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r357 = swirl4.addChild("cube_r357", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -4.0F, -2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.9807F, -3.4306F, -5.5385F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r358 = swirl4.addChild("cube_r358", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-2.0F, 2.0F, -2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.7514F, 1.3014F, -5.5385F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r359 = swirl4.addChild("cube_r359", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-2.0F, 2.0F, -1.0F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 0).mirrored().cuboid(-2.0F, 2.0F, -2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.4834F, 2.5694F, -5.5385F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r360 = swirl4.addChild("cube_r360", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-2.0F, 2.0F, -2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.2486F, 3.0335F, -5.5385F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r361 = swirl4.addChild("cube_r361", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-2.0F, 2.0F, -2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.9807F, 2.5694F, -5.5385F, 0.0F, 0.0F, -0.5236F));

        ModelPartData cube_r362 = swirl4.addChild("cube_r362", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-2.0F, 2.0F, -2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.2486F, 1.3014F, -5.5385F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r363 = swirl4.addChild("cube_r363", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-2.0F, 2.0F, -2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.7127F, -0.4306F, -5.5385F, 0.0F, 0.0F, -1.5708F));

        ModelPartData swirl5 = modelPartData.addChild("swirl5", ModelPartBuilder.create().uv(-3, 0).cuboid(-2.5F, -9.3301F, -7.5F, 5.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.3301F, -59.0F));

        ModelPartData cube_r364 = swirl5.addChild("cube_r364", ModelPartBuilder.create().uv(-3, 0).cuboid(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.8301F, -3.366F, -6.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r365 = swirl5.addChild("cube_r365", ModelPartBuilder.create().uv(84, 101).cuboid(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-5.9641F, -7.3301F, -6.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r366 = swirl5.addChild("cube_r366", ModelPartBuilder.create().uv(-3, 0).cuboid(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-9.3301F, 1.5F, -6.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r367 = swirl5.addChild("cube_r367", ModelPartBuilder.create().uv(-3, 0).cuboid(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-7.3301F, 5.9641F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r368 = swirl5.addChild("cube_r368", ModelPartBuilder.create().uv(-3, 0).cuboid(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.366F, 8.8301F, -6.5F, 0.0F, 0.0F, 0.5236F));

        ModelPartData cube_r369 = swirl5.addChild("cube_r369", ModelPartBuilder.create().uv(-3, 0).cuboid(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, 7.3301F, -6.5F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r370 = swirl5.addChild("cube_r370", ModelPartBuilder.create().uv(-3, 0).cuboid(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.366F, 7.0981F, -6.5F, 0.0F, 0.0F, 2.618F));

        ModelPartData cube_r371 = swirl5.addChild("cube_r371", ModelPartBuilder.create().uv(-3, 0).cuboid(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(5.5981F, 4.9641F, -6.5F, 0.0F, 0.0F, 2.0944F));

        ModelPartData cube_r372 = swirl5.addChild("cube_r372", ModelPartBuilder.create().uv(-3, 0).cuboid(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(7.3301F, 1.5F, -6.5F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r373 = swirl5.addChild("cube_r373", ModelPartBuilder.create().uv(-3, 0).cuboid(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(7.0981F, -2.366F, -6.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r374 = swirl5.addChild("cube_r374", ModelPartBuilder.create().uv(-3, 0).cuboid(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(4.9641F, -5.5981F, -6.5F, 0.0F, 0.0F, 0.5236F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        this.swirl35.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl34.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl33.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl31.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl30.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl29.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl23.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl22.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl21.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl32.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl20.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl19.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl6.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl15.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl16.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl24.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl17.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl18.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl28.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl10.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl14.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl25.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl7.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl8.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl26.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl27.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl9.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl11.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl13.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl3.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl12.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl4.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.swirl5.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}