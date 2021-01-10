package net.mcreator.magicdevelopment.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.magicdevelopment.MagicdevelopmentModElements;

import java.util.Map;

@MagicdevelopmentModElements.ModElement.Tag
public class ThorsHammerLivingEntityIsHitWithItemProcedure extends MagicdevelopmentModElements.ModElement {
	public ThorsHammerLivingEntityIsHitWithItemProcedure(MagicdevelopmentModElements instance) {
		super(instance, 1);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ThorsHammerLivingEntityIsHitWithItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"/summon minecraft:lightning_bolt");
			}
		}
	}
}
