package com.lyghtningwither.honeyfunmods.items.battery;

public class ItemSilverGoldBattery extends ItemNonRechargableBattery {

	public ItemSilverGoldBattery() {
		
		super("silver_gold_battery");
	}

	@Override
	public int getMaxEnergy() {
		
		return 10000;
	}
	
	@Override
	public int getTransferRate() {
		
		return 50;
	}
}
