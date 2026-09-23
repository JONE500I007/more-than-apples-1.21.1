package net.more.apples.render;

import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.Identifier;
import net.more.apples.entity.ModBoats;

// Client side of ModBoats: same model layers/renderers vanilla uses for its boats (ModelLayers.OAK_BOAT, EntityRenderers).
// Layer "boat/<id>" makes BoatRenderer read textures/entity/boat/<id>.png (and chest_boat/<id>.png).
public class ModBoatRenderers {
    public static void register(Identifier boatId) {
        ModelLayerLocation boatLayer = new ModelLayerLocation(boatId.withPrefix("boat/"), "main");
        ModelLayerLocation chestBoatLayer = new ModelLayerLocation(boatId.withPrefix("chest_boat/"), "main");

        ModelLayerRegistry.registerModelLayer(boatLayer, BoatModel::createBoatModel);
        ModelLayerRegistry.registerModelLayer(chestBoatLayer, BoatModel::createChestBoatModel);

        EntityRenderers.register(ModBoats.getBoatType(boatId), context -> new BoatRenderer(context, boatLayer));
        EntityRenderers.register(ModBoats.getChestBoatType(boatId), context -> new BoatRenderer(context, chestBoatLayer));
    }
}
