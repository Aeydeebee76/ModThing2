package net.mcreator.magicdevelopment.procedures;

import net.minecraft.world.GameType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.magicdevelopment.MagicdevelopmentModElements;

import java.util.Map;

@MagicdevelopmentModElements.ModElement.Tag
public class CreativeRunestoneRightClickedInAirProcedure extends MagicdevelopmentModElements.ModElement {
	public CreativeRunestoneRightClickedInAirProcedure(MagicdevelopmentModElements instance) {
		super(instance, 17);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure CreativeRunestoneRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).setGameType(GameType.CREATIVE);
	}
}
