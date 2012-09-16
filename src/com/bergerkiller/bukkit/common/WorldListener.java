package com.bergerkiller.bukkit.common;

import com.bergerkiller.bukkit.common.reflection.WorldServerRef;

import net.minecraft.server.Entity;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.IWorldAccess;
import net.minecraft.server.World;
import net.minecraft.server.WorldServer;

public class WorldListener implements IWorldAccess {
	public final WorldServer world;
	private boolean isEnabled = false;

	public WorldListener(World world) {
		this.world = (WorldServer) world;
	}

	public static boolean isValid() {
		return WorldServerRef.accessList.isValid();
	}

	public boolean enable() {
		if (isValid()) {
			WorldServerRef.accessList.get(this.world).add(this);
			this.isEnabled = true;
			return true;
		} else {
			return false;
		}
	}

	public boolean disable() {
		if (isValid()) {
			WorldServerRef.accessList.get(this.world).remove(this);
			this.isEnabled = false;
			return true;
		} else {
			return false;
		}
	}

	public boolean isEnabled() {
		return this.isEnabled;
	}

	@Override
	public final void a(Entity arg0) {
		if (arg0 == null)
			return;
		this.onEntityAdd(arg0);
	}

	@Override
	public final void b(Entity arg0) {
		if (arg0 == null)
			return;
		this.onEntityRemove(arg0);
	}

	@Override
	public final void a(int arg0, int arg1, int arg2) {
		this.onNotify(arg0, arg1, arg2);
	}

	@Override
	public void a(int arg0, int arg1, int arg2, int arg3, int arg4) {
	}

	@Override
	public void a(String name, double x, double y, double z, float yaw, float pitch) {
	}

	@Override
	public void a(EntityHuman human, int code, int x, int y, int z, int dat) {
	}

	@Override
	public void a(String name, double arg1, double arg2, double arg3, double arg4, double arg5, double arg6) {
	}

	@Override
	public void b(int x, int y, int z) {
	}

	@Override
	public void a(String name, int x, int y, int z) {
	}

	@Override
	public void a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
	}

	public void onEntityAdd(Entity entity) {
	}

	public void onEntityRemove(Entity entity) {
	}

	public void onNotify(int x, int y, int z) {
	}
}
