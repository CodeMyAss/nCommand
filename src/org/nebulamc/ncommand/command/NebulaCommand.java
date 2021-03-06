package org.nebulamc.ncommand.command;

import com.sun.istack.internal.Nullable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Ryan on 1/31/2015
 * <p/>
 * Project: nCommand
 */
public class NebulaCommand {

    String name;
    String[] aliases;
    @Nullable String permission;
    @Nullable String usage;
    @Nullable String desc;
    @Nullable String permmessage;
    Method m;
    Object[] resolvedParameters;

    public NebulaCommand(String name, String[] aliases,String usage, String desc, Method m) {
        this(name, aliases,usage,desc,"",m);
    }

    public NebulaCommand(String name, String[] aliases, String usage,String desc, String permission, Method m) {
         this.name = name;
         this.aliases = aliases;
         this.permission = permission;
         this.m = m;
         this.usage = usage;
         this.desc = desc;
         m.setAccessible(true);
    }

    public void execute(CommandContext cmd) {
        try {
            m.invoke(null, cmd);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermMessage(String permmessage) {
        this.permmessage = permmessage;
    }

    public String getPermMessage() {
        return permmessage;
    }

    public String getName() {
        return name;
    }

    public Method getM() {
        return m;
    }

    public String getDesc() {
        return desc;
    }

    public String getUsage() {
        return usage;
    }

    public String[] getAliases() {
        return aliases;
    }






}
