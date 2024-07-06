package com.almightyfork.unwanted.item.trident;

import com.almightyfork.unwanted.Unwanted;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SpearModel extends Model {
//    public static final ResourceLocation TEXTURE = new ResourceLocation(Unwanted.MODID,"textures/entity/spear_in_hand.png");

    private final ModelPart root;

    public SpearModel(ModelPart p_171016_) {
        super(RenderType::entitySolid);
        this.root = p_171016_;
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition partdefinition1 = partdefinition.addOrReplaceChild("pole", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 28.0F, 1.0F), PartPose.ZERO);
        partdefinition1.addOrReplaceChild("spike1", CubeListBuilder.create().texOffs(4, -5).addBox(0.0F, -5.0F, -2.5F, 0.0F, 8.0F, 5.0F), PartPose.ZERO);
        partdefinition1.addOrReplaceChild("spike2", CubeListBuilder.create().texOffs(4, 0).mirror().addBox(-2.5F, -5.0F, 0.0F, 5.0F, 8.0F, 0.0F), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    public void renderToBuffer(PoseStack p_103919_, VertexConsumer p_103920_, int p_103921_, int p_103922_, float p_103923_, float p_103924_, float p_103925_, float p_103926_) {
        this.root.render(p_103919_, p_103920_, p_103921_, p_103922_, p_103923_, p_103924_, p_103925_, p_103926_);
    }
}
