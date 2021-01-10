package net.mcreator.magicdevelopment.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;

import net.mcreator.magicdevelopment.particle.GodparticleParticle;
import net.mcreator.magicdevelopment.MagicdevelopmentModElements;

import java.util.Map;

@MagicdevelopmentModElements.ModElement.Tag
public class GodHelmetTickEventParticleProcedure extends MagicdevelopmentModElements.ModElement {
	public GodHelmetTickEventParticleProcedure(MagicdevelopmentModElements instance) {
		super(instance, 15);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure GodHelmetTickEventParticle!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure GodHelmetTickEventParticle!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure GodHelmetTickEventParticle!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure GodHelmetTickEventParticle!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(GodparticleParticle.particle, x, y, z, (int) 15, 3, 3, 3, 1);
		}
	}
}
