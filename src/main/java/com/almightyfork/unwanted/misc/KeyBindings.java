package com.almightyfork.unwanted.misc;

import net.minecraft.client.KeyMapping;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public final class KeyBindings {
    public static final KeyBindings KEY_BINDINGS = new KeyBindings();

    private KeyBindings() {

    }

    public final KeyMapping boost = new KeyMapping("key.unwanted.boost",
            KeyConflictContext.IN_GAME, InputConstants.getKey(InputConstants.KEY_B, -1),
            KeyMapping.CATEGORY_MOVEMENT);

    public final KeyMapping craw = new KeyMapping("key.unwanted.craw",
            KeyConflictContext.IN_GAME, InputConstants.getKey(InputConstants.KEY_C, -1),
            KeyMapping.CATEGORY_MOVEMENT);
}
