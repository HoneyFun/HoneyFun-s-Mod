package com.lyghtningwither.honeyfunmods.util.handlers;

import net.minecraft.util.IStringSerializable;

public class EnumHandler {

	public static enum PlanksVariants implements IStringSerializable {
		
		ICE_PLANKS(0, "ice_planks"),
		SILVER_PLANKS(1, "silver_planks");
		
		private static final PlanksVariants[] META_LOOKUP = new PlanksVariants[values().length];
		private final int meta;
		private final String name, unlocalizedName;
		
		private PlanksVariants(int meta, String name) {
			
			this(meta, name, name);
		}
		
		private PlanksVariants(int meta, String name, String unlocalizedName) {
			
			this.meta = meta;
			this.name = name;
			this.unlocalizedName = unlocalizedName;
		}
		
		@Override
		public String getName() {
			
			return this.name;
		}
		
		public int getMeta() {
			
			return meta;
		}
		
		public String getUnlocalizedName() {
			
			return unlocalizedName;
		}
		@Override
		public String toString() {
			
			return super.toString();
		}
		public static PlanksVariants byMetaData(int meta) {
			
			return META_LOOKUP[meta];
		}
		static {
			
			for(PlanksVariants enumtype: values()) {
				
				META_LOOKUP[enumtype.getMeta()] = enumtype;
			}
		}
	}
	
	public static enum WoodVariants implements IStringSerializable {
		
		ICE_LOG(0, "ice"),
		SILVER_LOG(1, "silver");
		
		private static final WoodVariants[] META_LOOKUP = new WoodVariants[values().length];
		private final int meta;
		private final String name, unlocalizedName;
		
		private WoodVariants(int meta, String name) {
			
			this(meta, name, name);
		}
		
		private WoodVariants(int meta, String name, String unlocalizedName) {
			
			this.meta = meta;
			this.name = name;
			this.unlocalizedName = unlocalizedName;
		}
		
		@Override
		public String getName() {
			
			return this.name;
		}
		
		public int getMeta() {
			
			return meta;
		}
		
		public String getUnlocalizedName() {
			
			return unlocalizedName;
		}
		@Override
		public String toString() {
			
			return super.toString();
		}
		public static WoodVariants byMetaData(int meta) {
			
			return META_LOOKUP[meta];
		}
		static {
			
			for(WoodVariants enumtype: values()) {
				
				META_LOOKUP[enumtype.getMeta()] = enumtype;
			}
		}
	}
}

