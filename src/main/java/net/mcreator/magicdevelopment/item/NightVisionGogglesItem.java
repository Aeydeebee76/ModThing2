
package net.mcreator.magicdevelopment.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.magicdevelopment.procedures.NightVisionGogglesHelmetTickEventProcedure;
import net.mcreator.magicdevelopment.MagicdevelopmentModElements;

import java.util.Map;
import java.util.HashMap;

@MagicdevelopmentModElements.ModElement.Tag
public class NightVisionGogglesItem extends MagicdevelopmentModElements.ModElement {
	@ObjectHolder("magicdevelopment:night_vision_goggles_helmet")
	public static final Item helmet = null;
	@ObjectHolder("magicdevelopment:night_vision_goggles_chestplate")
	public static final Item body = null;
	@ObjectHolder("magicdevelopment:night_vision_goggles_leggings")
	public static final Item legs = null;
	@ObjectHolder("magicdevelopment:night_vision_goggles_boots")
	public static final Item boots = null;
	public NightVisionGogglesItem(MagicdevelopmentModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 0;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 5, 6, 0}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 0;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.ender_chest.open"));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.EMERALD, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "night_vision_goggles";
			}

			public float getToughness() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "magicdevelopment:textures/models/armor/goggles__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				super.onArmorTick(itemstack, world, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					NightVisionGogglesHelmetTickEventProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("night_vision_goggles_helmet"));
	}
}
