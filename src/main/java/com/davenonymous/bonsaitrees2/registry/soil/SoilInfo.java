package com.davenonymous.bonsaitrees2.registry.soil;

import com.davenonymous.bonsaitrees2.block.ModObjects;
import com.davenonymous.libnonymous.utils.RecipeDataBase;

import net.minecraft.block.BlockState;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Set;

public class SoilInfo extends RecipeDataBase {

    public Ingredient ingredient;
    public ItemStack result;
    public BlockState renderState;

    public float tickModifier;

    public Set<String> tags;

    public SoilInfo(ResourceLocation id, Ingredient ingredient, BlockState renderState, float tickModifier) {
        super(id);
        this.ingredient = ingredient;
        this.renderState = renderState;
        this.tickModifier = tickModifier;
        this.tags = new HashSet<>();
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public boolean isValidTag(String tag) {
        return this.tags.contains(tag);
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModObjects.soilRecipeSerializer;
    }

    @Override
    public IRecipeType<?> getType() {
        return ModObjects.soilRecipeType;
    }

    public float getTickModifier() {
        return tickModifier;
    }
}
