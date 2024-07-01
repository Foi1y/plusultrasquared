/*
 *	MCreator note:
 *
 *	If you lock base mod element files, you can edit this file and the proxy files
 *	and they won't get overwritten. If you change your mod package or modid, you
 *	need to apply these changes to this file MANUALLY.
 *
 *
 *	If you do not lock base mod element files in Workspace settings, this file
 *	will be REGENERATED on each build.
 *
 */
package net.foi1y.plusultrasquared;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.foi1y.plusultrasquared.network.PlusultrasquaredModVariables;
import net.foi1y.plusultrasquared.init.PlusultrasquaredModProcedures;
import net.foi1y.plusultrasquared.init.PlusultrasquaredModItems;

import net.fabricmc.api.ModInitializer;

public class PlusultrasquaredMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "plusultrasquared";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing PlusultrasquaredMod");

		PlusultrasquaredModItems.load();

		PlusultrasquaredModProcedures.load();

		PlusultrasquaredModVariables.SyncJoin();
		PlusultrasquaredModVariables.SyncChangeWorld();
	}
}
