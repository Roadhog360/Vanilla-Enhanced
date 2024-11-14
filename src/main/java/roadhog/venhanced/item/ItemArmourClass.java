package roadhog.venhanced.item;

import java.lang.annotation.Target;

import roadhog.venhanced.VanillaEnhanced;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;

public class ItemArmourClass extends ItemArmor {

	private String wearingType;

	public ItemArmourClass(ArmorMaterial armourMaterial, int armourType) {
		super(armourMaterial, 0, armourType);
		
	}
	
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		if(par1ItemStack.getItem() == VanillaEnhanced.itemEmeraldHelmet || par1ItemStack.getItem() == VanillaEnhanced.itemEmeraldChestplate || par1ItemStack.getItem() == VanillaEnhanced.itemEmeraldLeggings || par1ItemStack.getItem() == VanillaEnhanced.itemEmeraldBoots){
		return Items.emerald == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemSapphireHelmet || par1ItemStack.getItem() == VanillaEnhanced.itemSapphireChestplate || par1ItemStack.getItem() == VanillaEnhanced.itemSapphireLeggings || par1ItemStack.getItem() == VanillaEnhanced.itemSapphireBoots){
		return VanillaEnhanced.itemSapphire == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemTinHelmet || par1ItemStack.getItem() == VanillaEnhanced.itemTinChestplate || par1ItemStack.getItem() == VanillaEnhanced.itemTinLeggings || par1ItemStack.getItem() == VanillaEnhanced.itemTinBoots) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 0 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemCopperHelmet || par1ItemStack.getItem() == VanillaEnhanced.itemCopperChestplate || par1ItemStack.getItem() == VanillaEnhanced.itemCopperLeggings || par1ItemStack.getItem() == VanillaEnhanced.itemCopperBoots) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 1 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemOsmiumHelmet || par1ItemStack.getItem() == VanillaEnhanced.itemOsmiumChestplate || par1ItemStack.getItem() == VanillaEnhanced.itemOsmiumLeggings || par1ItemStack.getItem() == VanillaEnhanced.itemOsmiumBoots) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 2 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemIridiumHelmet || par1ItemStack.getItem() == VanillaEnhanced.itemIridiumChestplate || par1ItemStack.getItem() == VanillaEnhanced.itemIridiumLeggings || par1ItemStack.getItem() == VanillaEnhanced.itemIridiumBoots) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 3 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemBlaziciteHelmet || par1ItemStack.getItem() == VanillaEnhanced.itemBlaziciteChestplate || par1ItemStack.getItem() == VanillaEnhanced.itemBlaziciteLeggings || par1ItemStack.getItem() == VanillaEnhanced.itemBlaziciteBoots) {
			return VanillaEnhanced.itemIngotBlazicite == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemBronzeHelmet || par1ItemStack.getItem() == VanillaEnhanced.itemBronzeChestplate || par1ItemStack.getItem() == VanillaEnhanced.itemBronzeLeggings || par1ItemStack.getItem() == VanillaEnhanced.itemBronzeBoots) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 4 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemSteelHelmet || par1ItemStack.getItem() == VanillaEnhanced.itemSteelChestplate || par1ItemStack.getItem() == VanillaEnhanced.itemSteelLeggings || par1ItemStack.getItem() == VanillaEnhanced.itemSteelBoots) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 5 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} 
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem() == VanillaEnhanced.itemEmeraldHelmet || stack.getItem() == VanillaEnhanced.itemEmeraldChestplate || stack.getItem() == VanillaEnhanced.itemEmeraldLeggings || stack.getItem() == VanillaEnhanced.itemEmeraldBoots){
			wearingType = "emerald";
		} else if(stack.getItem() == VanillaEnhanced.itemSapphireHelmet || stack.getItem() == VanillaEnhanced.itemSapphireChestplate || stack.getItem() == VanillaEnhanced.itemSapphireLeggings || stack.getItem() == VanillaEnhanced.itemSapphireBoots){
			wearingType = "sapphire";
		} else if(stack.getItem() == VanillaEnhanced.itemTinHelmet || stack.getItem() == VanillaEnhanced.itemTinChestplate || stack.getItem() == VanillaEnhanced.itemTinLeggings || stack.getItem() == VanillaEnhanced.itemTinBoots) {
			wearingType = "tin";	
		} else if(stack.getItem() == VanillaEnhanced.itemCopperHelmet || stack.getItem() == VanillaEnhanced.itemCopperChestplate || stack.getItem() == VanillaEnhanced.itemCopperLeggings || stack.getItem() == VanillaEnhanced.itemCopperBoots) {
			wearingType = "copper";
		} else if(stack.getItem() == VanillaEnhanced.itemOsmiumHelmet || stack.getItem() == VanillaEnhanced.itemOsmiumChestplate || stack.getItem() == VanillaEnhanced.itemOsmiumLeggings || stack.getItem() == VanillaEnhanced.itemOsmiumBoots) {
			wearingType = "osmium";
		} else if(stack.getItem() == VanillaEnhanced.itemIridiumHelmet || stack.getItem() == VanillaEnhanced.itemIridiumChestplate || stack.getItem() == VanillaEnhanced.itemIridiumLeggings || stack.getItem() == VanillaEnhanced.itemIridiumBoots) {
			wearingType = "iridium";
		} else if(stack.getItem() == VanillaEnhanced.itemBlaziciteHelmet || stack.getItem() == VanillaEnhanced.itemBlaziciteChestplate || stack.getItem() == VanillaEnhanced.itemBlaziciteLeggings || stack.getItem() == VanillaEnhanced.itemBlaziciteBoots){
			wearingType = "blazicite";
		} else if(stack.getItem() == VanillaEnhanced.itemBronzeHelmet || stack.getItem() == VanillaEnhanced.itemBronzeChestplate || stack.getItem() == VanillaEnhanced.itemBronzeLeggings || stack.getItem() == VanillaEnhanced.itemBronzeBoots) {
			wearingType = "bronze";
		} else if(stack.getItem() == VanillaEnhanced.itemSteelHelmet || stack.getItem() == VanillaEnhanced.itemSteelChestplate || stack.getItem() == VanillaEnhanced.itemSteelLeggings || stack.getItem() == VanillaEnhanced.itemSteelBoots) {
			wearingType = "steel";
		} 
		if(this.armorType == 2)
			{
			return "venh:textures/models/armor/" + wearingType + "_layer_2.png";
			}
			return "venh:textures/models/armor/" + wearingType + "_layer_1.png";
	}
	
	@Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		if(player.getCurrentArmor(3) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(0) != null) {
			ItemStack boots = player.getCurrentArmor(0);
			ItemStack leggings = player.getCurrentArmor(1);
			ItemStack chestplate = player.getCurrentArmor(2);
			ItemStack helmet = player.getCurrentArmor(3);
			if (helmet.getItem() == VanillaEnhanced.itemSapphireHelmet && chestplate.getItem() == VanillaEnhanced.itemSapphireChestplate && leggings.getItem() == VanillaEnhanced.itemSapphireLeggings && boots.getItem() == VanillaEnhanced.itemSapphireBoots) {
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 2, 0));
			} else if (helmet.getItem() == VanillaEnhanced.itemBlaziciteHelmet && chestplate.getItem() == VanillaEnhanced.itemBlaziciteChestplate && leggings.getItem() == VanillaEnhanced.itemBlaziciteLeggings && boots.getItem() == VanillaEnhanced.itemBlaziciteBoots) {
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 2, 0));
			}
		}
	}
	
	public EnumRarity getRarity(ItemStack itemstack)
    {
		
        return this == VanillaEnhanced.itemBlaziciteHelmet || this == VanillaEnhanced.itemBlaziciteChestplate || this == VanillaEnhanced.itemBlaziciteLeggings || this == VanillaEnhanced.itemBlaziciteBoots ? EnumRarity.uncommon : EnumRarity.common;
    }
}